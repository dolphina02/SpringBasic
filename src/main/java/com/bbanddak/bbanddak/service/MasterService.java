package com.bbanddak.bbanddak.service;

import com.bbanddak.bbanddak.mapper.MasterMapper;
import com.bbanddak.bbanddak.vo.Master;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MasterService {

    MasterMapper masterMapper;

    @Autowired
    public MasterService(MasterMapper masterMapper) {
        this.masterMapper=masterMapper;
    }
    public Master getMasterInfoByInfoCode(String info_name, String info_code) {
        return masterMapper.getMasterInfoByInfoCode(info_name, info_code);
    }
}
