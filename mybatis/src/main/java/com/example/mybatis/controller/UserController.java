package com.example.mybatis.controller;

import com.example.mybatis.mapper.UserMapper;
import com.example.mybatis.pojo.SysRole;
import com.example.mybatis.pojo.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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

    /**
     * 测试动态sql
     */
    @GetMapping("/testUser9")
    public void test9() {
        SysUser sysUser = new SysUser(1002L, "roczhang", "password", "fdasf",
                "dddd", new byte[123], new Date());
        List<SysUser> sysUsers = userMapper.selectByUser(sysUser);
        for (SysUser user : sysUsers) {
            System.out.println(user.toString());
        }
    }

    @GetMapping("/testUser10")
    public void test10() {
        SysUser sysUser = new SysUser(1002L, "roczhang", "password", null,
                "dddd", new byte[123], new Date());
        List<SysUser> sysUsers = userMapper.selectByUser(sysUser);
        for (SysUser user : sysUsers) {
            System.out.println(user.toString());
        }
    }

    @GetMapping("/testUser11")
    public void test11() {
        SysUser sysUser = new SysUser(2L, "roczhang2", "password2", null,
                "5", new byte[5], new Date());
        int i = userMapper.updateByIdSelective(sysUser);
        if (i != 0) {
            System.out.println("update success!");
        }
    }

    @GetMapping("/testUser12")
    public void test12 () {
        SysUser sysUser = new SysUser(null, "roczhang2", "password2", null,
                "5", new byte[5], new Date());
        SysUser sysUser1 = userMapper.selectByIdOrUserName(sysUser);
        System.out.printf(sysUser1.toString());

    }

    // 测试foreach
    @GetMapping("/testUser13")
    public void test13() {
        ArrayList<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(1001L);
        List<SysUser> sysUsers = userMapper.selectByIdList(list);
        for (SysUser sysUser : sysUsers) {
            System.out.printf(sysUser.toString());
        }
    }

    // 测试批量插入
    @GetMapping("/testUser14")
    public void test14() {
        SysUser sysUser = new SysUser(null, "roczhang3", "password2", null,
                "5", new byte[5], new Date());
        SysUser sysUser2 = new SysUser(null, "roczhang4", "password2", null,
                "5", new byte[5], new Date());
        ArrayList<SysUser> sysUsers = new ArrayList<>();
        sysUsers.add(sysUser);
        sysUsers.add(sysUser2);
        int i = userMapper.insertList(sysUsers);
        if (i != 0) {
            System.out.println("insert success!");
        }

    }

    // 测试动态更新
    @GetMapping("/testUser15")
    public void test15() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_email", "test@outlook.com");
        map.put("user_password", "password");
        map.put("id", 1003L);
        int i = userMapper.updateByMap(map);
        if (i != 0) {
            System.out.println("update success!");
        }

    }

}
