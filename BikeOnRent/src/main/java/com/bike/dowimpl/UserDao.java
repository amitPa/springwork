/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bike.dowimpl;

import java.util.List;
import com.bike.model.User;

/**
 *
 * @author AmitPandey
 */
public interface UserDao {

    public void insertData(User user);

    public List<User> getUserList();

    public void UpdateData(User user);
    
    public void updatePassword(User user);

    public void deleteData(String id);

    public User getUser(String id);
    
    public User checkUser(User user);
    
    public User findUserByEmail(String email);
    
    public void updateUserProfile(String field,String data,int id);
    
    public int updateChangePassword(String password,String newPassword,int id);
}
