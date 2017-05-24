/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bike.services;

import com.bike.dowimpl.BookingDao;
import com.bike.model.Booking;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AmitPandey
 */
@Repository
public class BookingServiceImpl implements BookingService {
    
    @Autowired
    BookingDao bookingdao;
    
    public void setBookingDAO(BookingDao bookingdao) {
        this.bookingdao = bookingdao;
    }

    @Override
    public void insertData(Booking booking) {
        bookingdao.insertData(booking);
    }

    @Override
    public List<Booking> getBookingList() {
        return bookingdao.getBookingList();
    }
    

    @Override
    public void updateBooking(String id) {
        bookingdao.updateBooking(id);
    }
    
}
