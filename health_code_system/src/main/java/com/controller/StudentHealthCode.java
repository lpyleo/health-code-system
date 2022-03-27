package com.controller;

import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.users.StuCodes;
import com.model.users.Students;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;

@WebServlet(name = "StudentHealthCode", value = "/StudentHealthCode")
public class StudentHealthCode extends HttpServlet {
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
        Students students=new Students();
        UsersDao dao=new UsersDaoImpl();
        try {
            students=dao.findStudentsByNo(no);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        try {
            if(!dao.stuHasField(today)){
                dao.addStuNewField(today);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        //金
        if(select5.equals("是")){
            if(("绿").equals(students.getScodecolor())||("金").equals(students.getScodecolor())){
                try {
                    dao.updateStudentCode("金",students);
                    StuCodes stuCodes=new StuCodes();
                    stuCodes.setName(students.getSname());
                    stuCodes.setNo(students.getSno());
                    stuCodes.setField(today);
                    stuCodes.setAction("4");
                    dao.updateStuField(stuCodes);
                } catch (DaoException e) {
                    e.printStackTrace();
                }
            }else if (("黄").equals(students.getScodecolor())){
                if (students.getSlastyellowtime()==6){
                    try {
                        dao.updateStudentCode("金",students);
                        students=dao.updateStuYellow(students);
                        StuCodes stuCodes=new StuCodes();
                        stuCodes.setName(students.getSname());
                        stuCodes.setNo(students.getSno());
                        stuCodes.setField(today);
                        stuCodes.setAction("4");
                        dao.updateStuField(stuCodes);
                    } catch (DaoException e) {
                        e.printStackTrace();
                    }
                }else {
                    try {
                        students=dao.updateStuYellow(students);
                        students=dao.updateStuYellow(students);
                        StuCodes stuCodes=new StuCodes();
                        stuCodes.setName(students.getSname());
                        stuCodes.setNo(students.getSno());
                        stuCodes.setField(today);
                        stuCodes.setAction("2");
                        dao.updateStuField(stuCodes);
                    } catch (DaoException e) {
                        e.printStackTrace();
                    }
                }
            }else if(("红").equals(students.getScodecolor())){
                if(students.getSlastredtime()==6){
                    try {
                        dao.updateStudentCode("黄",students);
                        students=dao.updateStuRed(students);
                        students=dao.updateStuYellow(students);
                        StuCodes stuCodes=new StuCodes();
                        stuCodes.setName(students.getSname());
                        stuCodes.setNo(students.getSno());
                        stuCodes.setField(today);
                        stuCodes.setAction("2");
                        dao.updateStuField(stuCodes);
                    } catch (DaoException e) {
                        e.printStackTrace();
                    }
                }else {
                    try {
                        students=dao.updateStuRed(students);
                        students=dao.updateStuYellow(students);
                        StuCodes stuCodes=new StuCodes();
                        stuCodes.setName(students.getSname());
                        stuCodes.setNo(students.getSno());
                        stuCodes.setField(today);
                        stuCodes.setAction("3");
                        dao.updateStuField(stuCodes);
                    } catch (DaoException e) {
                        e.printStackTrace();
                    }
                }
            }else {
                try {
                    dao.updateStudentCode("金",students);
                    students=dao.updateStuYellow(students);
                    StuCodes stuCodes=new StuCodes();
                    stuCodes.setName(students.getSname());
                    stuCodes.setNo(students.getSno());
                    stuCodes.setField(today);
                    stuCodes.setAction("4");
                    dao.updateStuField(stuCodes);
                } catch (DaoException e) {
                    e.printStackTrace();
                }
            }
        }
        //红
        else if(select3.equals("是")||select4.equals("是")||(!Arrays.asList(choose).contains("good")&&choose.length>=2)||
                (Arrays.asList(choose).contains("good")&&choose.length>=3)){
            try {
                dao.updateStudentCode("红",students);
                students.setSlastyellowtime(-1);
                students.setSlastredtime(-1);
                students=dao.updateStuYellow(students);
                students=dao.updateStuRed(students);
                students=dao.updateStuYellow(students);
                StuCodes stuCodes=new StuCodes();
                stuCodes.setName(students.getSname());
                stuCodes.setNo(students.getSno());
                stuCodes.setField(today);
                stuCodes.setAction("3");
                dao.updateStuField(stuCodes);
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }
        //黄
        else if(select1.equals("是")||select2.equals("是")|| (!Arrays.asList(choose).contains("good")&&choose.length==1)||
                (Arrays.asList(choose).contains("good")&&choose.length==2)){
            if (("红").equals(students.getScodecolor())){
                try {
                    students.setSlastredtime(-1);
                    students=dao.updateStuRed(students);
                    StuCodes stuCodes=new StuCodes();
                    stuCodes.setName(students.getSname());
                    stuCodes.setNo(students.getSno());
                    stuCodes.setField(today);
                    stuCodes.setAction("3");
                    dao.updateStuField(stuCodes);
                } catch (DaoException e) {
                    e.printStackTrace();
                }
            }else if(("黄").equals(students.getScodecolor())){
                try {
                    students.setSlastyellowtime(-1);
                    students=dao.updateStuYellow(students);
                    StuCodes stuCodes=new StuCodes();
                    stuCodes.setName(students.getSname());
                    stuCodes.setNo(students.getSno());
                    stuCodes.setField(today);
                    stuCodes.setAction("2");
                    dao.updateStuField(stuCodes);
                } catch (DaoException e) {
                    e.printStackTrace();
                }
            }else if (("绿").equals(students.getScodecolor())||("金").equals(students.getScodecolor())){
                try {
                    dao.updateStudentCode("黄",students);
                    StuCodes stuCodes=new StuCodes();
                    stuCodes.setName(students.getSname());
                    stuCodes.setNo(students.getSno());
                    stuCodes.setField(today);
                    stuCodes.setAction("2");
                    dao.updateStuField(stuCodes);
                } catch (DaoException e) {
                    e.printStackTrace();
                }
            }else {
                try {
                    dao.updateStudentCode("黄",students);
                    StuCodes stuCodes=new StuCodes();
                    stuCodes.setName(students.getSname());
                    stuCodes.setNo(students.getSno());
                    stuCodes.setField(today);
                    stuCodes.setAction("2");
                    dao.updateStuField(stuCodes);
                } catch (DaoException e) {
                    e.printStackTrace();
                }
            }
        }
        //绿
        else{
            if(("绿").equals(students.getScodecolor())){
                try {
                    StuCodes stuCodes=new StuCodes();
                    stuCodes.setName(students.getSname());
                    stuCodes.setNo(students.getSno());
                    stuCodes.setField(today);
                    stuCodes.setAction("1");
                    dao.updateStuField(stuCodes);
                } catch (DaoException e) {
                    e.printStackTrace();
                }
            }else if (("金").equals(students.getScodecolor())){
                try {
                    StuCodes stuCodes=new StuCodes();
                    stuCodes.setName(students.getSname());
                    stuCodes.setNo(students.getSno());
                    stuCodes.setField(today);
                    stuCodes.setAction("4");
                    dao.updateStuField(stuCodes);
                } catch (DaoException e) {
                    e.printStackTrace();
                }
            }
            else if (("黄").equals(students.getScodecolor())){
                if (students.getSlastyellowtime()==6){
                    try {
                        dao.updateStudentCode("绿",students);
                        students=dao.updateStuYellow(students);
                        StuCodes stuCodes=new StuCodes();
                        stuCodes.setName(students.getSname());
                        stuCodes.setNo(students.getSno());
                        stuCodes.setField(today);
                        stuCodes.setAction("1");
                        dao.updateStuField(stuCodes);
                    } catch (DaoException e) {
                        e.printStackTrace();
                    }
                }else {
                    try {
                        students=dao.updateStuYellow(students);
                        StuCodes stuCodes=new StuCodes();
                        stuCodes.setName(students.getSname());
                        stuCodes.setNo(students.getSno());
                        stuCodes.setField(today);
                        stuCodes.setAction("2");
                        dao.updateStuField(stuCodes);
                    } catch (DaoException e) {
                        e.printStackTrace();
                    }
                }
            }else if(("红").equals(students.getScodecolor())){
                if(students.getSlastredtime()==6){
                    try {
                        dao.updateStudentCode("黄",students);
                        students=dao.updateStuRed(students);
                        StuCodes stuCodes=new StuCodes();
                        stuCodes.setName(students.getSname());
                        stuCodes.setNo(students.getSno());
                        stuCodes.setField(today);
                        stuCodes.setAction("2");
                        dao.updateStuField(stuCodes);
                    } catch (DaoException e) {
                        e.printStackTrace();
                    }
                }else {
                    try {
                        students=dao.updateStuRed(students);
                        StuCodes stuCodes=new StuCodes();
                        stuCodes.setName(students.getSname());
                        stuCodes.setNo(students.getSno());
                        stuCodes.setField(today);
                        stuCodes.setAction("3");
                        dao.updateStuField(stuCodes);
                    } catch (DaoException e) {
                        e.printStackTrace();
                    }
                }
            }else {
                try {
                    dao.updateStudentCode("绿",students);
                    StuCodes stuCodes=new StuCodes();
                    stuCodes.setName(students.getSname());
                    stuCodes.setNo(students.getSno());
                    stuCodes.setField(today);
                    stuCodes.setAction("1");
                    dao.updateStuField(stuCodes);
                } catch (DaoException e) {
                    e.printStackTrace();
                }
            }
        }
        request.getSession().setAttribute("students",students);
        RequestDispatcher rd= getServletContext().getRequestDispatcher("/stuHealthCode.jsp");
        rd.forward(request,response);
    }
}
