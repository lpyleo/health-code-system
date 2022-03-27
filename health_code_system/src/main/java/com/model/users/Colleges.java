package com.model.users;

import java.io.Serializable;

public class Colleges implements Serializable {
    private String name;
    private String no;
    private String dean;

    public Colleges() {
    }

    public Colleges(String name, String no, String dean) {
        this.name = name;
        this.no = no;
        this.dean = dean;
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
}
