package com.example.dynamicdatasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan(basePackages = "com.example.dynamicdatasource.mapper")
@EnableAspectJAutoProxy(exposeProxy = true)
public class Dynamicdatasource02Application {

    public static void main(String[] args) {
        SpringApplication.run(Dynamicdatasource02Application.class, args);
    }

}
