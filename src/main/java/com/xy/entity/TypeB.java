package com.xy.entity;

import javax.persistence.*;

/**
 * @program: data-analysis
 * @description: 8位数
 * @author: XiaoYang
 * @create: 2018-08-05 17:34
 **/
@Entity
@Table(name = "b")
public class TypeB {
    @Id
    private int id;

    private String num;

    private String type;

    public TypeB() {
    }

    public TypeB(int id, String num, String type) {
        this.id = id;
        this.num = num;
        this.type = type;
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

    @Override
    public String toString() {
        return "TypeB{" +
                "id=" + id +
                ", num='" + num + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}