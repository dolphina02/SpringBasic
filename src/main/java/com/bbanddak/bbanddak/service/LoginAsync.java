package com.bbanddak.bbanddak.service;

public class LoginAsync {
    // 로그인 하면 Redis에 정보가 있는 지 확인하고, 없다면 관련 정보를 모두 불러와서 Redis에 집어 넣는다
    // 정보가 많지 않기 떄문에 회원정보 하나로 Table 형태의 Data 하나만 긁어와서 모든 vo에 Mapping

    public boolean checkUserInfo(String email) {
        return true;
    }
}
