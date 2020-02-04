package com.evan.demo.storage.controller;

import com.evan.demo.storage.entity.Store;
import com.evan.demo.storage.mapper.StoreMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@Slf4j
public class StorageController {

    @Autowired
    private StoreMapper storeMapper;

    @RequestMapping(value = "/decreaseStore", method = RequestMethod.POST)
    public String decreaseStore(@RequestBody Integer product_id){
        Store store = storeMapper.selectByPrimaryKey(product_id);
        store.setOpr_time(new Date());
//        store.setProduct_count("99");
        storeMapper.updateByPrimaryKey(store);
        log.info("全局事务测试");
        return "ok";
    }
}
