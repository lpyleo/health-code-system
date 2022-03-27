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
import java.util.ArrayList;

@WebServlet(name = "TeaReportsSituation", value = "/TeaReportsSituation")
public class TeaReportsSituation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Teachers teachers=(Teachers) request.getSession().getAttribute("teachers");
        UsersDao dao=new UsersDaoImpl();
        try {
            ArrayList<TeaCodes> teaCodes=new ArrayList<TeaCodes>(dao.teaOneCodes(teachers.getTno()));
            request.getSession().setAttribute("teachers",teachers);
            request.getSession().setAttribute("teaCodes",teaCodes);
            RequestDispatcher rd= getServletContext().getRequestDispatcher("/teaReportsSituation.jsp");
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
