package com.bbanddak.bbanddak.service;

import com.bbanddak.bbanddak.event.PayEvent;
import com.bbanddak.bbanddak.event.WashEvent;
import com.bbanddak.bbanddak.mapper.PaymentMapper;
import com.bbanddak.bbanddak.vo.Payment;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class PaymentService {

    private PaymentMapper paymentMapper;
    private ApplicationEventPublisher eventPublisher;

    public PaymentService(PaymentMapper paymentMapper, ApplicationEventPublisher eventPublisher) {
        this.paymentMapper = paymentMapper;
        this.eventPublisher = eventPublisher;
    }

    @EventListener
    public void handleWashEvent(WashEvent washEvent) {

        // Event 받아서 변수화
        String paymentCode = washEvent.getPayment_code();
        Integer price = washEvent.getPrice();

        // 해당 Data로 pay처리
        String payment_id = paymentMapper.getPayRequestSeq("I-000300");
        payment_id = "P-" + String.format("%06d", Integer.parseInt(payment_id));

        // 결제 시각 정보
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String paymentDt = dateFormat.format(currentDate);

        Payment myPayment = new Payment();
        myPayment.setPayment_id(payment_id);
        myPayment.setPayment_type("PM-000001"); // paymentMethod
        myPayment.setPayment_code(paymentCode); // order에서 넘어온 내용 (일반결제)
        myPayment.setPayment_dt(paymentDt);
        myPayment.setPayment_amount(price); // order에서 넘어온 결제금액

        // kakaoPay로 결제연동
        // 외부 API연결
        myPayment.setAccept_yn(true); // 정상승인되었다고 판단
        myPayment.setPayment_accpet_no(""); // 결제 승인고유 번호

        paymentMapper.setPayEvent(myPayment);

        PayEvent payEvent = new PayEvent(this, myPayment);
        eventPublisher.publishEvent(payEvent);
    }

    public Payment payProces(String paymentCode, Integer price) {

        // 해당 Data로 pay처리
        String payment_id = paymentMapper.getPayRequestSeq("I-000300");
        payment_id = "P-" + String.format("%06d", Integer.parseInt(payment_id));

        // 결제 시각 정보
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String paymentDt = dateFormat.format(currentDate);

        Payment myPayment = new Payment();
        myPayment.setPayment_id(payment_id);
        myPayment.setPayment_type("PM-000001"); // paymentMethod
        myPayment.setPayment_code(paymentCode); // order에서 넘어온 내용 (일반결제)
        myPayment.setPayment_dt(paymentDt);
        myPayment.setPayment_amount(price); // order에서 넘어온 결제금액

        // kakaoPay로 결제연동
        // 외부 API연결
        myPayment.setAccept_yn(true); // 정상승인되었다고 판단
        myPayment.setPayment_accpet_no(""); // 결제 승인고유 번호

        return myPayment;
    }

}
