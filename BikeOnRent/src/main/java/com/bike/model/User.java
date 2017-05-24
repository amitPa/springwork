/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bike.model;

import java.util.Date;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author AmitPandey
 */
public class User {

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserContact() {
        return userContact;
    }

    public void setUserContact(String userContact) {
        this.userContact = userContact;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserChangePassword() {
        return userChangePassword;
    }

    public void setUserChangePassword(String userChangePassword) {
        this.userChangePassword = userChangePassword;
    }

     public Date getUserTokenTimestamp() {
        return userTokenTimestamp;
    }

    public void setUserTokenTimestamp(Date userTokenTimestamp) {
        this.userTokenTimestamp = userTokenTimestamp;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword=" + userPassword + ", userContact=" + userContact + ", userGender=" + userGender + ", userChangePassword=" + userChangePassword + ", userAge=" + userAge + ", userTokenTimestamp=" + userTokenTimestamp + '}';
    }
    
    

    private int userId;
    @Size(min = 3, max = 100, message = "Name must be atleast 3 characters in length and less than 100 characters")
    private String userName;
    @Email
    private String userEmail;
    @NotNull
    @Size(min = 8, max = 100, message = "Password must be atleast 8 characters in length and less than 100 characters")
    private String userPassword;
    @Digits(integer = 10, fraction = 0, message = "Phone number cannot be more than 10 digits")
    private String userContact;
    private String userGender;
    private String userChangePassword = "Not Changed";
    private int userAge;
    private Date userTokenTimestamp;

   

}
