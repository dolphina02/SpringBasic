package com.bbanddak.bbanddak.mapper;

import com.bbanddak.bbanddak.vo.Payment;
import com.bbanddak.bbanddak.vo.Wash;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface PaymentMapper {
    Wash getWashInfo(String wash_id);

    Wash getWashInfo2(Map<String, Object> washIdAndStatus);



    @Insert("INSERT INTO bd_payment "
            + " (payment_id, payment_type, payment_amount, payment_code, payment_dt) "
            + " values (#{payment_id}, #{payment_type}, #{payment_amount}, #{payment_code}, #{payment_dt} ) ")
    void setPayEvent(Payment myPayment);
    @Select("SELECT info_code FROM bd_master where info_id = #{info_id}")
    String getPayRequestSeq(String info_id);

}
