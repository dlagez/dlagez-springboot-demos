package com.example.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.mybatisplus.dataobject.UserDo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * extends BaseMapper<UserDo> 这样常规的 CRUD 操作，MyBatis-Plus 就可以替我们自动生成。
 */
@Repository
public interface UserMapper extends BaseMapper<UserDo> {

    default UserDo selectByUsername(@Param("username") String name) {
        return selectOne(new QueryWrapper<UserDo>().eq("username", name));
    }

    List<UserDo> selectByIds(@Param("ids") Collection<Integer> ids);

    default IPage<UserDo> selectPageByCreateTime(IPage<UserDo> page, @Param("createTime")Date createTime) {
        return selectPage(page, new QueryWrapper<UserDo>().gt("create_time", createTime));
    }
}
