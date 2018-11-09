package com.xy.controller;

import com.alibaba.fastjson.JSON;
import com.xy.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @program: data-analysis
 * @description: 登录验证
 * @author: XiaoYang
 * @create: 2018-08-04 23:48
 **/
@RestController
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/login")
    public void login(HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (userRepository.findUserByUsername(username) == null){
            response.getWriter().write(JSON.toJSONString("用户不存在"));
        }else if(userRepository.findUserByUsernameAndPassword(username,password) == null){
            response.getWriter().write(JSON.toJSONString("密码错误"));
        }else {
            response.getWriter().write(JSON.toJSONString("登录成功"));
        }

    }
}