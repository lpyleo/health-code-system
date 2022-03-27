package com.controller;

import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.users.TeaCodes;
import com.model.users.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;

@WebServlet(name = "TeacherHealthCode", value = "/TeacherHealthCode")
public class TeacherHealthCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("image/jpg");
        Calendar now=Calendar.getInstance();
        int year=now.get(Calendar.YEAR);
        int month=now.get(Calendar.MONTH)+1;
        int day=now.get(Calendar.DAY_OF_MONTH);
        String today="";
        if(month<10){
            if(day<10){
                today=String.valueOf(year)+"-"+"0"+String.valueOf(month)+"-"+"0"+String.valueOf(day);
            }else {
                today=String.valueOf(year)+"-"+"0"+String.valueOf(month)+"-"+String.valueOf(day);
            }
        }else {
            if(day<10){
                today=String.valueOf(year)+"-"+String.valueOf(month)+"-"+"0"+String.valueOf(day);
            }else {
                today=String.valueOf(year)+"-"+String.valueOf(month)+"-"+String.valueOf(day);
            }
        }
        String name=request.getParameter("name");
        String no=request.getParameter("no");
        String select1=request.getParameter("select1");
        String select2=request.getParameter("select2");
        String select3=request.getParameter("select3");
        String select4=request.getParameter("select4");
        String select5=request.getParameter("select5");
        String []choose=request.getParameterValues("choose");
        Teachers teachers=new Teachers();
        UsersDao dao=new UsersDaoImpl();
        try {
            teachers=dao.findByNo(no);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        try {
            if(!dao.teaHasField(today)){
                dao.addTeaNewField(today);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        //金
        if(select5.equals("是")){
            if(("绿").equals(teachers.getTcodecolor())||("金").equals(teachers.getTcodecolor())){
                try {
                    dao.updateTeacherCode("金",teachers);
                    TeaCodes teaCodes=new TeaCodes();
                    teaCodes.setName(teachers.getTname());
                    teaCodes.setNo(teachers.getTno());
                    teaCodes.setField(today);
                    teaCodes.setAction("4");
                    dao.updateTeaField(teaCodes);
                } catch (DaoException e) {
                    e.printStackTrace();
                }
            }else if (("黄").equals(teachers.getTcodecolor())){
                if (teachers.getTlastyellowtime()==6){
                    try {
                        dao.updateTeacherCode("金",teachers);
                        teachers=dao.updateTeaYellow(teachers);
                        TeaCodes teaCodes=new TeaCodes();
                        teaCodes.setName(teachers.getTname());
                        teaCodes.setNo(teachers.getTno());
                        teaCodes.setField(today);
                        teaCodes.setAction("4");
                        dao.updateTeaField(teaCodes);
                    } catch (DaoException e) {
                        e.printStackTrace();
                    }
                }else {
                    try {
                        teachers=dao.updateTeaYellow(teachers);
                        teachers=dao.updateTeaYellow(teachers);
                        TeaCodes teaCodes=new TeaCodes();
                        teaCodes.setName(teachers.getTname());
                        teaCodes.setNo(teachers.getTno());
                        teaCodes.setField(today);
                        teaCodes.setAction("2");
                        dao.updateTeaField(teaCodes);
                    } catch (DaoException e) {
                        e.printStackTrace();
                    }
                }
            }else if(("红").equals(teachers.getTcodecolor())){
                if(teachers.getTlastredtime()==6){
                    try {
                        dao.updateTeacherCode("黄",teachers);
                        teachers=dao.updateTeaRed(teachers);
                        teachers=dao.updateTeaYellow(teachers);
                        TeaCodes teaCodes=new TeaCodes();
                        teaCodes.setName(teachers.getTname());
                        teaCodes.setNo(teachers.getTno());
                        teaCodes.setField(today);
                        teaCodes.setAction("2");
                        dao.updateTeaField(teaCodes);
                    } catch (DaoException e) {
                        e.printStackTrace();
                    }
                }else {
                    try {
                        teachers=dao.updateTeaRed(teachers);
                        teachers=dao.updateTeaYellow(teachers);
                        TeaCodes teaCodes=new TeaCodes();
                        teaCodes.setName(teachers.getTname());
                        teaCodes.setNo(teachers.getTno());
                        teaCodes.setField(today);
                        teaCodes.setAction("3");
                        dao.updateTeaField(teaCodes);
                    } catch (DaoException e) {
                        e.printStackTrace();
                    }
                }
            }else {
                try {
                    dao.updateTeacherCode("金",teachers);
                    teachers=dao.updateTeaYellow(teachers);
                    TeaCodes teaCodes=new TeaCodes();
                    teaCodes.setName(teachers.getTname());
                    teaCodes.setNo(teachers.getTno());
                    teaCodes.setField(today);
                    teaCodes.setAction("4");
                    dao.updateTeaField(teaCodes);
                } catch (DaoException e) {
                    e.printStackTrace();
                }
            }
        }
        //红
        else if(select3.equals("是")||select4.equals("是")||(!Arrays.asList(choose).contains("good")&&choose.length>=2)||
                (Arrays.asList(choose).contains("good")&&choose.length>=3)){
            try {
                dao.updateTeacherCode("红",teachers);
                teachers.setTlastyellowtime(-1);
                teachers.setTlastredtime(-1);
                teachers=dao.updateTeaYellow(teachers);
                teachers=dao.updateTeaRed(teachers);
                teachers=dao.updateTeaYellow(teachers);
                TeaCodes teaCodes=new TeaCodes();
                teaCodes.setName(teachers.getTname());
                teaCodes.setNo(teachers.getTno());
                teaCodes.setField(today);
                teaCodes.setAction("3");
                dao.updateTeaField(teaCodes);
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }
        //黄
        else if(select1.equals("是")||select2.equals("是")|| (!Arrays.asList(choose).contains("good")&&choose.length==1)||
                (Arrays.asList(choose).contains("good")&&choose.length==2)){
            if (("红").equals(teachers.getTcodecolor())){
                try {
                    teachers.setTlastredtime(-1);
                    teachers=dao.updateTeaRed(teachers);
                    TeaCodes teaCodes=new TeaCodes();
                    teaCodes.setName(teachers.getTname());
                    teaCodes.setNo(teachers.getTno());
                    teaCodes.setField(today);
                    teaCodes.setAction("3");
                    dao.updateTeaField(teaCodes);
                } catch (DaoException e) {
                    e.printStackTrace();
                }
            }else if(("黄").equals(teachers.getTcodecolor())){
                try {
                    teachers.setTlastyellowtime(-1);
                    teachers=dao.updateTeaYellow(teachers);
                    TeaCodes teaCodes=new TeaCodes();
                    teaCodes.setName(teachers.getTname());
                    teaCodes.setNo(teachers.getTno());
                    teaCodes.setField(today);
                    teaCodes.setAction("2");
                    dao.updateTeaField(teaCodes);
                } catch (DaoException e) {
                    e.printStackTrace();
                }
            }else if (("绿").equals(teachers.getTcodecolor())||("金").equals(teachers.getTcodecolor())){
                try {
                    dao.updateTeacherCode("黄",teachers);
                    TeaCodes teaCodes=new TeaCodes();
                    teaCodes.setName(teachers.getTname());
                    teaCodes.setNo(teachers.getTno());
                    teaCodes.setField(today);
                    teaCodes.setAction("2");
                    dao.updateTeaField(teaCodes);
                } catch (DaoException e) {
                    e.printStackTrace();
                }
            }else {
                try {
                    dao.updateTeacherCode("黄",teachers);
                    TeaCodes teaCodes=new TeaCodes();
                    teaCodes.setName(teachers.getTname());
                    teaCodes.setNo(teachers.getTno());
                    teaCodes.setField(today);
                    teaCodes.setAction("2");
                    dao.updateTeaField(teaCodes);
                } catch (DaoException e) {
                    e.printStackTrace();
                }
            }
        }
        //绿
        else{
            if(("绿").equals(teachers.getTcodecolor())){
                try {
                    TeaCodes teaCodes=new TeaCodes();
                    teaCodes.setName(teachers.getTname());
                    teaCodes.setNo(teachers.getTno());
                    teaCodes.setField(today);
                    teaCodes.setAction("1");
                    dao.updateTeaField(teaCodes);
                } catch (DaoException e) {
                    e.printStackTrace();
                }
            }else if (("金").equals(teachers.getTcodecolor())){
                try {
                    TeaCodes teaCodes=new TeaCodes();
                    teaCodes.setName(teachers.getTname());
                    teaCodes.setNo(teachers.getTno());
                    teaCodes.setField(today);
                    teaCodes.setAction("4");
                    dao.updateTeaField(teaCodes);
                } catch (DaoException e) {
                    e.printStackTrace();
                }
            }
            else if (("黄").equals(teachers.getTcodecolor())){
                if (teachers.getTlastyellowtime()==6){
                    try {
                        dao.updateTeacherCode("绿",teachers);
                        teachers=dao.updateTeaYellow(teachers);
                        TeaCodes teaCodes=new TeaCodes();
                        teaCodes.setName(teachers.getTname());
                        teaCodes.setNo(teachers.getTno());
                        teaCodes.setField(today);
                        teaCodes.setAction("1");
                        dao.updateTeaField(teaCodes);
                    } catch (DaoException e) {
                        e.printStackTrace();
                    }
                }else {
                    try {
                        teachers=dao.updateTeaYellow(teachers);
                        TeaCodes teaCodes=new TeaCodes();
                        teaCodes.setName(teachers.getTname());
                        teaCodes.setNo(teachers.getTno());
                        teaCodes.setField(today);
                        teaCodes.setAction("2");
                        dao.updateTeaField(teaCodes);
                    } catch (DaoException e) {
                        e.printStackTrace();
                    }
                }
            }else if(("红").equals(teachers.getTcodecolor())){
                if(teachers.getTlastredtime()==6){
                    try {
                        dao.updateTeacherCode("黄",teachers);
                        teachers=dao.updateTeaRed(teachers);
                        TeaCodes teaCodes=new TeaCodes();
                        teaCodes.setName(teachers.getTname());
                        teaCodes.setNo(teachers.getTno());
                        teaCodes.setField(today);
                        teaCodes.setAction("2");
                        dao.updateTeaField(teaCodes);
                    } catch (DaoException e) {
                        e.printStackTrace();
                    }
                }else {
                    try {
                        teachers=dao.updateTeaRed(teachers);
                        TeaCodes teaCodes=new TeaCodes();
                        teaCodes.setName(teachers.getTname());
                        teaCodes.setNo(teachers.getTno());
                        teaCodes.setField(today);
                        teaCodes.setAction("3");
                        dao.updateTeaField(teaCodes);
                    } catch (DaoException e) {
                        e.printStackTrace();
                    }
                }
            }else {
                try {
                    dao.updateTeacherCode("绿",teachers);
                    TeaCodes teaCodes=new TeaCodes();
                    teaCodes.setName(teachers.getTname());
                    teaCodes.setNo(teachers.getTno());
                    teaCodes.setField(today);
                    teaCodes.setAction("1");
                    dao.updateTeaField(teaCodes);
                } catch (DaoException e) {
                    e.printStackTrace();
                }
            }
        }
        request.getSession().setAttribute("teachers",teachers);
        RequestDispatcher rd= getServletContext().getRequestDispatcher("/teaHealthCode.jsp");
        rd.forward(request,response);
    }
}
