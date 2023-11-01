package com.bbanddak.bbanddak.repository;

import com.bbanddak.bbanddak.entity.UserTable;
import com.bbanddak.bbanddak.vo.User;

import java.util.List;

public interface UserRepository {
    UserTable findUserInfoById(String id);
    String findUserNameById(String id);
    List<User> findUserInfoByEmail(String email);
}
