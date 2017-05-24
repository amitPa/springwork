/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bike.configuration;

/**
 *
 * @author AmitPandey
 */
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
 
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
   public SecurityWebApplicationInitializer(){
       super(SecurityConfiguration.class);
   }
}
