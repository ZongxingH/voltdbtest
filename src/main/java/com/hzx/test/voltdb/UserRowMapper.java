package com.hzx.test.voltdb;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Introduction:  [Simple Introduction of the java documents]
 * Package Name:  com.hzx.test.voltdb
 * Project Name:  voltdbtest
 * Author:  ZongxingH
 * Create Time:  2016/12/1 11:13
 */
public class UserRowMapper implements RowMapper {
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        User row = new User();
        row.setName(rs.getString("name"));
        row.setSex(rs.getString("sex"));
        row.setAge(rs.getInt("age"));
        row.setAddr(rs.getString("addr"));
        return row;
    }
}
