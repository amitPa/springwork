/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bike.controller;

import org.springframework.stereotype.Controller;
import com.google.gson.Gson;
import com.bike.model.User;
import com.bike.model.Bicycle;
import com.bike.services.BicycleService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.bike.services.UserService;
import com.bike.utils.GeneratePassword;
import javax.validation.Validation;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bike.services.Notification;
import com.bike.utils.ResourceNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.bike.constants.BikeConstants;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author AmitPandey
 */
@Controller
public class IndexController {

    @Autowired
    UserService userService;

    @Autowired
    BicycleService bicycleService;

    @Autowired
    private Notification notification;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public String inserData(@RequestBody final String user) {
        Gson gson = new Gson();
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        User s = gson.fromJson(user, User.class);
        System.out.print("Form values" + s);
        if (user != null) {
            User check = userService.findUserByEmail(s.getUserEmail());

            if (check == null) {
                userService.insertData(s);
                notification.sendWelcomeMail(s);
            } else {
                return "failure";
            }
        }
        return "success";
        //return "amit";
    }

    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView resetPassword(String id, String email, String password) {
        User user = userService.findUserByEmail(email);
        user.setUserPassword(password);
        if (user != null) {
            userService.updatePassword(user);
            return new ModelAndView("redirect:/");
        }
        return new ModelAndView("changePassword.jsp?errorMsg=AreYouDeveloper");
        //return "amit";
    }

    @RequestMapping(value = "/getList", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getUserList() {
        List<User> userList = new ArrayList<User>();
        Gson gson = new Gson();
        String json = gson.toJson(userService.getUserList());
        return json;
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String redirectHome(HttpSession session) {
        if (session.getAttribute(BikeConstants.SESSION) != null) {
            return "redirect:user";
        }
        return "/welcome";
    }

    /**
     *
     *
     * @param userEmail
     * @return
     */
    @RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
    @ResponseBody
    public String forgotPassword(@RequestBody final String userEmail) {

        //Find user by email
        User user = userService.findUserByEmail(userEmail.toLowerCase());
        if (user != null) {
            String temporaryPassword = GeneratePassword.randomPassword();//Generate Random Password
            user.setUserChangePassword(temporaryPassword);
            userService.updateData(user);
            notification.sendForgotPasswordEmail(user, temporaryPassword);//Trigger forgot Password Email
            return "success";
        }
        return "failure";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView resetPassword(String id, String email) {

        //Find user by email
        User user = userService.findUserByEmail(email);
        if (user != null && user.getUserChangePassword().equals(id)) {
            Date tokenDate = user.getUserTokenTimestamp();
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date curDate = new Date();
            long diffHours = (curDate.getTime() - tokenDate.getTime()) / (60 * 60 * 1000) % 24;
            long milliSeonds = ((curDate.getTime() - tokenDate.getTime()) / (60 * 60 * 1000)) - 24 * 60 * 60 * 1000;

            if (diffHours <= 24 && milliSeonds <= 0) {

                ModelAndView modelAndView = new ModelAndView("changePassword");
                modelAndView.addObject("id", user.getUserId());
                return modelAndView;

            } else {
                return new ModelAndView("tokenMessage", "data", "Token Time Has Expired Please SignIn Or Do Forgot Password");
            }
        }
        return new ModelAndView("tokenMessage", "data", "Not a valid Url Please SignIn Or Do Forgot Password");
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accesssDenied() {
      return "403";
    }
    
    @ExceptionHandler(Throwable.class)
    public String handleAnyException(Throwable ex, HttpServletRequest request) {
        return ClassUtils.getShortName(ex.getClass());
    }
}
