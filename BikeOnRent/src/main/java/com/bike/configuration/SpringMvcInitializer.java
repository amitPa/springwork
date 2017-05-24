/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bike.configuration;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author AmitPandey
 */
public class SpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
       // return new Class[]{AppConfig.class};
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
      //  return new Class[] { WebConfig.class };
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
   
}
