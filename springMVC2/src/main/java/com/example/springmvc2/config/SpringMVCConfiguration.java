package com.example.springmvc2.config;

import com.example.springmvc2.core.interceptor.FirstInterceptor;
import com.example.springmvc2.core.interceptor.SecondInterceptor;
import com.example.springmvc2.core.interceptor.ThirdInterceptor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //表明 SpringMVCConfiguration 是个配置类
public class SpringMVCConfiguration implements WebMvcConfigurer {

    @Bean
    public FirstInterceptor firstInterceptor() {
        return new FirstInterceptor();
    }

    @Bean
    public SecondInterceptor secondInterceptor() {
        return new SecondInterceptor();
    }

    @Bean
    public ThirdInterceptor thirdInterceptor() {
        return new ThirdInterceptor();
    }

    // 添加自定义的 HandlerInterceptor 拦截器，到 InterceptorRegistry 拦截器注册表中
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截器一
        registry.addInterceptor(this.firstInterceptor()).addPathPatterns("/**");

        registry.addInterceptor(this.secondInterceptor()).addPathPatterns("/users/current_user");

        registry.addInterceptor(this.thirdInterceptor()).addPathPatterns("/**");



    }
}
