package com.model.users;

import java.io.Serializable;

public class Classes implements Serializable {
    private String name;
    private String no;
    private String headmaster;
    private String college;
    private String major;

    public Classes() {
    }

    public Classes(String name, String no, String headmaster, String college, String major) {
        this.name = name;
        this.no = no;
        this.headmaster = headmaster;
        this.college = college;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getHeadmaster() {
        return headmaster;
    }

    public void setHeadmaster(String headmaster) {
        this.headmaster = headmaster;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
