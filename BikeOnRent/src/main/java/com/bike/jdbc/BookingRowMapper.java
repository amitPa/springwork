/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bike.jdbc;

import com.bike.model.Bicycle;
import com.bike.model.Booking;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author AmitPandey
 */
public class BookingRowMapper implements RowMapper<Booking> {
    
    @Override
    public Booking mapRow(ResultSet rs, int i) throws SQLException {
        Booking booking = new Booking();
        Bicycle bicycle =new Bicycle();
        booking.setId(rs.getInt("id"));
        booking.setBicycleId(rs.getInt("bicycle_id"));
        booking.setBicycleBookingType(rs.getString("booking_type"));
        booking.setBiclycleDayNumber(rs.getInt("bicycle_day_number"));
        booking.setBicycleHourNumber(rs.getInt("bicyce_hour_number"));
        booking.setBicycleIsCancelled(rs.getBoolean("is_cancelled"));
        booking.setBicycleCreatedDateTime(rs.getTimestamp("created_date_time"));
        booking.setBicyclePickUpTime(rs.getTimestamp("pickup_time"));
        booking.setBicyleCost(rs.getDouble("cost"));
        booking.setBicycleUserId(rs.getInt("user_id"));
        bicycle.setBicycleName(rs.getString("name"));
        bicycle.setBiycleDescription(rs.getString("description"));
        bicycle.setBicyleIsActive(rs.getBoolean("is_active"));
        booking.setBicycle(bicycle);
        
        return booking;
    }
    
}
