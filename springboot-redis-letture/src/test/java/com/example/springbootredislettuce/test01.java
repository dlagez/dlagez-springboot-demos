package com.example.springbootredislettuce;

import com.example.springbootredislettuce.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class test01 {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("mykey", "roczhang");
        System.out.println(redisTemplate.opsForValue().get("mykey"));
    }

    @Test
    public void test() {
        User roczhang = new User("roczhang", 23);

    }
}
