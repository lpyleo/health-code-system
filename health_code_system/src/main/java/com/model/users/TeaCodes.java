package com.model.users;

import java.io.Serializable;

public class TeaCodes implements Serializable {
    private String name;
    private String no;
    private String college;
    private String field;
    private String action;
    private String color;

    public TeaCodes() {
    }

    public TeaCodes(String name, String no, String college, String field, String action, String color) {
        this.name = name;
        this.no = no;
        this.college = college;
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
