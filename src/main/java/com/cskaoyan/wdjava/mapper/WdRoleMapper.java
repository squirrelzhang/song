package com.cskaoyan.wdjava.mapper;

import com.cskaoyan.wdjava.bean.WdRole;
import com.cskaoyan.wdjava.bean.WdRoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WdRoleMapper {
    long countByExample(WdRoleExample example);

    int deleteByExample(WdRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WdRole record);

    int insertSelective(WdRole record);

    List<WdRole> selectByExample(WdRoleExample example);

    WdRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WdRole record, @Param("example") WdRoleExample example);

    int updateByExample(@Param("record") WdRole record, @Param("example") WdRoleExample example);

    int updateByPrimaryKeySelective(WdRole record);

    int updateByPrimaryKey(WdRole record);
}