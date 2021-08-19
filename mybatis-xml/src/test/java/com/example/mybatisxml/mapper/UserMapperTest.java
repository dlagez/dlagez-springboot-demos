package com.example.mybatisxml.mapper;

import com.example.mybatisxml.MybatisXmlApplication;
import com.example.mybatisxml.dataobject.UserDo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisXmlApplication.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        UserDo user = new UserDo(null , "roczhang2", "password", new Date());
        userMapper.insert(user);
    }

    @Test
    public void testUpdateById() {
        UserDo updateUser = new UserDo(4, "dlage", "password", new Date());
        userMapper.updateById(updateUser);
    }

    @Test
    public void testDeleteById() {
        userMapper.deleteById(4);
    }

    @Test
    public void testSelectByUsername() {
        UserDo roczhang = userMapper.selectByUsername("roczhang");
        System.out.println(roczhang.toString());
    }

    @Test
    public void testSelectByIds() {
        List<UserDo> users = userMapper.selectByIds(Arrays.asList(5, 6));
        System.out.println("users: " + users.size());
    }

}
