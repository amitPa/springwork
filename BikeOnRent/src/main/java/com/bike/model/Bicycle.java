/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bike.model;

import java.util.Date;
import javax.validation.constraints.Size;

/**
 *
 * @author AmitPandey
 */
public class Bicycle {

    private int bicyleId;
    @Size(min = 3, max = 100, message = "Name must be atleast 3 characters in length and less than 100 characters")
    private String bicycleName;
    private String biycleDescription;
    private Double bicyclePricePerHour;
    private Double bicyclePricePerDay;
    private Date bicyleCreatedDateTime;
    private Date bicycleLastUpdateDateTime;
    private boolean bicyleIsActive;

    public int getBicyleId() {
        return bicyleId;
    }

    public void setBicyleId(int bicyleId) {
        this.bicyleId = bicyleId;
    }

    public String getBicycleName() {
        return bicycleName;
    }

    public void setBicycleName(String bicycleName) {
        this.bicycleName = bicycleName;
    }

    public String getBiycleDescription() {
        return biycleDescription;
    }

    public void setBiycleDescription(String biycleDescription) {
        this.biycleDescription = biycleDescription;
    }

    public Double getBicyclePricePerHour() {
        return bicyclePricePerHour;
    }

    public void setBicyclePricePerHour(Double bicyclePricePerHour) {
        this.bicyclePricePerHour = bicyclePricePerHour;
    }

    public Double getBicyclePricePerDay() {
        return bicyclePricePerDay;
    }

    public void setBicyclePricePerDay(Double bicyclePricePerDay) {
        this.bicyclePricePerDay = bicyclePricePerDay;
    }

    public Date getBicyleCreatedDateTime() {
        return bicyleCreatedDateTime;
    }

    public void setBicyleCreatedDateTime(Date bicyleCreatedDateTime) {
        this.bicyleCreatedDateTime = bicyleCreatedDateTime;
    }

    public Date getBicycleLastUpdateDateTime() {
        return bicycleLastUpdateDateTime;
    }

    public void setBicycleLastUpdateDateTime(Date bicycleLastUpdateDateTime) {
        this.bicycleLastUpdateDateTime = bicycleLastUpdateDateTime;
    }

    public boolean isBicyleIsActive() {
        return bicyleIsActive;
    }

    public void setBicyleIsActive(boolean bicyleIsActive) {
        this.bicyleIsActive = bicyleIsActive;
    }

}
