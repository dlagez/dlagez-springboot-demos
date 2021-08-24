package com.example.dynamicdatasource.maper;

import com.example.dynamicdatasource.Dynamicdatasource02Application;
import com.example.dynamicdatasource.dataobject.OrderDo;
import com.example.dynamicdatasource.mapper.OrderMapper;
import com.example.dynamicdatasource.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Dynamicdatasource02Application.class)
public class OrderMapperTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void testSelectById() {
        for (int i = 0; i < 10; i++) {
            OrderDo order = orderMapper.selectById(1);
            System.out.println(order);
        }
    }

    @Test
    public void testInsert() {
        OrderDo order = new OrderDo();
        order.setUserId(10);
        orderMapper.insert(order);
    }

    @Autowired
    private OrderService orderService;

    @Test
    public void testAdd() {
        OrderDo order = new OrderDo();
        order.setUserId(20);
        orderService.add(order);
    }

    @Test
    public void testFindById() {
        OrderDo order = orderService.findById(1);
        System.out.println(order);
    }
}
