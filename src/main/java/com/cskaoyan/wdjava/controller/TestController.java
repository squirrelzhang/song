/**
 * User: zsquirrel
 * Date: 2019-07-22
 * Time: 15:23
 */
package com.cskaoyan.wdjava.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/all")
    public String test1(){
        return "hello springboot";
    }
}
