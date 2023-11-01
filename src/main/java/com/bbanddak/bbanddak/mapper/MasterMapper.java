package com.bbanddak.bbanddak.mapper;

import com.bbanddak.bbanddak.vo.Master;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface MasterMapper {

    @Select("SELECT * FROM bd_master where info_name = #{info_name} and info_code = #{info_code}")
    Master getMasterInfoByInfoCode (String info_name, String info_code);
}
