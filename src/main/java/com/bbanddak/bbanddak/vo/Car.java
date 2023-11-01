package com.bbanddak.bbanddak.vo;

import lombok.Data;

@Data
public class Car {
    String car_id; // 차량 고유 id
    String car_owner_id; // 차량 소유자의 고유 회원번호
    String car_no; // 차량 번호
    String car_name; // 차량 이름 (그렌저IG)
    String car_size; // 차량 크기 (소,중,대)
    String car_type; // 차량 형태 (승용, suv, van)
    String car_color; // 차량 색상
    String car_add_comment; // 차량의 추가 설명
}
