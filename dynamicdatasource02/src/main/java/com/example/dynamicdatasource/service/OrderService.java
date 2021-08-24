package com.example.dynamicdatasource.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.dynamicdatasource.constant.DBConstants;
import com.example.dynamicdatasource.dataobject.OrderDo;
import com.example.dynamicdatasource.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Transactional
    @DS(DBConstants.DATASOURCE_MASTER)
    public void add(OrderDo order) {
        orderMapper.selectById(order.getId());

        orderMapper.insert(order);
    }

    public OrderDo findById(Integer id) {
        return orderMapper.selectById(id);
    }
}
