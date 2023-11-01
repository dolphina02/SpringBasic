package com.bbanddak.bbanddak.controller;

import com.bbanddak.bbanddak.service.UserServiceJdbc;
import com.bbanddak.bbanddak.service.UserServiceJpa;
import com.bbanddak.bbanddak.service.UserServiceMyBatis;
import com.bbanddak.bbanddak.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserServiceJpa userServiceJpa;
    private UserServiceJdbc userServiceJdbc;
    private UserServiceMyBatis userServiceMyBatis;

    @Autowired
    public UserController(UserServiceJpa userServiceJpa, UserServiceJdbc userServiceJdbc, UserServiceMyBatis userServiceMyBatis) {
        this.userServiceJpa = userServiceJpa;
        this.userServiceJdbc = userServiceJdbc;
        this.userServiceMyBatis = userServiceMyBatis;
    }

//    private final UserRepository userRepository;
//
//    @Autowired
//    public UserController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @GetMapping("/userInfo/jpa/{id}")
    public ResponseEntity<Object> getUserInfoByIdJpa(@PathVariable String id) {
        Object user = userServiceJpa.findUserInfoById(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/name/jpa/{id}")
    public ResponseEntity<String> getUserNameByIdJpa(@PathVariable String id) {
        String user = userServiceJpa.findUserNameById(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/userInfo/jdbc/{emailAddr}")
    public ResponseEntity<List<User>> getUserNameByEmailJdbc(@PathVariable String emailAddr) {
        List<User> userList = userServiceJdbc.findUserInfoByEmail(emailAddr);
        if (userList != null) {
            return new ResponseEntity<>(userList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/userInfo/mybatis/dir/{id}")
    public ResponseEntity<User> getUserInfoByIdBatisDir(@PathVariable String id) {
        User myUser = userServiceMyBatis.directFindUserInfoById(id);
        if (myUser != null) {
            return new ResponseEntity<>(myUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/userInfo/mybatis/xml/{id}")
    public ResponseEntity<User> getUserInfoByIdBatisXml(@PathVariable String id) {
        User myUser = userServiceMyBatis.refXmlFindUserInfoById(id);
        if (myUser != null) {
            return new ResponseEntity<>(myUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/userInfo/password/{id}")
    public ResponseEntity<Map<String, String>> getUserPassword(@PathVariable String id) {
        Map<String, String> myIdAndPw = userServiceMyBatis.getPasswordById(id);
        if (myIdAndPw != null) {
            return new ResponseEntity<>(myIdAndPw, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("userInfo/password/change")
    public ResponseEntity<Map<String, String>> setNewPassword(@RequestParam("id") String id, @RequestParam("newPassword") String newPassword) {
        userServiceMyBatis.setNewPassword(id, newPassword);
        Map<String, String> myIdAndPw = userServiceMyBatis.getPasswordById(id);

        if (myIdAndPw != null) {
            return new ResponseEntity<>(myIdAndPw, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
