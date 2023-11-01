package com.bbanddak.bbanddak.vo;

import lombok.Data;

@Data
public class Wash {
    String wash_id; // 세차 고유정보
    String washer_id; // 요청받은 업체의 id
    String car_id; // 차량 정보
    String wash_type_id; // washer, washSize, washType 등의 정보
    String payment_code; // 카카오(K-000001), 네이버(N-000001)
    Integer price; // 결제금액
    String parking_pic_id; // 주차 사진 첨부시 사진의 고유번호
    String request_wash_tz; // 세차 가능한 시간대 (하루를 4시간씩 6개로 나눔, N1-20시~24시, N2-0시~4시)
    String request_dt; // 요청 시각 : 20230921070000 형식으로 저장
    String accept_dt; // 수락 시각 : 20230921070000 형식으로 저장
    String wash_dt; // 세차 시각 : 20230921070000 형식으로 저장
    String status_cd; // R(Requested), W(Washed), C(Cancel), P(During Passing), A(Accepted)
}
