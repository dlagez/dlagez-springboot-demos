package com.example.springdataredis;

import com.example.springdataredis.cacheobject.UserCacheObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringDataRedisApplication.class)
public class Test01 {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testStringSetKey() {
        stringRedisTemplate.opsForValue().set("aaa", "aaa");
    }

    @Test
    public void testStringSetKeyUserCache() {
        UserCacheObject object = new UserCacheObject(1, "roczhang", 1);
        String key = String.format("user:%d", object.getId());
        redisTemplate.opsForValue().set(key, "obcas");
    }

    @Test
    public void testStringGetKeyUserCache() {
        String key = String.format("user:%d", 1);
        System.out.println("key: "+key);
        Object value = redisTemplate.opsForValue().get(key);
        System.out.println(value);
    }
}
