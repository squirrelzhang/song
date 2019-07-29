package com.cskaoyan.wdjava.mapper;

import com.cskaoyan.wdjava.bean.WdPermission;
import com.cskaoyan.wdjava.bean.WdPermissionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WdPermissionMapper {
    long countByExample(WdPermissionExample example);

    int deleteByExample(WdPermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WdPermission record);

    int insertSelective(WdPermission record);

    List<WdPermission> selectByExample(WdPermissionExample example);

    WdPermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WdPermission record, @Param("example") WdPermissionExample example);

    int updateByExample(@Param("record") WdPermission record, @Param("example") WdPermissionExample example);

    int updateByPrimaryKeySelective(WdPermission record);

    int updateByPrimaryKey(WdPermission record);
}