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
import java.util.Calendar;

@WebServlet(name = "TeaHealthCodeCollection", value = "/TeaHealthCodeCollection")
public class TeaHealthCodeCollection extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Teachers teachers=(Teachers) request.getSession().getAttribute("teachers");
        TeaCodes teaCodes=new TeaCodes();
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
        UsersDao dao=new UsersDaoImpl();
        try {
            if(dao.teaHasField(today)){
                try {
                    teaCodes=dao.teaOneDayCodes(teachers.getTno(),today);
                    teachers=dao.findByNo(teachers.getTno());
                } catch (DaoException e) {
                    e.printStackTrace();
                }
                if(!(("0").equals(teaCodes.getAction()))){
                    request.getSession().setAttribute("teachers",teachers);
                    RequestDispatcher rd= getServletContext().getRequestDispatcher("/teaHealthCode.jsp");
                    rd.forward(request,response);
                }else {
                    request.getSession().setAttribute("teachers",teachers);
                    RequestDispatcher rd= getServletContext().getRequestDispatcher("/teaDailyReport.jsp");
                    rd.forward(request,response);
                }
            }else {
                request.getSession().setAttribute("teachers",teachers);
                RequestDispatcher rd= getServletContext().getRequestDispatcher("/teaDailyReport.jsp");
                rd.forward(request,response);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
