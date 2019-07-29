package com.cskaoyan.wdjava.mapper;

import com.cskaoyan.wdjava.bean.WdAdmin;
import com.cskaoyan.wdjava.bean.WdAdminExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WdAdminMapper {
    long countByExample(WdAdminExample example);

    int deleteByExample(WdAdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WdAdmin record);

    int insertSelective(WdAdmin record);

    List<WdAdmin> selectByExample(WdAdminExample example);

    WdAdmin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WdAdmin record, @Param("example") WdAdminExample example);

    int updateByExample(@Param("record") WdAdmin record, @Param("example") WdAdminExample example);

    int updateByPrimaryKeySelective(WdAdmin record);

    int updateByPrimaryKey(WdAdmin record);
}