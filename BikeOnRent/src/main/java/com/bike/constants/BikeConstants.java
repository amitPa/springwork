/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bike.constants;

import java.text.SimpleDateFormat;

/**
 *
 * @author AmitPandey
 */
/**
 * Created Date: 20 April 2016
 * Last Modified Date: 2 May 2016
 */

public interface BikeConstants {
    
    public static final String SUCCESS="success";
    public static final String FAILURE="failure";
    public static final String EMAIL_EXISTS="Email exists";
    public static final String SESSION ="BikeOnRent";
    public static final String INVALID_USER ="Invaid Credentials";
    public static final String DATA="data";
    /*MAIL CONSTANTS*/
    public static final String CANCEL_MAIL_BODY="<center><h2>Bike On Rent</h2></center><br><br><h4>Hi  <<userName>>"
            + "<br><br>Booking id <<bookingid>> has been cancelled </h4><br><h5>"
            + "Book again with us"
            + "Your convenience is our priority.<br><br><b>Cheers,<br>Team BOR</b></h5>";
    
    public static final String WELCOME_MAIL_BODY = "<center><h2>Bike On Rent</h2></center><br><br><h4>Hi  <<userName>>"
            + "<br><br>WELCOME ! We are excited to have you on board with us.</h4><br><h5>"
            + "Transform the way you travel. No more haggling with auto and still pay less! "
            + "Your convenience is our priority.<br><br><b>Cheers,<br>Team BOR</b></h5>";
    public static final String WELCOME_MAIL_SUBJECT = "Welcome to BOR";
    
    public static final String CANCELLED_MAIL_SUBJECT = "BOR Booking Cancelled";

    public static final String FORGOT_PASSWORD_MAIL_BODY = "<center><h2>Bike On Rent</h2></center><br><br><h4>Hi <<userName>>"
            + ",<br><br><h4>"
            + "We received a request to reset your password. If you made a request then click below to change else please ignore this email."
            + "<br><center><a href=\"<<Domain>>index.html?id=<<tempPassword>>&email=<<userEmail>>\">"
            + "Click Here to Change Password</a></center><br><br>Your convenience is our priority.<br><br><b>Cheers,<br>Team BOR<br> Amit Pandey</b></h4>";
    public static final String FORGOT_PASSWORD_MAIL_SUBJECT = "BOR Forgot Password";
    
    public static final String PATTERN = "YYYY-MM-dd HH:mm:ss";
    public static final SimpleDateFormat FORMAT = new SimpleDateFormat(PATTERN);

    /*TAGS USED IN THE SHUTTLE APP*/
    public static final String TAG_USER_NAME = "<<userName>>";
    public static final String TAG_TEMP_PASSWORD = "<<tempPassword>>";
    public static final String TAG_USER_EMAIL = "<<userEmail>>";
    public static final String TAG_DOMAIN="<<Domain>>";
    public static final String TAG_BOOKING="<<bookingid>>";

    

    /*HASHING CONSTANTS*/
    public static final String SALT = "$2a$12$nqfG9jIkLm8th3OpoxX8a.";
    
    /*Produces Constant*/
    public static final String PRODUCES_JSON="application/json";
    
}
