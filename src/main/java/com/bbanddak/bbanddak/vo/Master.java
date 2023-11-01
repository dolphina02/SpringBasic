package com.bbanddak.bbanddak.vo;

import lombok.Data;

@Data
public class Master {
    String info_name; // car type 같은 정보의 종류
    String info_code; // CT-000001
    String description_1; // 일반 승용
    String description_2; // 필요하면 넣는 추가 정보
}
