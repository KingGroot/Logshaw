package com.xy.controller;

import com.alibaba.fastjson.JSON;
import com.xy.dao.QdtjRepository;
import com.xy.entity.Qdsjtj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xy
 * @Date: 2018/10/6 13:50
 * @Description:
 */
@RestController
public class QdtjController{

    @Autowired
    QdtjRepository qdtjRepository;

    @RequestMapping("/savaQsData")
    public void savaQsData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");

        Qdsjtj qdsjtj = new Qdsjtj();
        qdsjtj.setBf1(Integer.parseInt(request.getParameter("bf1")));
        qdsjtj.setBf2(Integer.parseInt(request.getParameter("bf2")));
        qdsjtj.setJgcs(Integer.parseInt(request.getParameter("jgcs")));
        qdsjtj.setJqs(Integer.parseInt(request.getParameter("jqs")));
        qdsjtj.setKql(Double.parseDouble(request.getParameter("kql")));
        qdsjtj.setPm1(Integer.parseInt(request.getParameter("pm1")));
        qdsjtj.setPm2(Integer.parseInt(request.getParameter("pm2")));
        qdsjtj.setQd(request.getParameter("qd"));
        qdsjtj.setSj(request.getParameter("sj"));
        qdsjtj.setSmcs(Integer.parseInt(request.getParameter("smcs")));
        qdsjtj.setSzcs(Integer.parseInt(request.getParameter("szcs")));
        qdsjtj.setWxjg(Integer.parseInt(request.getParameter("wxjg")));
        qdsjtj.setZk(request.getParameter("zk"));
        qdsjtj.setSq(request.getParameter("sq"));

        Qdsjtj save = qdtjRepository.save(qdsjtj);

        System.out.println("qdsjtj对象："+qdsjtj.toString());
        System.out.println("save对象："+save);
        response.getWriter().write(JSON.toJSONString(save));
    }

    @RequestMapping("/getAllQd")
    public void getAllQd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(qdtjRepository.findQdsjtjBySq(request.getParameter("sq"))));
    }

    @RequestMapping("/getQdDataByQd")
    public void getQdDataByQd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(qdtjRepository.findQdsjtjByQd(request.getParameter("qd"))));
    }

    @RequestMapping("/getDataByIdss")
    public void getDataByIdss(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");

        String[] id = request.getParameter("ids").split(",");
        List<Qdsjtj> list = new ArrayList<>();
        Qdsjtj qdsjtj = null;
        for (String anId : id) {
            qdsjtj = qdtjRepository.findQdsjtjById(Integer.parseInt(anId));
            list.add(qdsjtj);
        }
        response.getWriter().write(JSON.toJSONString(list));
    }
}
