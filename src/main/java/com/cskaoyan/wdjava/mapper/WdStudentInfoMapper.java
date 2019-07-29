package com.cskaoyan.wdjava.mapper;

import com.cskaoyan.wdjava.bean.WdStudentInfo;
import com.cskaoyan.wdjava.bean.WdStudentInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WdStudentInfoMapper {
    long countByExample(WdStudentInfoExample example);

    int deleteByExample(WdStudentInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WdStudentInfo record);

    int insertSelective(WdStudentInfo record);

    List<WdStudentInfo> selectByExample(WdStudentInfoExample example);

    WdStudentInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WdStudentInfo record, @Param("example") WdStudentInfoExample example);

    int updateByExample(@Param("record") WdStudentInfo record, @Param("example") WdStudentInfoExample example);

    int updateByPrimaryKeySelective(WdStudentInfo record);

    int updateByPrimaryKey(WdStudentInfo record);

}