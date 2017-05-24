/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bike.jdbc;

import com.bike.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
/**
 *
 * @author AmitPandey
 */
public class UserExtactor implements ResultSetExtractor<User>{
      public User extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        User user = new User();
        user.setUserId(resultSet.getInt("id"));
        user.setUserAge(resultSet.getInt("age"));
        user.setUserName(resultSet.getString("name"));
        user.setUserContact(resultSet.getString("contact"));
        user.setUserEmail(resultSet.getString("email"));
        System.out.println(user);
        return user;
    }
    
}
