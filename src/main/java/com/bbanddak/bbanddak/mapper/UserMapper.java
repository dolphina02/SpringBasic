package com.bbanddak.bbanddak.mapper;

import com.bbanddak.bbanddak.vo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;


@Mapper
public interface UserMapper {

    @Select("SELECT * FROM bd_user_jpa where id = #{id}")
    User directFindUserInfoById (String id);

    User refXmlFindUserInfoById(String id);

    Map<String, String> getPasswordById(String id);

    void setNewPassword(String id, String newPassword);
}
