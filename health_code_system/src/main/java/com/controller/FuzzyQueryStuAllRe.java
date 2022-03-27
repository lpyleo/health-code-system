package com.controller;

import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.users.StuCodes;
import com.model.users.Students;
import com.model.users.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

@WebServlet(name = "FuzzyQueryStuAllRe", value = "/FuzzyQueryStuAllRe")
public class FuzzyQueryStuAllRe extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Teachers teachers=(Teachers)request.getSession().getAttribute("teachers");
        String name=request.getParameter("name");
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
        String time=(String) request.getSession().getAttribute("time");
        if (time==null){
            time=today;
        }
        UsersDao dao=new UsersDaoImpl();
        ArrayList<StuCodes> stuCodes=new ArrayList<StuCodes>();
        if (teachers.getTrole().equals("院级管理员")){
            try {
                stuCodes=dao.stuCollegeCodeFuzzyQuery(teachers.getTcollege(),name,time);
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }else{
            try {
                stuCodes=dao.stuCodeFuzzyQuery(name,time);
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }
        request.getSession().setAttribute("teachers",teachers);
        request.getSession().setAttribute("stuCodes",stuCodes);
        RequestDispatcher rd= getServletContext().getRequestDispatcher("/fuzzyQueryStuAllRe.jsp");
        rd.forward(request,response);
    }
}
