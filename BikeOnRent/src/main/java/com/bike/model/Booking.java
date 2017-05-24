/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bike.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.bike.constants.BikeConstants;

/**
 *
 * @author AmitPandey
 */
public class Booking {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBicycleId() {
        return bicycleId;
    }

    public void setBicycleId(int bicycleId) {
        this.bicycleId = bicycleId;
    }

    public double getBicyleCost() {
        return bicyleCost;
    }

    public void setBicyleCost(double bicyleCost) {
        this.bicyleCost = bicyleCost;
    }

    public String getBicycleBookingType() {
        return bicycleBookingType;
    }

    public void setBicycleBookingType(String bicycleBookingType) {
        this.bicycleBookingType = bicycleBookingType;
    }

    public int getBiclycleDayNumber() {
        return biclycleDayNumber;
    }

    public void setBiclycleDayNumber(int biclycleDayNumber) {
        this.biclycleDayNumber = biclycleDayNumber;
    }

    public int getBicycleHourNumber() {
        return bicycleHourNumber;
    }

    public void setBicycleHourNumber(int bicycleHourNumber) {
        this.bicycleHourNumber = bicycleHourNumber;
    }

    public String getBicyclePickUpTime() {
        return bicyclePickUpTime;
    }

    public void setBicyclePickUpTime(Timestamp bicyclePickUpTime) {
        try{
        this.bicyclePickUpTime =  (BikeConstants.FORMAT).format(bicyclePickUpTime);
        }catch(Exception e){System.out.println("Amit Error:"+e);}
    }

    public String getBicycleCreatedDateTime() {
        return bicycleCreatedDateTime;
    }

    public void setBicycleCreatedDateTime(Date bicycleCreatedDateTime) {
        
         try{
        this.bicycleCreatedDateTime =  (BikeConstants.FORMAT).format(bicycleCreatedDateTime);
        }catch(Exception e){System.out.println("Date Error");}
    }

    public boolean isBicycleIsCancelled() {
        return bicycleIsCancelled;
    }

    public void setBicycleIsCancelled(boolean bicycleIsCancelled) {
        this.bicycleIsCancelled = bicycleIsCancelled;
    }
    
     public boolean getBicycleIsCancelled() {
        return bicycleIsCancelled;
    }

    public int getBicycleUserId() {
        return bicycleUserId;
    }

    public void setBicycleUserId(int bicycleUserId) {
        this.bicycleUserId = bicycleUserId;
    }
    
    public Bicycle getBicycle() {
        return bicycle;
    }

    public void setBicycle(Bicycle bicycle) {
        this.bicycle = bicycle;
    }
    
    private int bicycleId;
    private int bicycleUserId;
    private double bicyleCost;
    private String bicycleBookingType;
    private int biclycleDayNumber;
    private int bicycleHourNumber;
    private String  bicyclePickUpTime;
    private String bicycleCreatedDateTime;
    private boolean bicycleIsCancelled;
    private Bicycle bicycle;


    @Override
    public String toString() {
        return "Booking{" + "id=" + id + ", bicycleId=" + bicycleId + ", bicycleUserId=" + bicycleUserId + ", bicyleCost=" + bicyleCost + ", bicycleBookingType=" + bicycleBookingType + ", biclycleDayNumber=" + biclycleDayNumber + ", bicycleHourNumber=" + bicycleHourNumber + ", bicyclePickUpTime=" + bicyclePickUpTime + ", bicycleCreatedDateTime=" + bicycleCreatedDateTime + ", bicycleIsCancelled=" + bicycleIsCancelled + '}';
    }
    

}
