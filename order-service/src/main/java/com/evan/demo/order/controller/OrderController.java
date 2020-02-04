package com.evan.demo.order.controller;

import com.evan.demo.order.entity.Order;
import com.evan.demo.order.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    OrderMapper orderMapper;

    @RequestMapping(value = "/createOrder", method = RequestMethod.PUT)
    public String createOrder(@RequestBody Integer orderId){
        Order order = new Order();
        order.setOrder_id(001);
        order.setCreate_date(new Date());
        order.setOrder_detail("创建订单");
        order.setStatus_date(new Date());
        order.setOrder_status("1");
        orderMapper.insert(order);
        log.info("全局事务测试");
        return "ok";
    }
}
