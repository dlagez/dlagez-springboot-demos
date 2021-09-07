package com.example.mybatis.mapper;

import com.example.mybatis.pojo.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface TestUserMapper {
    List<User> selectAll();
}
