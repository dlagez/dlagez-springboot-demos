package com.example.springmvc2.config;

import com.example.springmvc2.core.interceptor.FirstInterceptor;
import com.example.springmvc2.core.interceptor.SecondInterceptor;
import com.example.springmvc2.core.interceptor.ThirdInterceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@Configuration //表明 SpringMVCConfiguration 是个配置类
public class SpringMVCConfiguration implements WebMvcConfigurer {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 配置三个拦截器，并使用
     * @return
     */
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


    /**
     * 创建Servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean testServlet01() {
        ServletRegistrationBean<HttpServlet> servletRegistrationBean = new ServletRegistrationBean<>(new HttpServlet() {
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                logger.info("[doGet][url: {}]", req.getRequestURI());
            }
        });

        servletRegistrationBean.setUrlMappings(Collections.singleton("/test/01"));
        return servletRegistrationBean;
    }

    /**
     * 跨域问题 方法二
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**") //匹配所有 URL ，相当于全局配置
                .allowedOrigins("*")  // 允许所有请求来源
                .allowCredentials(true)  // 允许发送 Cookie
                .allowedMethods("*")  // 允许所有请求 Method
                .allowedHeaders("*")  // 允许所有请求 Header
                .maxAge(1800L);  // 有效期 1800 秒，2 小时
        // 这里配置匹配路径/** 实现全局的cors配置
        // 如果想要配置单个路径的 CORS 配置，可以通过CorsRegistry#addMapping(String pathPattern) 方法，
        // 继续往其中添加 CORS 配置。
        //如果胖友想要更安全，可以 originns 属性，只填写允许的前端域名地址。
    }


    /**
     * 跨域问题比较好的解决方式
     * @return
     */
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        // 类似 CorsRegistry 注册表
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // 注册信息
        CorsConfiguration config = new CorsConfiguration();

        config.setAllowedOrigins(Collections.singletonList("*")); // 允许所有请求来源
        config.setAllowCredentials(true); // 允许发送cookie
        config.addAllowedMethod("*");  // 运行所有请求Method
        config.setAllowedHeaders(Collections.singletonList("*")); // 允许所有请求 Header
        config.setMaxAge(1800L); // 有效期1800秒
        source.registerCorsConfiguration("/**", config);

        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }
}
