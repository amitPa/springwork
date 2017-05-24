/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bike.jdbc;

/**
 *
 * @author AmitPandey
 */
import com.bike.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setUserId(resultSet.getInt("id"));
        user.setUserAge(resultSet.getInt("age"));
        user.setUserName(resultSet.getString("name"));
        user.setUserContact(resultSet.getString("contact"));
        user.setUserEmail(resultSet.getString("email"));
        return user;
    }

}
