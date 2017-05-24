/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bike.services;

import com.bike.model.Booking;
import java.util.List;

/**
 *
 * @author AmitPandey
 */
public interface BookingService {

    public void insertData(Booking booking);

    public List<Booking> getBookingList();

    public void updateBooking(String id);
    
}
