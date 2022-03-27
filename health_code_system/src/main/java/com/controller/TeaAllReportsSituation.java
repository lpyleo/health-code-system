package com.controller;

import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.users.StuCodes;
import com.model.users.TeaCodes;
import com.model.users.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

@WebServlet(name = "TeaAllReportsSituation", value = "/TeaAllReportsSituation")
public class TeaAllReportsSituation extends HttpServlet {
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
            ArrayList<TeaCodes> teaCodes=new ArrayList<TeaCodes>();
            if (dao.teaHasField(today)){
                if(teachers.getTrole().equals("院级管理员")){
                    teaCodes=new ArrayList<TeaCodes>(dao.teaCollegeCodes(teachers.getTcollege(),today));
                }else {
                    teaCodes=new ArrayList<TeaCodes>(dao.teaAllCodes(today));
                }
            }
            request.getSession().setAttribute("teachers",teachers);
            request.getSession().setAttribute("teaCodes",teaCodes);
            RequestDispatcher rd= getServletContext().getRequestDispatcher("/teaAllReports.jsp");
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
