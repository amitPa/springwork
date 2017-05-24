/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bike.dowimpl;

import com.bike.jdbc.BicycleRowMapper;
import com.bike.model.Bicycle;
import java.util.ArrayList;
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
public class BicyleDaoImpl extends JdbcDaoSupport implements BicycleDao {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    public void init() {
        setDataSource(dataSource);
    }

    @Override
    public List<Bicycle> getBicycles() {
        List bicycleList = new ArrayList();
        String sql = "SELECT * FROM Bicycle";
        bicycleList = getJdbcTemplate().query(sql, new BicycleRowMapper());
        return bicycleList;
    }
}
