/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bike.dowimpl;

import java.util.List;
import com.bike.model.Bicycle;

/**
 *
 * @author AmitPandey
 */
public interface BicycleDao {

    public List<Bicycle> getBicycles();
    
}
