package com.evan.demo.order.mapper;

import com.evan.demo.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    int deleteByPrimaryKey(Integer order_id);

    int insert(Order record);

    Order selectByPrimaryKey(Integer order_id);

    List<Order> selectAll();

    int updateByPrimaryKey(Order record);
}