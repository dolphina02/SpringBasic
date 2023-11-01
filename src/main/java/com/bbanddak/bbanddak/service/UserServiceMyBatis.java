package com.bbanddak.bbanddak.service;

import com.bbanddak.bbanddak.mapper.UserMapper;
import com.bbanddak.bbanddak.vo.User;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class UserServiceMyBatis {

    private UserMapper userMapper;

    // 생성자 주입이 편함
    public UserServiceMyBatis(UserMapper userMapper) {
        this.userMapper= userMapper;
    }

    public User directFindUserInfoById(String id) {
        return userMapper.directFindUserInfoById(id);
    }

    public User refXmlFindUserInfoById(String id) {
        return userMapper.refXmlFindUserInfoById(id);
    }

    public Map<String, String> getPasswordById(String id) {
        return userMapper.getPasswordById(id);
    }

    public void setNewPassword (String id, String newPassword) {
        userMapper.setNewPassword(id, newPassword);
    }

}
