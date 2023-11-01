package com.bbanddak.bbanddak.service;

import com.bbanddak.bbanddak.entity.UserTable;
import com.bbanddak.bbanddak.repository.JpaUserRepository;
import com.bbanddak.bbanddak.vo.User;
import org.springframework.stereotype.Service;


@Service
public class UserServiceJpa {

    private JpaUserRepository jpaUserRepository;

    // 생성자 주입이 편함
    public UserServiceJpa(JpaUserRepository userRepository) {
        this.jpaUserRepository= userRepository;
    }

//    public User findUserInfoByEmail(String userId) {
//        return findUserInfoById(userRepository.findUserIdByEmail(userId));
//    }
    public UserTable findUserInfoById(String userId) {
        return jpaUserRepository.findUserInfoById(userId);
    }

    public String findUserNameById(String userId) {
        return jpaUserRepository.findUserNameById(userId);
    }

    public User addNewUser(User newUser) {
        User myNewUser = new User();
        return myNewUser;
    }
}
