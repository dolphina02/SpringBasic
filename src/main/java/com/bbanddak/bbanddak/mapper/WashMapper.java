package com.bbanddak.bbanddak.mapper;

import com.bbanddak.bbanddak.vo.Wash;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Map;

@Mapper
public interface WashMapper {
    @Select("SELECT * FROM bd_wash where wash_id = #{wash_id}")
    Wash getWashInfo(String wash_id);

    Wash getWashInfo2(Map<String, Object> washIdAndStatus);

    @Select("SELECT status_cd FROM bd_wash where wash_id = #{wash_id}")
    String getWashStatus(String wash_id);

    @Insert("INSERT INTO bd_wash "
            + " (wash_id, washer_id, car_id, wash_type_id, parking_pic_id, request_wash_tz, wash_dt, status_cd, request_dt, price) "
            + " values (#{wash_id}, #{washer_id}, #{car_id}, #{wash_type_id}, #{parking_pic_id}, #{request_wash_tz}, #{wash_dt}, #{status_cd}, #{request_dt}, #{price} ) ")
    void setWashEvent(Wash washEvent);
    @Select("SELECT info_code FROM bd_master where info_id = #{info_id}")
    String getWashRequestSeq(String info_id);

    @Update("UPDATE bd_wash SET payment_accept = #{accept_yn} WHERE wash_id = #{wash_id} ")
    void updatePaymentInfo(Boolean accept_yn, String wash_id);

    @Update("UPDATE bd_wash SET status_cd = #{status_cd} WHERE wash_id = #{wash_id} ")
    void updateWashStatus(String wash_id, String status_cd);

}
