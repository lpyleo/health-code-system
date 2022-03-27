package com.model.users;

import java.io.Serializable;

public class Teachers implements Serializable {
    private String tname;
    private String tidnumber;
    private String tno;
    private String tcollege;
    private String trole;
    private String tpassword;
    private String tcodecolor;
    private int tlastredtime;
    private int tlastyellowtime;

    public Teachers() {
    }

    public Teachers(String tname, String tidnumber, String tno, String tcollege, String trole, String tpassword, String tcodecolor, int tlastredtime, int tlastyellowtime) {
        this.tname = tname;
        this.tidnumber = tidnumber;
        this.tno = tno;
        this.tcollege = tcollege;
        this.trole = trole;
        this.tpassword = tpassword;
        this.tcodecolor = tcodecolor;
        this.tlastredtime = tlastredtime;
        this.tlastyellowtime = tlastyellowtime;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTidnumber() {
        return tidnumber;
    }

    public void setTidnumber(String tidnumber) {
        this.tidnumber = tidnumber;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getTcollege() {
        return tcollege;
    }

    public void setTcollege(String tcollege) {
        this.tcollege = tcollege;
    }

    public String getTrole() {
        return trole;
    }

    public void setTrole(String trole) {
        this.trole = trole;
    }

    public String getTpassword() {
        return tpassword;
    }

    public void setTpassword(String tpassword) {
        this.tpassword = tpassword;
    }

    public String getTcodecolor() {
        return tcodecolor;
    }

    public void setTcodecolor(String tcodecolor) {
        this.tcodecolor = tcodecolor;
    }

    public int getTlastredtime() {
        return tlastredtime;
    }

    public void setTlastredtime(int tlastredtime) {
        this.tlastredtime = tlastredtime;
    }

    public int getTlastyellowtime() {
        return tlastyellowtime;
    }

    public void setTlastyellowtime(int tlastyellowtime) {
        this.tlastyellowtime = tlastyellowtime;
    }
}
