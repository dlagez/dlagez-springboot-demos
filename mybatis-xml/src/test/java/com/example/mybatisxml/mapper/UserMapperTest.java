package com.example.mybatisxml.mapper;

import com.example.mybatisxml.MybatisXmlApplication;
import com.example.mybatisxml.dataobject.UserDo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisXmlApplication.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        UserDo user = new UserDo(1, "roczhang", "password", new Date());
        userMapper.insert(user);
    }

}
