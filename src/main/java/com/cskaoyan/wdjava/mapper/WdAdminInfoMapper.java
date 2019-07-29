package com.cskaoyan.wdjava.mapper;

import com.cskaoyan.wdjava.bean.WdAdminInfo;
import com.cskaoyan.wdjava.bean.WdAdminInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WdAdminInfoMapper {
    long countByExample(WdAdminInfoExample example);

    int deleteByExample(WdAdminInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WdAdminInfo record);

    int insertSelective(WdAdminInfo record);

    List<WdAdminInfo> selectByExample(WdAdminInfoExample example);

    WdAdminInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WdAdminInfo record, @Param("example") WdAdminInfoExample example);

    int updateByExample(@Param("record") WdAdminInfo record, @Param("example") WdAdminInfoExample example);

    int updateByPrimaryKeySelective(WdAdminInfo record);

    int updateByPrimaryKey(WdAdminInfo record);
}