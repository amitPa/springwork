/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bike.services;

import com.bike.dowimpl.BicycleDao;
import com.bike.model.Bicycle;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author AmitPandey
 */
@Service
public class BicycleServiceImpl implements BicycleService {
    
    @Autowired
    BicycleDao bicyleDao;
    
    public void setUserDAO(BicycleDao bicyleDao) {
        this.bicyleDao = bicyleDao;
    }

    @Override
    public List<Bicycle> getBicycleList() {
        return bicyleDao.getBicycles();
    }
    
}
