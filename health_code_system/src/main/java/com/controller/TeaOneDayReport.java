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

@WebServlet(name = "TeaOneDayReport", value = "/TeaOneDayReport")
public class TeaOneDayReport extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Teachers teachers=(Teachers) request.getSession().getAttribute("teachers");
        String time=request.getParameter("start");
        String t=time.substring(6)+"-"+time.substring(0,2)+"-"+time.substring(3,5);
        UsersDao dao=new UsersDaoImpl();
        try {
            TeaCodes teaCodes=new TeaCodes();
            if(dao.teaHasField(t)){
                teaCodes=dao.teaOneDayCodes(teachers.getTno(),t);
            }
            request.getSession().setAttribute("teachers",teachers);
            request.getSession().setAttribute("teaCodes",teaCodes);
            RequestDispatcher rd= getServletContext().getRequestDispatcher("/teaOneDayReport.jsp");
            rd.forward(request,response);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
