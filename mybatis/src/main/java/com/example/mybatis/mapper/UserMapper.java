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
    int insert2(SysUser sysUser);

    // update方法
    int updateById(SysUser sysUser);

    //delete方法
    int deleteById(Long id);

    List<SysRole> selectRolesByUserIdAndRoleEnabled(Long userId, Integer enabled);
}
