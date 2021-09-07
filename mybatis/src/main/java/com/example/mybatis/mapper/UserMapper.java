package com.example.mybatis.mapper;

import com.example.mybatis.pojo.SysRole;
import com.example.mybatis.pojo.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    // select 方法
    SysUser selectById(Long id);
    List<SysUser> selectAll();

    List<SysRole> selectRolesByUserId(Long userId);

    // insert方法
    int insert(SysUser sysUser);

}
