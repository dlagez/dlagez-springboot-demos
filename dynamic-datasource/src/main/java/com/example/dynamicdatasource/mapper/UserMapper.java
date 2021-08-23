package com.example.dynamicdatasource.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.dynamicdatasource.constant.DBConstants;
import com.example.dynamicdatasource.dataobject.UserDo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@DS(DBConstants.DATASOURCE_USERS)
public interface UserMapper {

    UserDo selectById(@Param("id") Integer id);
}
