/**
 * User: zsquirrel
 * Date: 2019-07-23
 * Time: 14:52
 */
package com.cskaoyan.wdjava.controller;

import com.cskaoyan.wdjava.bean.WdTerm;
import com.cskaoyan.wdjava.service.WdTermService;
import com.cskaoyan.wdjava.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TermController {

    @Autowired
    WdTermService wdTermService;

    /**
     * 返回当前阶段有效的期
     * deleted状态码1表示当前是正在进行的期
     * 0表示该期已经结课
     * 2表示尚未开课
     * */
    @RequestMapping("/terms")
    public Result getCurrentTerms(){
       List<WdTerm> terms = wdTermService.queryCurrentTerms(1);
        Result result = new Result();
        result.setRet(true);
        result.setData(terms);
        return result;
    }

    /**
     * 根据某一期的id值去查询当前教室的座位排布
     * 同时查询出该期的学生的座次表信息
     *
     * */
    @RequestMapping("/term/{id}")
    public Result getTermSeatArrange(@PathVariable(value = "id") int id){
        Map<String,Object> map = wdTermService.selectSeatArrange(id);
        Result result = new Result();
        result.setData(map);
        result.setRet(true);
        return result;
    }
}
