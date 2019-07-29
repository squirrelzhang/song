package com.cskaoyan.wdjava.controller;

import com.cskaoyan.wdjava.bean.WdStudentInfo;
import com.cskaoyan.wdjava.exception.WdFileTypeException;
import com.cskaoyan.wdjava.service.WdFileService;
import com.cskaoyan.wdjava.service.WdStudentInfoService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by little Stone
 * Date 2019/7/10 Time 9:20
 */
@Controller
@RequestMapping("stu")
public class StuInfoController {

    /**
     * @param page 实现页面的跳转
     * @return
     */
    @RequestMapping("{page}")
    public String page(@PathVariable("page") String page) {
        return "/stu/" + page;
    }

    @Autowired
    WdFileService wdFileService;

    @Autowired
    WdStudentInfoService wdStudentInfoService;

    //提供一个文件上传，生成默认的信息，功能提供给管理员
    @RequestMapping("defaultInfoUpload")
    public String defaultInfoUpload(String termName, MultipartFile multipartFile) throws Exception {
        boolean isText = multipartFile.getOriginalFilename().endsWith(".txt");
        //如果文件类型不为txt，则生成文件异常
        if (!isText) {
            throw new WdFileTypeException();
        }
        boolean parseOk = wdFileService.parseStudentInfo(termName, multipartFile);


        return "/stu/uploadSuccess";
    }

    /**
     * 文件上传页的跳转
     *
     * @return
     */
    @RequestMapping(value = {"upload"})
    public String upload() {

        return "/stu/index";
    }

    @RequestMapping("queryInfo")
    public String update() {
        String principal = (String) SecurityUtils.getSubject().getPrincipal();

        //wdStudentInfoService.queryStudentInfo


        return "";
    }


    /**
     * 初始化学号
     *
     * @return
     */
    @RequestMapping("initSn")
    public String initSn() {

        return "";
    }

    /**
     * 通过学生的id值获取学生的具体信息
     *
     * */
    @RequestMapping("/info/{id}")
    @ResponseBody
    public WdStudentInfo getStudentInfo(@PathVariable(value = "id") int id){
        WdStudentInfo studentInfo = wdStudentInfoService.queryStudentById(id);
        return studentInfo;
    }

}
