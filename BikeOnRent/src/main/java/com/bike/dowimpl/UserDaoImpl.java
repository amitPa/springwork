/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bike.dowimpl;

import com.bike.jdbc.UserRowMapper;
import com.bike.model.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AmitPandey
 */
@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    public void init() {
        setDataSource(dataSource);
    }

    @Override
    public void insertData(User user) {
        String sql = "INSERT INTO User"
                + " (email,name,password,contact) VALUES(?,?,?,?)";
        getJdbcTemplate().update(sql, new Object[]{user.getUserEmail(), user.getUserName(), user.getUserPassword(), user.getUserContact()});
    }

    @Override
    public List<User> getUserList() {
        List userList = new ArrayList();
        String sql = "SELECT * FROM User";
        userList = getJdbcTemplate().query(sql, new UserRowMapper());
        return userList;
    }

    @Override
    public void UpdateData(User user) {
        String sql = "Update User set tempPassword=?,tokenTimeStamp=? WHERE id=?";
        getJdbcTemplate().update(sql, user.getUserChangePassword(),new Date(), user.getUserId());
    }
    
    @Override
    public void updatePassword(User user){
        String sql="Update user set password=? WHERE id=?";
        getJdbcTemplate().update(sql, user.getUserPassword(), user.getUserId());
    }

    @Override
    public void deleteData(String id) {
        String sql = "Delete From User Where id=" + id;
        getJdbcTemplate().update(sql);
    }

    @Override
    public User getUser(String id) {
        List<User> userList = new ArrayList<User>();
        String sql = "Select * FROM User Where id= " + id;
        userList = getJdbcTemplate().query(sql, new UserRowMapper());
        return userList.get(0);
    }

    @Override
    public User checkUser(User user) {
        User users = new User();
        String sql = "SELECT * FROM User WHERE email=? AND password=?";
        users = getJdbcTemplate().queryForObject(sql, new Object[]{user.getUserEmail(), user.getUserPassword()}, new UserRowMapper());
        return users;
    }

    @Override
    public User findUserByEmail(String userEmail) {
        User userList = null;
        String sql = "SELECT * FROM User WHERE email= ?";
        try {
            userList = getJdbcTemplate().queryForObject(sql, new UserRowMapper(), userEmail);
            if (userList != null) {
                System.out.println("IF");
                return userList;
            } else {
                 System.out.println("else");
                return null;
            }

        } catch (Exception e) {
            System.out.println("New User");
            return null;
        }
    }

    @Override
    public void updateUserProfile(String field,String data,int id) {
        String sql="Update User Set "+field+"= ? WHERE id= ? ";
        getJdbcTemplate().update(sql, data, id);
    }

    @Override
    public int updateChangePassword(String password,String newPassword,int id) {
        String sql="Update User Set password= ? WHERE id= ? AND password = ?";
        return getJdbcTemplate().update(sql,newPassword,id, password);
    }

}
