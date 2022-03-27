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
import java.util.Calendar;

@WebServlet(name = "StuHealthCodeCollection", value = "/StuHealthCodeCollection")
public class StuHealthCodeCollection extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Students students=(Students) request.getSession().getAttribute("students");
        StuCodes stuCodes=new StuCodes();
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
            if(dao.stuHasField(today)){
                try {
                    stuCodes=dao.stuOneDayCodes(students.getSno(),today);
                    students=dao.findStudentsByNo(students.getSno());
                } catch (DaoException e) {
                    e.printStackTrace();
                }
                if(!(("0").equals(stuCodes.getAction()))){
                    request.getSession().setAttribute("students",students);
                    RequestDispatcher rd= getServletContext().getRequestDispatcher("/stuHealthCode.jsp");
                    rd.forward(request,response);
                }else {
                    request.getSession().setAttribute("students",students);
                    RequestDispatcher rd= getServletContext().getRequestDispatcher("/stuDailyReport.jsp");
                    rd.forward(request,response);
                }
            }else {
                request.getSession().setAttribute("students",students);
                RequestDispatcher rd= getServletContext().getRequestDispatcher("/stuDailyReport.jsp");
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
