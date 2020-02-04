package com.evan.demo.storage.mapper;

import com.evan.demo.storage.entity.Store;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreMapper {
    int deleteByPrimaryKey(Integer product_id);

    int insert(Store record);

    Store selectByPrimaryKey(Integer product_id);

    List<Store> selectAll();

    int updateByPrimaryKey(Store record);
}