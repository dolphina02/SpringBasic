package com.bbanddak.bbanddak.vo;

import lombok.Data;

@Data
public class Payment {
    String payment_id; // 결제 id
    Integer payment_amount; // 결제 총액
    String wash_id; // 관련 wash_id;
    String payment_code; // 결제 및 취소 부분 결제 등
    String payment_type; // 결제 방식(네이버페이, 카카오페이)
    String payment_dt; // 결제가 이루어진 시각
    Boolean accept_yn;
    String payment_accpet_no;
    String subscription_pay_yn; // 정기결제 여부
}
