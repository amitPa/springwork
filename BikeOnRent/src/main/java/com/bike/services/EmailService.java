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
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


@Component
public class EmailService {


    private String username="Bike On Rent <mindfireprojects@gmail.com>";

    @Autowired
    private JavaMailSender mailSender;

    /**
     * This method triggers the email in background thread i.e. the mail is sent
     * asynchronously
     *
     * @param to Email to whom mail has to be sent
     * @param subject Subject of the email Messages
     * @param msg Message body to be sent along with email
     * @throws InterruptedException
     */
    @Async
    public void sendMail(String to, String subject, String msg) throws InterruptedException {
        try {

            MimeMessage message = mailSender.createMimeMessage();
            message.setSubject(subject);
            message.setHeader("Content-Type", "text/html; charset=UTF-8");
            MimeMessageHelper helper;
            helper = new MimeMessageHelper(message, true);
            helper.setFrom(username);
            helper.setTo(to);
            helper.setText(msg, true);
            mailSender.send(message);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }

}
