package com.evan.demo.user.mapper;

import com.evan.demo.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer user_id);

    int insert(User record);

    User selectByPrimaryKey(Integer user_id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}