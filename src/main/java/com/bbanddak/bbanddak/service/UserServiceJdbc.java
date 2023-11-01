package com.bbanddak.bbanddak.service;

import com.bbanddak.bbanddak.repository.JdbcUserRepository;
import com.bbanddak.bbanddak.vo.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceJdbc {

    private JdbcUserRepository jdbcUserRepository;

    // 생성자 주입이 편함
    public UserServiceJdbc(JdbcUserRepository userRepository) {
        this.jdbcUserRepository= userRepository;
    }

    public List<User> findUserInfoByEmail(String emailAddr) {
        return jdbcUserRepository.findUserInfoByEmail(emailAddr);
    }

}
