package com.xy.entity;

import javax.persistence.*;

/**
 * @program: data-analysis
 * @description: 9位数
 * @author: XiaoYang
 * @create: 2018-08-05 17:34
 **/
@Entity
@Table(name = "a")
public class TypeA {
    @Id
    private int id;

    private String num;

    private String type;

    public TypeA() {
    }

    public TypeA(int id, String num, String type) {
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
        return "TypeA{" +
                "id=" + id +
                ", num='" + num + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}