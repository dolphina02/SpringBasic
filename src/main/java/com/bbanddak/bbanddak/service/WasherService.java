package com.bbanddak.bbanddak.service;

import com.bbanddak.bbanddak.vo.Washer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class WasherService {

    // 특정 지역을 서비스하는 업체정보
    public ArrayList<Washer> getWasherListByLocationCode(String location_code) {
        ArrayList<Washer> washerList = new ArrayList<>();
        return washerList;
    }

    // 업체Id를 통한 업체정보 조회
    public Washer getWasherInfo(String washer_id) {
        Washer myWasher = new Washer();
        return myWasher;
    }

    // 특정업체의 wash 방식 조회
    public Washer getWashTypeInfo(String washer_id) {
        Washer myWashTypeInfo = new Washer();
        return myWashTypeInfo;
    }

    // 특정 금액 이상 매출이 있는 업체 조회
    public ArrayList<Washer> getWasherListByWork(Integer amount) {
        ArrayList<Washer> washerList = new ArrayList<>();
        return washerList;
    }
}
