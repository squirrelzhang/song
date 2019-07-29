package com.cskaoyan.wdjava.service.impl;

import com.cskaoyan.wdjava.bean.WdStudentInfo;
import com.cskaoyan.wdjava.bean.WdTerm;
import com.cskaoyan.wdjava.bean.WdTermExample;
import com.cskaoyan.wdjava.exception.WdTermExistException;
import com.cskaoyan.wdjava.mapper.WdStudentInfoMapper;
import com.cskaoyan.wdjava.mapper.WdTermMapper;
import com.cskaoyan.wdjava.service.WdFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;

@Service
public class WdFileServiceImpl implements WdFileService {

    @Autowired
    WdTermMapper wdTermMapper;
    @Autowired
    WdStudentInfoMapper wdStudentInfoMapper;

    @Override
    public boolean parseStudentInfo(String termName, MultipartFile multipartFile) throws Exception {
        //查询term学期的名字 如果已经存在了，则抛出异常
        WdTermExample wdTermExample = new WdTermExample();
        wdTermExample.createCriteria().andTermNameEqualTo(termName).andDeletedEqualTo(0);
        List<WdTerm> wdTerms = wdTermMapper.selectByExample(wdTermExample);
        if (wdTerms.size() > 0) {
            throw new WdTermExistException();
        }
        WdTerm wdTerm = createDefaultTerm(termName);

        wdTermMapper.insert(wdTerm);

        //获得刚刚输入的termId，通过selectKey获得
        Integer termId = wdTerm.getId();

        InputStream inputStream = multipartFile.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String singleLineName = null;
        while ((singleLineName = bufferedReader.readLine()) != null) {
            //读取一行的信息 并且存储到数据库中
            readSingleStudentNameAndSave(termId, singleLineName);
            //处理权限信息 后续处理吧
        }
        //new BufferedReader(new FileReader())

        return true;
    }

    /**
     * 将一个学生的信息存储起来
     *
     * @param termId
     * @param studentName
     */
    private void readSingleStudentNameAndSave(Integer termId, String studentName) {
        WdStudentInfo wdStudentInfo = new WdStudentInfo(studentName, termId);

        wdStudentInfoMapper.insert(wdStudentInfo);

    }

    /**
     * 创建一个默认的学期信息
     *
     * @param termName
     * @return
     */
    private WdTerm createDefaultTerm(String termName) {
        WdTerm wdTerm = new WdTerm();
        wdTerm.setTermName(termName);
        wdTerm.setDeleted(0);
        wdTerm.setDesc("default");
        Date date = new Date();
        wdTerm.setStartTime(date);
        wdTerm.setEndTime(date);
        return wdTerm;
    }
}
