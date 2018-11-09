package com.xy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: data-analysis
 * @description: 跳转登录页面
 * @author: XiaoYang
 * @create: 2018-08-04 20:44
 **/
@Controller
public class FrontPageController {
    @RequestMapping("/frontPage")
    public String goFrontPage(){
        return "index.html";
    }
}