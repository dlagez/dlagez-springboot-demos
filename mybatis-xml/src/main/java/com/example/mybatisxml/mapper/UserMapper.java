package com.example.mybatisxml.mapper;

import com.example.mybatisxml.dataobject.UserDo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository  // 可以可不用
public interface UserMapper {

    int insert(UserDo user);

    int updateById(UserDo user);

    int deleteById(@Param("id") Integer id);

    UserDo selectById(@Param("id") Integer id);

    UserDo selectByUsername(@Param("username") String username);

    List<UserDo> selectByIds(@Param("ids")Collection<Integer> ids);

}
