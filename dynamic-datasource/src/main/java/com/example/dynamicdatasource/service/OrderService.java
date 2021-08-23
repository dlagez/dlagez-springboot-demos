package com.example.dynamicdatasource.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.dynamicdatasource.constant.DBConstants;
import com.example.dynamicdatasource.dataobject.OrderDO;
import com.example.dynamicdatasource.dataobject.UserDo;
import com.example.dynamicdatasource.mapper.OrderMapper;
import com.example.dynamicdatasource.mapper.UserMapper;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserMapper userMapper;

    private OrderService self() {
        return (OrderService) AopContext.currentProxy();
    }

    public void method01() {
        OrderDO order = orderMapper.selectById(1);
        System.out.println(order);

        UserDo user = userMapper.selectById(1);
        System.out.println(user);
    }

    @Transactional
    public void method02() {
        OrderDO order = orderMapper.selectById(1);
        System.out.println(order);

        UserDo user = userMapper.selectById(1);
        System.out.println(user);
    }

    public void method03() {
        self().method031();
        self().method032();
    }

    @Transactional  // 会报错 因为此时获取的是 primary 对应的 DataSource ，即 users 。
    public void method031() {
        OrderDO order = orderMapper.selectById(1);
        System.out.println(order);
    }

    @Transactional
    public void method032() {
        UserDo user = userMapper.selectById(1);
        System.out.println(user);
    }

    public void method04() {
        self().method041();
        self().method042();
    }


    @Transactional
    @DS(DBConstants.DATASOURCE_ORDERS)
    public void method041() {
        OrderDO order = orderMapper.selectById(1);
        System.out.println(order);
    }

    @Transactional
    @DS(DBConstants.DATASOURCE_USERS)
    public void method042() {
        UserDo user = userMapper.selectById(1);
        System.out.println(user);
    }

    @Transactional
    @DS(DBConstants.DATASOURCE_ORDERS)
    public void method05() {

    }

}
