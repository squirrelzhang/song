package com.cskaoyan.wdjava.service.impl;

import com.cskaoyan.wdjava.bean.WdStudentInfo;
import com.cskaoyan.wdjava.bean.WdStudentInfoExample;
import com.cskaoyan.wdjava.mapper.WdStudentInfoMapper;
import com.cskaoyan.wdjava.service.WdStudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WdStudentInfoServiceImpl implements WdStudentInfoService {

    @Autowired
    WdStudentInfoMapper wdStudentInfoMapper;

    @Override
    public WdStudentInfo queryStudentByName(String username) {
        WdStudentInfoExample wdStudentInfoExample = new WdStudentInfoExample();
        wdStudentInfoExample.createCriteria().andStuNameEqualTo(username).andDeletedEqualTo(0);
        List<WdStudentInfo> wdStudentInfos = wdStudentInfoMapper.selectByExample(wdStudentInfoExample);
        //判空
        return wdStudentInfos.size() == 0 ? null : wdStudentInfos.get(0);
    }

    @Override
    public WdStudentInfo queryStudentById(int id) {
       return wdStudentInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public void batchInsert(List<WdStudentInfo> wdStudentInfoList) {
        for (WdStudentInfo studentInfo : wdStudentInfoList) {
            wdStudentInfoMapper.insertSelective(studentInfo);
        }
    }
}
