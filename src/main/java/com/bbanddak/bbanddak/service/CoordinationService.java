package com.bbanddak.bbanddak.service;

import com.bbanddak.bbanddak.mapper.WashMapper;
import com.bbanddak.bbanddak.vo.Payment;
import com.bbanddak.bbanddak.vo.Wash;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CoordinationService {

    private final WashService washService;
    private final PaymentService paymentService;
    private final WashMapper washMapper;

    public CoordinationService(WashService washService, PaymentService paymentService, WashMapper washMapper) {
        this.washService = washService;
        this.paymentService = paymentService;
        this.washMapper = washMapper;
    }

    // Transaction으로 묶어서 하나의 연결된 내용처럼 작동한다.
    @Transactional
    public Wash washAndPay(Wash washRequest) {

        Wash resultWash = new Wash();
        //  ID 생성
        String request_id = washMapper.getWashRequestSeq("I-000200");
        request_id = "W-" + String.format("%06d", Integer.parseInt(request_id));
        washRequest.setWash_id(request_id);

        try {
            String wash_id = washService.washRequestProcess(washRequest);
            Payment myPayment = paymentService.payProces(washRequest.getPayment_code(), washRequest.getPrice());
            resultWash = washService.updatePayInfo(myPayment);

        }
        catch (Exception e) {
            // Transaction으로 묶인 서비스흐름이 중단되면 Rollback을 수행
            rollbackCauseRequestFail(washRequest, e);
        }
        finally {
            return resultWash;
        }
    }

    public void rollbackCauseRequestFail(Wash washRequest, Exception e) {
        // status : requested(normal) = ST-R
        // status : fail = ST-F
        // status : washer accept = ST-A
        // status : during wash = ST-D
        // status : wash complete = ST-C
        washService.updateWashStatus(washRequest.getWash_id(), "ST-F");
    }
}
