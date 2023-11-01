package com.bbanddak.bbanddak.event;

import com.bbanddak.bbanddak.vo.Wash;
import lombok.Data;

@Data
public class WashEvent {
    String wash_id;
    String request_car_id;
    String target_washer_id;
    Integer price;
    String payment_code;

    public WashEvent(Object source, Wash washRequest) {
        this.wash_id = washRequest.getWash_id();
        this.request_car_id = washRequest.getCar_id();
        this.target_washer_id = washRequest.getWasher_id();
        this.price = washRequest.getPrice();
        this.payment_code = washRequest.getPayment_code();
    }
}
