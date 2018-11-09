package com.xy.controller;

import com.alibaba.fastjson.JSON;

import com.xy.dao.DataRepository;
import com.xy.entity.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @program: data-analysis
 * @description: 获取数据
 * @author: XiaoYang
 * @create: 2018-08-04 17:39
 **/
@RestController
public class DataController {

    @Autowired
    DataRepository dataRepository;

    @RequestMapping("/getDataByInfo")
    public void getDataByInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");

        String  num = request.getParameter("info");

        if(num.contains(",")){
            num = num.replace(",","，");
        }
        int page = Integer.parseInt(request.getParameter("currentPage"));//当前页
        int size = Integer.parseInt(request.getParameter("pageSize"));//每页显示多少条数据
        Pageable pageable = new PageRequest(page,size);

        Page<Data> data = null;
        if(num.length() == 3){
            data = dataRepository.findDataByType(num,pageable);
        }else {
            data = dataRepository.findDataByNum(num,pageable);
        }
        List<Data> list = data.getContent();
        if (list.size() == 0){
            response.getWriter().write(JSON.toJSONString("没有相关数据!"));
        }else {
            Map map = new HashMap();
            map.put("list",list);
            map.put("totalPages",data.getTotalPages());//总页数
            map.put("totalElements",data.getTotalElements());//总数据条数
            response.getWriter().write(JSON.toJSONString(map));
        }
    }

    /**
     * 通过id查询数据
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/getDataById")
    public void getDataById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");

        int id = Integer.parseInt(request.getParameter("id"));

        Data data = dataRepository.findDataById(id);
        response.getWriter().write(JSON.toJSONString(data.getNum()));
    }

    /**
     * 修改数据信息
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/saveDataById")
    public void saveDataById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");

        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        String num = request.getParameter("num");
        System.out.println(num);
        Data data = dataRepository.findDataById(id);
        data.setNum(num);
        dataRepository.save(data);
        response.getWriter().write(JSON.toJSONString(dataRepository.findDataById(id)));
    }

    /**
     * 通过id组查询数据
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/getDataByIds")
    public void getDataByIds(HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");

        String ids = request.getParameter("ids");

        Data data = null;
        List list = new ArrayList();
        if(ids.contains(",")){
            String[] arrs = ids.split(",");
            for (String s : arrs){
                data = dataRepository.findDataById(Integer.parseInt(s));
                list.add(data.getNum());
            }
        }else {
            data = dataRepository.findDataById(Integer.parseInt(ids));
            list.add(data.getNum());
        }
        response.getWriter().write(JSON.toJSONString(list));
    }

    /**
     * 录入数据
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/addData")
    public void addData(HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");

        String  num = request.getParameter("info");

        if(num.contains(",")){
            num = num.replace(",","，");
        }
        System.out.println(num.split("，")[0]);
        System.out.println(num.split("，")[1]);
        //获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(new Date());

        long count = dataRepository.count();

        Data data = new Data();
        data.setNum(num);
        data.setType(String.valueOf(countString(num.split("，")[0])+"，"+String.valueOf(countString(num.split("，")[1]))));
        data.setAddTime(format);
        data.setUpdataTime(format);
        Data save = dataRepository.save(data);
        System.out.println(save.toString());

        if(dataRepository.count() > count){
            response.getWriter().write(JSON.toJSONString("success"));
        }else {
            response.getWriter().write(JSON.toJSONString("false"));
        }
    }

    /**
     * 查询所有数据按最新时间排序
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/getAllData")
    public void getAllData(HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        int page = Integer.parseInt(request.getParameter("currentPage"));//当前页
        int size = Integer.parseInt(request.getParameter("pageSize"));//每页显示多少条数据
        Pageable pageable = new PageRequest(page,size);
        Page<Data> d = dataRepository.findAll(pageable);
        List<Data> list = d.getContent();
        Map map = new HashMap();
        map.put("list",list);
        map.put("totalPages",d.getTotalPages());//总页数
        map.put("totalElements",d.getTotalElements());//总数据条数
        response.getWriter().write(JSON.toJSONString(map));
    }

    /**
     * 根据id删除数据
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/deleteDataById")
    public void deleteDataById(HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");

        dataRepository.deleteById(Integer.valueOf(request.getParameter("id")));
        response.getWriter().write(JSON.toJSONString("success"));
    }

    /**
     * 统计1的位数
     * @param str
     * @return
     */
    private static int countString(String str) {
        String s = "1";
        int count = 0;
        for(int i= str.length(); i>-1; i--){
            if(str.lastIndexOf(s) == i){
                str = str.substring(0,i);
                count++;
            }
        }
        System.out.println(count);
        return count;
    }
}