package com.example.dynamicdatasource.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.dynamicdatasource.constant.DBConstants;
import com.example.dynamicdatasource.dataobject.OrderDo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface OrderMapper {

    /**
     * 使用从表读取数据
     * @param id
     * @return
     */
    @DS(DBConstants.DATASOURCE_SLAVE)
    OrderDo selectById(@Param("id") Integer id);

    /**
     * 使用主表写入数据
     * @param entity
     * @return
     */
    @DS(DBConstants.DATASOURCE_MASTER)
    int insert(OrderDo entity);



}
