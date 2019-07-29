package com.cskaoyan.wdjava.mapper;

import com.cskaoyan.wdjava.bean.WdTerm;
import com.cskaoyan.wdjava.bean.WdTermExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WdTermMapper {
    long countByExample(WdTermExample example);

    int deleteByExample(WdTermExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WdTerm record);

    int insertSelective(WdTerm record);

    List<WdTerm> selectByExample(WdTermExample example);

    WdTerm selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WdTerm record, @Param("example") WdTermExample example);

    int updateByExample(@Param("record") WdTerm record, @Param("example") WdTermExample example);

    int updateByPrimaryKeySelective(WdTerm record);

    int updateByPrimaryKey(WdTerm record);

    List<WdTerm> queryCurrentTerms(Integer deleted);
}