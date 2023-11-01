package com.bbanddak.bbanddak.vo;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Washer {
    String washer_id; // 업체 ID
    String washer_name; // 업체 대표 이름
    String washer_grade; // 업체의 grade (L1, L2 이런식일 듯)
    String washer_type; // personal(개인), company(2인 이상)
    String washer_phone_no; // 업체 대표번호
    String washer_car_no; // 업체 차량번호 (입차로 인함)
    String washer_intro; // 업체 소개글
    String washer_pic_no; // 업체 소개사진
    String registered_dt; // 등록 시점
    ArrayList<String> coverage_code_list; // 서비스 가능 지역 리스트 (Code 는 구 단위로 나옴, S1=서울시 강동구)
    double washer_margin_rate; // 우리가 가져갈 margin 정보
    ArrayList<String> available_tz_list ; // 세차 가능시각
    String enable_yn; // 현재 서비스 하고 있는 업체인지
}
