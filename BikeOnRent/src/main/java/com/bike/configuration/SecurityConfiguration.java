/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bike.configuration;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author AmitPandey
 */
@Configuration
@EnableWebSecurity
@ComponentScan({"com.bike"})
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("::"+auth.getDefaultUserDetailsService());
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select email,password, enabled from user where email=?")
                .authoritiesByUsernameQuery("select email,role, enabled from user where email=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/user/**").access("hasRole('ROLE_ADMIN') OR hasRole('ROLE_USER')")
                .and()
                .formLogin().loginPage("/welcome").loginProcessingUrl("/checkUser").failureUrl("/welcome")
                .defaultSuccessUrl("/user")
                .usernameParameter("userEmail").passwordParameter("userPassword")
                .permitAll()
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/welcome")
                .and()
                .exceptionHandling().accessDeniedPage("/403")
                .and()
                .csrf().disable();

    }
}
