package com.example.mybatis.controller;

import com.example.mybatis.mapper.UserMapper;
import com.example.mybatis.pojo.SysRole;
import com.example.mybatis.pojo.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/testUser")
    public void test() {
        SysUser user = userMapper.selectById(1L);
        System.out.println(user.toString());
    }

    @GetMapping("/testUser2")
    public void test2() {
        List<SysUser> sysUsers = userMapper.selectAll();
        System.out.println("start.....");
        for (SysUser sysUser : sysUsers) {
            System.out.println(sysUser.toString());
        }
    }

    @GetMapping("/testUser3")
    public void test3() {
        List<SysRole> sysRoles = userMapper.selectRolesByUserId(1L);
        for (SysRole sysRole : sysRoles) {
            System.out.println(sysRole.getSysUser().toString());
        }
    }

    // test user insert

    @GetMapping("/testUser4")
    public void test4() {
        SysUser sysUser = new SysUser(2L, "roczhang", "password", "fdasf",
                "dddd", new byte[123], new Date());
        int success = userMapper.insert(sysUser);
        if (success == 1) {
            System.out.println("insert success!");
        }
    }

}
