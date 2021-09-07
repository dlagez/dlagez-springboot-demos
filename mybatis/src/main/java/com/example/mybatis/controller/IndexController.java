package com.example.mybatis.controller;

import com.example.mybatis.mapper.TestUserMapper;
import com.example.mybatis.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexController {

    @Autowired
    private TestUserMapper testUserMapper;

    @GetMapping("selectAll")
    public String selectAll() {
        List<User> users = testUserMapper.selectAll();
        for (User user : users) {
            System.out.println(user.toString());
        }
        return "success!";
    }
}
