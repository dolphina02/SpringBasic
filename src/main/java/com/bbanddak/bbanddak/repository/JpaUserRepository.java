package com.bbanddak.bbanddak.repository;

import com.bbanddak.bbanddak.entity.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface JpaUserRepository extends JpaRepository<UserTable, String>, UserRepository {

    // 사용자 ID와 이름을 조회하는 쿼리 메서드 정의
    @Query("SELECT u FROM UserTable u WHERE u.id = ?1")
    UserTable findUserInfoById(String userId);

    @Query("SELECT u.username FROM UserTable u WHERE u.id = ?1")
    String findUserNameById(String userId);
}

