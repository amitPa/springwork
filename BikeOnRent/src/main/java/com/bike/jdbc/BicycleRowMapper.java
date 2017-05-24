/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bike.jdbc;

import com.bike.model.Bicycle;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author AmitPandey
 */
public class BicycleRowMapper implements RowMapper<Bicycle> {

    @Override
    public Bicycle mapRow(ResultSet resultSet, int i) throws SQLException {
        Bicycle bicyle = new Bicycle();
        bicyle.setBicyleId(resultSet.getInt("id"));
        bicyle.setBicycleName(resultSet.getString("name"));
        bicyle.setBiycleDescription(resultSet.getString("description"));
        bicyle.setBicyclePricePerDay(resultSet.getDouble("price_per_day"));
        bicyle.setBicyclePricePerHour(resultSet.getDouble("price_per_hour"));
        bicyle.setBicyleCreatedDateTime(resultSet.getTimestamp("created_date_time"));
        return bicyle;
    }
}
