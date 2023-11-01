package com.bbanddak.bbanddak.repository;

import com.bbanddak.bbanddak.entity.UserTable;
import com.bbanddak.bbanddak.vo.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcUserRepository implements UserRepository{

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public UserTable findUserInfoById(String id) {
        UserTable v = new UserTable();
        return v;
    };
    public String findUserNameById(String id) {
        String v = "";
        return v;
    };

    public List<User> findUserInfoByEmail(String email) {
        String sql = "SELECT id, username, email, password FROM bd_user_jpa WHERE email = ?";
        return jdbcTemplate.query(sql, new Object[]{email}, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            return user;
        });
    }
}

