package com.xy.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @program: data-analysis
 * @description: 数据类
 * @author: XiaoYang
 * @create: 2018-08-05 01:05
 **/
@Entity
@Table(name = "datas")
public class Data {

    @Id
    private int id;

    private String num;

    private String type;

    private String addTime;

    private String updataTime;

    public Data() {
    }

    public Data(int id, String num, String type, String addTime, String updataTime) {
        this.id = id;
        this.num = num;
        this.type = type;
        this.addTime = addTime;
        this.updataTime = updataTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getUpdataTime() {
        return updataTime;
    }

    public void setUpdataTime(String updataTime) {
        this.updataTime = updataTime;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", num='" + num + '\'' +
                ", type='" + type + '\'' +
                ", addTime=" + addTime +
                ", updataTime=" + updataTime +
                '}';
    }
}