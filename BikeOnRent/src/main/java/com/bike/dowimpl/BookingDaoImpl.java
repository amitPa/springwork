/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bike.dowimpl;

import com.bike.jdbc.BookingRowMapper;
import com.bike.model.Booking;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AmitPandey
 */
@Repository
public class BookingDaoImpl extends JdbcDaoSupport implements BookingDao {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    public void init() {
        setDataSource(dataSource);
    }

    @Override
    public void insertData(Booking booking) {
        String sql = "INSERT INTO Booking"
                + " (bicycle_id,bicycle_day_number,bicyce_hour_number,user_id,pickup_time,created_date_time,cost,booking_type) VALUES(?,?,?,?,?,?,?,?)";
        getJdbcTemplate().update(sql, new Object[]{booking.getBicycleId(), booking.getBiclycleDayNumber(),booking.getBicycleHourNumber(), booking.getBicycleUserId(),booking.getBicyclePickUpTime(),booking.getBicycleCreatedDateTime(),booking.getBicyleCost(),booking.getBicycleBookingType()});
    }

    @Override
    public List<Booking> getBookingList() {
       List bookingList = new ArrayList();
        String sql = "SELECT Bicycle.name,Bicycle.description,Bicycle.is_active,Bicycle.bicycle_id,Booking.id,Booking.bicycle_day_number,Booking.bicyce_hour_number,user_id,Booking.pickup_time,Booking.created_date_time,Booking.cost,Booking.booking_type,Booking.is_cancelled FROM Booking INNER JOIN Bicycle ON Bicycle.id=Booking.bicycle_id WHERE is_cancelled=1";
        bookingList = getJdbcTemplate().query(sql, new BookingRowMapper());
        return bookingList;
    }

    @Override
    public void updateBooking(String id) {
        String sql="Update Booking set is_cancelled=0,cancelled_date_time=? WHERE id=?";
        getJdbcTemplate().update(sql,new Date(),id);
    }

}
