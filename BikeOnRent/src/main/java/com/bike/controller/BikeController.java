/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bike.controller;

import org.springframework.stereotype.Controller;
import com.google.gson.Gson;
import com.bike.model.User;
import com.bike.services.BicycleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.bike.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.bike.constants.BikeConstants;
import com.bike.model.Booking;
import com.bike.services.BookingService;
import com.bike.services.Notification;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.BASE64Decoder;

/**
 *
 * @author AmitPandey
 */
@Controller
@SessionAttributes(BikeConstants.SESSION)
public class BikeController {

    @Autowired
    UserService userService;

    @Autowired
    BookingService bookingService;

    @Autowired
    BicycleService bicycleService;

    @Autowired
    private Notification notification;

    private final String MUSIC_PATH = "E:\\Image\\";
    BASE64Decoder decoder = new BASE64Decoder();

    @RequestMapping(value = "/checkUser2", method = RequestMethod.POST)
    @ResponseBody
    public String checkUser(User user, HttpSession sessionObj) {
        ModelAndView modelView = new ModelAndView();
        Gson gson = new Gson();
        User checkUser = userService.checkUser(user);//gson.fromJson(user, User.class));
        if (checkUser != null) {
            sessionObj.setAttribute(BikeConstants.SESSION, checkUser);
            // modelView.addObject(BikeConstants.SESSION, checkUser);
            //modelView.setViewName("checkSession");
            return gson.toJson(checkUser);
        } else {
            return "{\"login\": false}";
            //return new ModelAndView("login", BikeConstants.DATA, BikeConstants.INVALID_USER);
        }
    }

    @RequestMapping(value = "/checkSession", method = RequestMethod.GET)
    public String checkSession() {
        return "checkSession";
    }

    @RequestMapping(value = "/logout2", method = RequestMethod.GET)
    @ResponseBody
    public String redirectHome(HttpSession session) {
        if (session.getAttribute(BikeConstants.SESSION) != null) {
            session.invalidate();
            return "{\"logout\": true}";
        }
        return "{\"logout\": false}";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView home() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        User userSession = userService.findUserByEmail(email);
        return new ModelAndView("home", BikeConstants.SESSION, userSession);
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    @ResponseBody
    public String setUserSessionFrontend(HttpServletRequest request) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User userSession = (User) auth.getPrincipal();

        HttpSession session = request.getSession();
        User userSession = (User) session.getAttribute(BikeConstants.SESSION);
        System.out.println(userSession);
        Gson gson = new Gson();
        String json = gson.toJson(userSession);
        return json;
    }

    @RequestMapping(value = "/fetchBicycles", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getBicycleList() {
        Gson gson = new Gson();
        String json = gson.toJson(bicycleService.getBicycleList());
        return json;
    }

    @RequestMapping(value = "/fetchBooking", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getBookingList() {
        Gson gson = new Gson();
        String json = gson.toJson(bookingService.getBookingList());
        return json;
    }

    @RequestMapping(value = "/booking", method = RequestMethod.POST)
    @ResponseBody
    public String insertBooking(@RequestBody final String booking, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User userSession = (User) session.getAttribute(BikeConstants.SESSION);
        Gson gson = new Gson();
        Booking book = gson.fromJson(booking, Booking.class);
        book.setBicycleUserId(userSession.getUserId());
        book.setBicycleCreatedDateTime(new Date());
        try {
            if ((BikeConstants.FORMAT).parse(book.getBicycleCreatedDateTime()).after((BikeConstants.FORMAT).parse(book.getBicyclePickUpTime()))) {
                return "{\"booked\": false}";
            }
        } catch (Exception e) {
            System.out.println("error");
        }
        bookingService.insertData(book);
        return "{\"booked\": true}";
    }

    @RequestMapping(value = "/cancelBooking", method = RequestMethod.POST)
    @ResponseBody
    public String updateBooking(@RequestBody final String id, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(BikeConstants.SESSION);
        bookingService.updateBooking(id);
        notification.sendCancelMail(user, id);
        return "{\"cancel\": true}";
    }

    @RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
    @ResponseBody
    public String updateProfile(HttpServletRequest request) {
        String field = request.getParameter("field");
        String value = request.getParameter("value");
        HttpSession session = request.getSession();
        int id = ((User) session.getAttribute(BikeConstants.SESSION)).getUserId();
        userService.updateUserProfile(field, value, id);
        System.out.println(field + "  " + value);
        return "{\"respon\": true}";
    }

    @RequestMapping(value = "/updateChangePassword", method = RequestMethod.POST)
    @ResponseBody
    public String updateChangePassword(HttpServletRequest request) {
        String password = request.getParameter("password");
        String newPassword = request.getParameter("confirmPassword");
        HttpSession session = request.getSession();
        int id = ((User) session.getAttribute(BikeConstants.SESSION)).getUserId();
        boolean checkUser = userService.updateChangePassword(newPassword, password, id) > 0;
        return "{\"respon\": " + checkUser + "}";

    }

    @RequestMapping(value = "/uploadProfileImage", method = RequestMethod.POST)
    public void imageUpload(HttpServletRequest request,
            HttpServletResponse responses) {
        try {
            //mRequest = (MultipartHttpServletRequest) request;
            String base64String = request.getParameter("fileUpload");
            byte[] decodedBytes = decoder.decodeBuffer(base64String);
            ByteArrayInputStream bis = new ByteArrayInputStream(decodedBytes);
            BufferedImage image = ImageIO.read(bis);
            if (image == null) {
                System.out.println("Buffered Image is null");
            }
            File f = new File(MUSIC_PATH+"\\123.png");
            System.out.println("Amitpp");
            ImageIO.write(image, "png", f);
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(BikeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Amit");
    }

    @RequestMapping(value = "/uploadProfileImages")
    @ResponseBody
    public void imageUpload(HttpServletRequest rq) {
        System.out.println("Ajitab");
        System.out.println("Amit");
    }

}
