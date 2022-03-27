package com.model.users;

import java.io.Serializable;

public class StuCodes implements Serializable {
    private String name;
    private String no;
    private String college;
    private String major;
    private String classes;
    private String field;
    private String action;
    private String color;

    public StuCodes() {
    }

    public StuCodes(String name, String no, String college, String major, String classes, String field, String action, String color) {
        this.name = name;
        this.no = no;
        this.college = college;
        this.major = major;
        this.classes = classes;
        this.field = field;
        this.action = action;
        this.color = color;
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

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
