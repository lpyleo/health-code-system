package com.controller;

import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.users.StuCodes;
import com.model.users.Students;
import com.model.users.TeaCodes;
import com.model.users.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

@WebServlet(name = "StuAllHealthCodes", value = "/StuAllHealthCodes")
public class StuAllHealthCodes extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
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
        Teachers teachers=(Teachers) request.getSession().getAttribute("teachers");
        UsersDao dao=new UsersDaoImpl();
        try {
            ArrayList<Students> students=null;
            if(teachers.getTrole().equals("院级管理员")){
                students=dao.findStudentsAndCollegesByFuzzyName(teachers.getTcollege(),teachers.getTcollege());
            }else {
                students=dao.findAllStudents();
            }
            request.getSession().setAttribute("teachers",teachers);
            request.getSession().setAttribute("students",students);
            RequestDispatcher rd= getServletContext().getRequestDispatcher("/stuAllHealthCodes.jsp");
            rd.forward(request,response);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
