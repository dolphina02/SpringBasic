package com.bbanddak.bbanddak.vo;

import lombok.Data;

@Data
public class WashType {
    String wash_type_id; // 고유번호
    String washer_id; // 해당 Type의 wash를 서비스하는 업체 ID
    String wash_car_size; // 소,중,대형 차 구분
    String wash_car_type; // 승용, suv 등 구분
    String wash_range; // 내, 외부, Detailing 등을 구분
    String wash_plan; // 일회성, 다회성(구독형) 여부
    Integer wash_price; // 세차 가격
    String created_dt; // 생성일자
    String modified_dt; // 수정일
}
