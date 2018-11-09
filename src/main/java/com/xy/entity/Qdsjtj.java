package com.xy.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: xy
 * @Date: 2018/10/6 13:32
 * @Description:
 */
@Entity
@Table(name = "qdsjtj")
public class Qdsjtj {
    @Id
    private int id;
    private String qd;
    private String sj;
    private String zk;
    private int pm1;
    private int pm2;
    private int bf1;
    private int bf2;
    private double kql;
    private int jgcs;
    private int wxjg;
    private int smcs;
    private int szcs;
    private int jqs;
    private String sq;

    public Qdsjtj() {
    }

    public Qdsjtj(int id,String qd, String sj, String zk, int pm1, int pm2, int bf1, int bf2, double kql, int jgcs, int wxjg, int smcs, int szcs, int jqs,String sq) {
        this.id = id;
        this.qd = qd;
        this.sj = sj;
        this.zk = zk;
        this.pm1 = pm1;
        this.pm2 = pm2;
        this.bf1 = bf1;
        this.bf2 = bf2;
        this.kql = kql;
        this.jgcs = jgcs;
        this.wxjg = wxjg;
        this.smcs = smcs;
        this.szcs = szcs;
        this.jqs = jqs;
        this.sq = sq;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQd() {
        return qd;
    }

    public void setQd(String qd) {
        this.qd = qd;
    }

    public String getSj() {
        return sj;
    }

    public void setSj(String sj) {
        this.sj = sj;
    }

    public String getZk() {
        return zk;
    }

    public void setZk(String zk) {
        this.zk = zk;
    }

    public int getPm1() {
        return pm1;
    }

    public void setPm1(int pm1) {
        this.pm1 = pm1;
    }

    public int getPm2() {
        return pm2;
    }

    public void setPm2(int pm2) {
        this.pm2 = pm2;
    }

    public int getBf1() {
        return bf1;
    }

    public void setBf1(int bf1) {
        this.bf1 = bf1;
    }

    public int getBf2() {
        return bf2;
    }

    public void setBf2(int bf2) {
        this.bf2 = bf2;
    }

    public double getKql() {
        return kql;
    }

    public void setKql(double kql) {
        this.kql = kql;
    }

    public int getJgcs() {
        return jgcs;
    }

    public void setJgcs(int jgcs) {
        this.jgcs = jgcs;
    }

    public int getWxjg() {
        return wxjg;
    }

    public void setWxjg(int wxjg) {
        this.wxjg = wxjg;
    }

    public int getSmcs() {
        return smcs;
    }

    public void setSmcs(int smcs) {
        this.smcs = smcs;
    }

    public int getSzcs() {
        return szcs;
    }

    public void setSzcs(int szcs) {
        this.szcs = szcs;
    }

    public int getJqs() {
        return jqs;
    }

    public void setJqs(int jqs) {
        this.jqs = jqs;
    }

    public String getSq() {
        return sq;
    }

    public void setSq(String sq) {
        this.sq = sq;
    }

    @Override
    public String toString() {
        return "Qdsjtj{" +
                "id='" + id + '\'' +
                "qd='" + qd + '\'' +
                ", sj='" + sj + '\'' +
                ", zk='" + zk + '\'' +
                ", pm1=" + pm1 +
                ", pm2=" + pm2 +
                ", bf1=" + bf1 +
                ", bf2=" + bf2 +
                ", kql=" + kql +
                ", jgcs=" + jgcs +
                ", wxjg=" + wxjg +
                ", smcs=" + smcs +
                ", szcs=" + szcs +
                ", jqs=" + jqs +
                ", sq=" + sq +
                '}';
    }
}
