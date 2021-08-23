package com.example.dynamicdatasource.mapper;

import com.example.dynamicdatasource.DynamicDatasourceApplication;
import com.example.dynamicdatasource.dataobject.OrderDO;
import com.example.dynamicdatasource.dataobject.UserDo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DynamicDatasourceApplication.class)
public class OrderMapperTest {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectById() {
        OrderDO order = orderMapper.selectById(1);
        System.out.println(order);
    }


    @Test
    public void testSelectById_User() {
        UserDo user = userMapper.selectById(1);
        System.out.println(user);
    }


}
