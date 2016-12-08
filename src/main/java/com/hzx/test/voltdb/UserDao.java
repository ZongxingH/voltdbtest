package com.hzx.test.voltdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Introduction:  [Simple Introduction of the java documents]
 * Package Name:  com.hzx.test.voltdb
 * Project Name:  voltdbtest
 * Author:  ZongxingH
 * Create Time:  2016/12/1 11:04
 */
@Service("userDao")
public class UserDao {
    private static final String selectSql = "SELECT name AS name, sex AS sex, age AS age, addr AS addr FROM USER WHERE name = ?";
    private static final String getAllSql = "SELECT name AS name, sex AS sex, age AS age, addr AS addr FROM USER";
    private static final String deleteByName = "DELETE FROM USER WHERE name = ?";
    private static final String deleteAll = "DELETE FROM USER";
    private static final String insertUser = "INSERT INTO USER ( NAME,SEX,AGE,ADDR) VALUES ( ?, ?, ?, ? )";
    private static final String updateUserByName = "UPDATE USER SET name = ?, sex  = ? WHERE name = ?";

    @Autowired
    @Qualifier("jdbcTemplate_voltdb")
    private JdbcTemplate jdbcTemplate;

    public List<User> getUserByName(String name){
        Object[] parms = new Object[1];
        parms[0] = name;
        List<User> users = jdbcTemplate.query(selectSql,parms,new UserRowMapper());
        return users;
    }

    public List<User> getAllUsers(){
        List<User> users = jdbcTemplate.query(getAllSql,new UserRowMapper());
        return users;
    }

    public int delUserByName(String name){
        Object[] parms = new Object[1];
        parms[0] = name;
        return jdbcTemplate.update(deleteByName,parms);

    }
    public int delAllUsers(){
        return jdbcTemplate.update(deleteAll);
    }

    public int addUser(User user){
        Object[] parms = new Object[4];
        parms[0] = user.getName();
        parms[1] = user.getSex();
        parms[2] = user.getAge();
        parms[3] = user.getAddr();
        return jdbcTemplate.update(insertUser,parms);

    }

    public int updateUserByName(User user){
        Object[] parms = new Object[3];
        parms[0] = user.getName();
        parms[1] = user.getSex();
        parms[2] = user.getName();
        return jdbcTemplate.update(updateUserByName,parms);
    }
}
