package com.model.users;

import java.io.Serializable;

public class Students implements Serializable {
    private String sname;
    private String sidnumber;
    private String sno;
    private String scollege;
    private String smajor;
    private String sclass;
    private String scodecolor;
    private int slastredtime;
    private int slastyellowtime;

    public Students() {
    }

    public Students(String sname, String sidnumber, String sno, String scollege, String smajor, String sclass, String scodecolor, int slastredtime, int slastyellowtime) {
        this.sname = sname;
        this.sidnumber = sidnumber;
        this.sno = sno;
        this.scollege = scollege;
        this.smajor = smajor;
        this.sclass = sclass;
        this.scodecolor = scodecolor;
        this.slastredtime = slastredtime;
        this.slastyellowtime = slastyellowtime;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSidnumber() {
        return sidnumber;
    }

    public void setSidnumber(String sidnumber) {
        this.sidnumber = sidnumber;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getScollege() {
        return scollege;
    }

    public void setScollege(String scollege) {
        this.scollege = scollege;
    }

    public String getSmajor() {
        return smajor;
    }

    public void setSmajor(String smajor) {
        this.smajor = smajor;
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    public String getScodecolor() {
        return scodecolor;
    }

    public void setScodecolor(String scodecolor) {
        this.scodecolor = scodecolor;
    }

    public int getSlastredtime() {
        return slastredtime;
    }

    public void setSlastredtime(int slastredtime) {
        this.slastredtime = slastredtime;
    }

    public int getSlastyellowtime() {
        return slastyellowtime;
    }

    public void setSlastyellowtime(int slastyellowtime) {
        this.slastyellowtime = slastyellowtime;
    }
}
