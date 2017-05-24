/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bike.services;

import com.bike.dowimpl.UserDao;
import com.bike.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AmitPandey
 */
@Repository
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userdao;

    public void setUserDAO(UserDao userdao) {
        this.userdao = userdao;
    }

    @Override
    public void insertData(User user) {
        userdao.insertData(user);
    }

    @Override
    public void deleteData(String id){
         userdao.deleteData(id);
    }

    @Override
    public User getUser(String id){
        return userdao.getUser(id);
    }
    
    @Override
    public void updateData(User user){
         userdao.UpdateData(user);
    }
    
    @Override
    public User checkUser(User user){
       return userdao.checkUser(user); 
    }

    @Override
    public List<User> getUserList() {
        return userdao.getUserList(); 
    }
    
    @Override
    public User findUserByEmail(String email){
        return userdao.findUserByEmail(email);
    }

    @Override
    public void updatePassword(User user){
        userdao.updatePassword(user);
    }

    @Override
    public void updateUserProfile(String field, String data, int id) {
        userdao.updateUserProfile( field, data, id);
    }

    @Override
    public int updateChangePassword(String password,String newPassword,int id) {
         return userdao.updateChangePassword(newPassword,password, id);
    }
}


