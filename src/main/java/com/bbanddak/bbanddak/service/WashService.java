package com.bbanddak.bbanddak.service;

import com.bbanddak.bbanddak.event.PayEvent;
import com.bbanddak.bbanddak.event.WashEvent;
import com.bbanddak.bbanddak.mapper.WashMapper;
import com.bbanddak.bbanddak.vo.Master;
import com.bbanddak.bbanddak.vo.Payment;
import com.bbanddak.bbanddak.vo.Wash;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class WashService {

    private WashMapper washMapper;
    private MasterService masterService;
    private ApplicationEventPublisher eventPublisher;

    public WashService(WashMapper washMapper, MasterService masterService, ApplicationEventPublisher eventPublisher) {
        this.washMapper = washMapper;
        this.masterService = masterService;
        this.eventPublisher = eventPublisher;
    }

    // 결제정보 업데이트
    @EventListener
    public void handlePaymentEvent(PayEvent paymentEvent) {

        Wash updateWash = new Wash();
        // 정상승인 나면 order에 update
        if (paymentEvent.getAccept_yn())
        {
            washMapper.updatePaymentInfo(paymentEvent.getAccept_yn(), paymentEvent.getWash_id());
//            updateWash = getWashInfoByWashId(paymentEvent.getWash_id());
        }

//        return updateWash;
    }

    public Wash updatePayInfo(Payment myPaymentInfo) {

        Wash updateWash = new Wash();
        // 정상승인 나면 order에 update
        if (myPaymentInfo.getAccept_yn())
        {
            washMapper.updatePaymentInfo(myPaymentInfo.getAccept_yn(), myPaymentInfo.getWash_id());
            updateWash = getWashInfoByWashId(myPaymentInfo.getWash_id());
        }

        return updateWash;
    }
    // 세차 신청
    public String requestWash(Wash washRequest) {
        //  ID 생성
        String request_id = washMapper.getWashRequestSeq("I-000200");
        request_id = "W-" + String.format("%06d", Integer.parseInt(request_id));
        washRequest.setWash_id(request_id);

        // Wash 정보 넣기
        washMapper.setWashEvent(washRequest);
        // 세차 신청 이벤트 발행, insert 후 바로 Event 를 보냄
        WashEvent washEvent = new WashEvent(this, washRequest);
        eventPublisher.publishEvent(washEvent);

        return request_id;
    }

    public void updateWashStatus(String wash_id, String status_cd ) {
        washMapper.updateWashStatus(wash_id, status_cd);
    }
    public String washRequestProcess(Wash washRequest) {

        // Wash 정보 넣기
        washMapper.setWashEvent(washRequest);
        // 세차 신청 이벤트 발행, insert 후 바로 Event 를 보냄

        return washRequest.getWash_id();
    }

    // user email을 통한 세차 신청정보 조회
    public ArrayList<Object> getWashInfoByEmail(String email_id) {
        ArrayList<Object> washInfo = new ArrayList<>();;
        // db 에서 해당 washId로 조회하여 세자정보를 다시 반환
        return washInfo;
    }

    // 세차 Id를 통한 세차 신청정보 조회
    public Wash getWashInfoByWashId(String wash_id) {

        // db 에서 해당 washId로 조회하여 세자정보를 다시 반환
        Wash myWash = washMapper.getWashInfo(wash_id);
        return myWash;
    }

    public Wash getWashInfoByWashIdAndStatus(String wash_id, String status_cd) {

        Master myWashStatus = masterService.getMasterInfoByInfoCode("status_cd", status_cd);

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("wash_id", wash_id);
        paramMap.put("status_cd", status_cd);
        // db 에서 해당 washId로 조회하여 세자정보를 다시 반환
        Wash myWash = washMapper.getWashInfo2(paramMap);
        return myWash;
    }

    // 세차 Status 정보
    public String getWashStatus(String wash_id) {
        return washMapper.getWashStatus(wash_id);
    }

    // 신청한 세차의 취소요청
    public ArrayList<Object> cancelWash(String washId) {
        ArrayList<Object> cancelComplete = new ArrayList<>();;
        // db 에서 cancel_yn 정보 업데이트
        // penalty_no 업데이트, penalty_no != null 인 경우 해당 penalty 정보 입력 db 에서  정보 업데이트 (option, 후순위)
        // request 했던 정보 전송
        return cancelComplete;
    }

    // 세차 수락 : 업체에 들어온 wash request를 승인처리
    public Boolean acceptWashRequest(String washId) {
        Boolean acceptOrReject = true;
        // 수락한 업체정보 return
        return acceptOrReject;
    }

    // 세차 거부(pass) :업체에 들어온 wash request를 승인하지 못하는 경우 pass 처리
    public ArrayList<Object> passWashRequest(Object[] userAndCarAndPasser) {
        ArrayList<Object> passComplete = new ArrayList<>();;
        // 사용자의 지역에서 passing 가능한 업체확인 및 전체 전달 (passing된 request는 전체전달)
        // 사전에 pass 한 업체에게는 전달되지 않도록 조회하여 전달해야 함
        // 전달 완료 정보 (n개의 업체에 전달)
        return passComplete;
    }

    // 세차 신청 만료 : 아무도 받지 않아서 만료되어 버린 요청을 처리
    public ArrayList<Object> washRequestExpire(String washId) {
        ArrayList<Object> expiredRequest = new ArrayList<>();;
        // 결제 cancellation
        // 만료된 Request 정보 전송
        return expiredRequest;
    }
}
