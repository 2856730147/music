package com.lh.dao.impl;

import com.lh.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class JDBCTemplateDaoImpl {
    @Autowired
//    这个类似QueryRunner
    private JdbcTemplate jdbcTemplate;

    public int findInsert(User user) {
        String sql = "insert into user(username,password)values (?,?)";
        int update = jdbcTemplate.update(sql, user.getUsername(), user.getPassword());
        return update;
    }

    //查询总计数
    public int findCount() {
        String sql = "select count(1) from user ";

        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    public List<User> findAll() {
        String sql = "select * from user";
        List<User> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        return query;
    }

    public User findById(Integer id) {
        String sql = "select *from user where id=?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
        return user;

    }

    public int findupdated(User user) {
        String sql = "update user set password=? where id=?";
        int update = jdbcTemplate.update(sql, user.getPassword(), user.getId());
        return update;
    }

    public int findDelete(Integer id) {
        String sql = "delete from user where id=?";
        int update = jdbcTemplate.update(sql, id);
        return update;
    }

}