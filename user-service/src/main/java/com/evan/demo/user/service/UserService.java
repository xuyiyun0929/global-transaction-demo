package com.evan.demo.user.service;

import com.evan.demo.user.entity.User;
import com.evan.demo.user.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
@Slf4j
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void buyProduct(Integer userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        user.setStatus_date(new Date());
        userMapper.updateByPrimaryKey(user);
        log.info("调用用户服务");
    }
}
