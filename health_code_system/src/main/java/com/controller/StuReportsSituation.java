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
import java.util.ArrayList;

@WebServlet(name = "StuReportsSituation", value = "/StuReportsSituation")
public class StuReportsSituation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Students students=(Students) request.getSession().getAttribute("students");
        UsersDao dao=new UsersDaoImpl();
        try {
            ArrayList<StuCodes> stuCodes=new ArrayList<StuCodes>(dao.stuOneCodes(students.getSno()));
            request.getSession().setAttribute("students",students);
            request.getSession().setAttribute("stuCodes",stuCodes);
            RequestDispatcher rd= getServletContext().getRequestDispatcher("/stuReportsSituation.jsp");
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
