package com.bbanddak.bbanddak.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data // 사용하지 않으면 getter setter를 별도로 작성해야함. 작성하지 않을 시 반환되지 못함
@Entity // jpa의 entity로 지정
@Table(name = "bd_user_jpa") // Mapping 되는 table을 지정
public class UserTable {
    @Id
    private String id;
    private String username;
    private String email;
    private String password;
}