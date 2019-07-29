package com.cskaoyan.wdjava.service;

import com.cskaoyan.wdjava.bean.WdStudentInfo;

import java.util.List;

public interface WdStudentInfoService {
    WdStudentInfo queryStudentByName(String username);

    WdStudentInfo queryStudentById(int id);

    void batchInsert(List<WdStudentInfo> wdStudentInfoList);
}
