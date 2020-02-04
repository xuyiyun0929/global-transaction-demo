package com.evan.demo.user.controller;

import com.evan.demo.user.service.UserService;
import com.evan.transaction.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SpringClientFactory springClientFactory;


    @Autowired
    private DiscoveryClient discoveryClient;

    @GlobalTransactional
    @RequestMapping(value = "/buyProduct", method = RequestMethod.GET)
    public String buyProduct(){
        Integer userId = 1;
        userService.buyProduct(userId);
        String result = restTemplate.postForObject("http://STORAGE-SERVICE/decreaseStore", 1, String.class);
        log.info("全局事务测试");
        return "全局事务测试";
    }

    @GlobalTransactional
    @RequestMapping(value = "/buyProductFail", method = RequestMethod.GET)
    public String buyProductFail(){
        Integer userId = 1;
        userService.buyProduct(userId);
        String result = restTemplate.postForObject("http://STORAGE-SERVICE/decreaseStore", 1, String.class);
        log.info("全局事务测试");
        throw new RuntimeException("全局事务测试");
    }
}
