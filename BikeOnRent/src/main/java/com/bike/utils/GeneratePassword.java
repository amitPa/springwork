/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bike.utils;

/**
 *
 * @author AmitPandey
 */
import java.security.SecureRandom;
import java.util.Random;

public class GeneratePassword {

    private static final Random RANDOM = new SecureRandom();
    public static final int PASSWORD_LENGTH = 50;

    /**
     * This method generates a random password of 8 characters in length
     * @return 
     */
    public static String randomPassword() {
        String letters = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ23456789@";
        String pw = "";
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            int index = (int) (RANDOM.nextDouble() * letters.length());
            pw += letters.substring(index, index + 1);
        }
        return pw;
    }
}

