package com.example.mybatisplus.mapper;

import com.example.mybatisplus.MybatisPlusApplication;
import com.example.mybatisplus.dataobject.UserDo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisPlusApplication.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        UserDo user = new UserDo(null, "dlage", "123", new Date(), 0);
        userMapper.insert(user);
    }
}
