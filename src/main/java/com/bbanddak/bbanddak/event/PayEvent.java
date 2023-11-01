package com.bbanddak.bbanddak.event;

import com.bbanddak.bbanddak.vo.Payment;
import lombok.Data;

@Data
public class PayEvent {
    String payment_id; // 결제 id
    String payment_type; // 결제 방식(네이버페이, 카카오페이)
    Integer payment_amount; // 결제 총액
    String payment_code; // 결제 및 취소 부분 결제 등
    String payment_dt; // 결제가 이루어진 시각
    String wash_id; // 관련된 wash_id;
    Boolean accept_yn; // 정상승인 여부

    public PayEvent(Object source, Payment payRequest) {
        this.payment_id = payRequest.getPayment_id();
        this.payment_code = payRequest.getPayment_code();
        this.wash_id = payRequest.getWash_id();
        this.payment_dt = payRequest.getPayment_dt();
        this.accept_yn = payRequest.getAccept_yn();
    }
}
