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

    @GetMapping("/testUser5")
    public void test5() {
        SysUser sysUser = new SysUser(null, "roczhang", "password", "fdasf",
                "dddd", new byte[123], new Date());
        int success = userMapper.insert(sysUser);
        if (success == 1) {
            System.out.println("insert success!");
        }
    }

    // test user update
    @GetMapping("/testUser6")
    public void test6() {
        SysUser sysUser = new SysUser(1002L, "roczhang2", "password", "fdasf",
                "dddd", new byte[123], new Date());
        int success = userMapper.updateById(sysUser);
        if (success == 1) {
            System.out.println("update success!");
        }
    }

    // test user delete
    @GetMapping("/testUser7")
    public void test7() {
        int i = userMapper.deleteById(1002L);
        System.out.println(i);
    }

    // 测试多个参数
    @GetMapping("/testUser8")
    public void test8() {
        List<SysRole> sysRoles = userMapper.selectRolesByUserIdAndRoleEnabled(1L, 1);
        for (SysRole sysRole : sysRoles) {
            System.out.printf(sysRole.toString());
        }
    }


}
