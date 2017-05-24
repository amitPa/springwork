/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bike.services;

/**
 *
 * @author AmitPandey
 */
import com.bike.model.User;
import com.bike.constants.BikeConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Notification {

    @Value("${bike.domain}")
    private String domain;

    @Autowired
    EmailService email;

    public void sendWelcomeMail(User user) {

        try {
            email.sendMail(user.getUserEmail(),
                    BikeConstants.WELCOME_MAIL_SUBJECT,
                    BikeConstants.WELCOME_MAIL_BODY.replaceAll(BikeConstants.TAG_USER_NAME, user.getUserName()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     public void sendCancelMail(User user,String bookingId) {

        try {
            email.sendMail(user.getUserEmail(),
                    BikeConstants.CANCELLED_MAIL_SUBJECT,
                    BikeConstants.CANCEL_MAIL_BODY
                            .replaceAll(BikeConstants.TAG_USER_NAME, user.getUserName())
                            .replaceAll(BikeConstants.TAG_BOOKING, bookingId));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
    public void sendForgotPasswordEmail(User user, String tempPassword) {

        try {
            System.out.println(user.getUserName() + "  " + tempPassword + "   " + user.getUserEmail() + "   " + domain);
            email.sendMail(user.getUserEmail(),
                    BikeConstants.FORGOT_PASSWORD_MAIL_SUBJECT,
                    BikeConstants.FORGOT_PASSWORD_MAIL_BODY
                    .replaceAll(BikeConstants.TAG_USER_NAME, user.getUserName())
                    .replaceAll(BikeConstants.TAG_TEMP_PASSWORD, tempPassword)
                    .replaceAll(BikeConstants.TAG_DOMAIN,domain)
                    .replaceAll(BikeConstants.TAG_USER_EMAIL, user.getUserEmail()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
