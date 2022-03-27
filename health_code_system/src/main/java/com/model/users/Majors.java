package com.model.users;

import java.io.Serializable;

public class Majors implements Serializable {
    private String name;
    private String no;
    private String dean;
    private String college;

    public Majors() {
    }

    public Majors(String name, String no, String dean, String college) {
        this.name = name;
        this.no = no;
        this.dean = dean;
        this.college = college;
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

    public String getDean() {
        return dean;
    }

    public void setDean(String dean) {
        this.dean = dean;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }
}
