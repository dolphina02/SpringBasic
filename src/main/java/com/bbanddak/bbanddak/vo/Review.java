package com.bbanddak.bbanddak.vo;

import lombok.Data;

@Data
public class Review {
    String review_id; // review의 Id
    String wash_id; // 세차 받은 wash Id
    Integer star; // 별점 (1~5)
    String review_pic_no; // 리뷰에 사진이 있다면 해당 사진의 고유번호
    String comment; // review 내
}
