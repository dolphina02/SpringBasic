package com.bbanddak.bbanddak.vo;

import lombok.Data;

@Data
public class Inquiry {
    String inquiry_no; // 문의 고유번호
    String replied_no; // 만약 이 글이 특정글의 댓글이라면 원문의 inquiry_no를 넣는다
    String inquiry_writer; // 작성자
    String inquiry_category; // 문의 카테고리
    String inquiry_content; // 문의 내용
    String created_dt; // 작성시간
    String modified_dt; // 수정시간
}
