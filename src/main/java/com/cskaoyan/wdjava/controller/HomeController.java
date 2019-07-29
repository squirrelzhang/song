package com.cskaoyan.wdjava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by little Stone
 * Date 2019/7/9 Time 17:50
 */
@Controller
public class HomeController {

    @RequestMapping(value = {"/", "index"})
    public String home() {
        return "index";
    }

    @RequestMapping(value = {"/admin", "admin/index"})
    public String adminHome() {
        return "adminLogin";
    }


    @RequestMapping("{page}")
    public String page(@PathVariable("page") String page) {

        return page;
    }


}
