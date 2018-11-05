package com.bolingcavalry.mavendockerplugindemo.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

@RestController
public class Hello {
	
	@Resource
    private JdbcTemplate jdbcTemplate;
	
	@RequestMapping("/userlist")
    public List<User> getUserList(ModelMap map){
        String sql = "SELECT * FROM user";
        List<User> userList = jdbcTemplate.query(sql, new RowMapper<User>() {
            User user = null;
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                user = new User();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setSex(rs.getString("sex"));
                user.setAge(rs.getString("age"));
                return user;
            }});
        for(User user:userList){
            System.out.println(user.getName());
        }
        map.addAttribute("users", userList);
        return userList;
    }

    @RequestMapping("/")
    public String sayHello(){
    	//修改返回的字符串的内容
        return "123456. Hello jenkins, " + new Date();
    }
}
