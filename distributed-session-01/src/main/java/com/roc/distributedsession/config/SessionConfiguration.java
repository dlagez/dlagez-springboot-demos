package com.roc.distributedsession.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@EnableRedisHttpSession  // 自动配置 spring session 使用 redis 作为数据源
public class SessionConfiguration {
    @Bean(name = "springSessionDefaultRedisSerializer")
    public RedisSerializer springSessionDefaultRedisSerializer() {
        return RedisSerializer.json();
    }

}
