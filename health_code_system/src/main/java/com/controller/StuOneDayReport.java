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

@WebServlet(name = "StuOneDayReport", value = "/StuOneDayReport")
public class StuOneDayReport extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Students students=(Students) request.getSession().getAttribute("students");
        String time=request.getParameter("start");
        String t=time.substring(6)+"-"+time.substring(0,2)+"-"+time.substring(3,5);
        UsersDao dao=new UsersDaoImpl();
        try {
            StuCodes stuCodes=new StuCodes();
            if (dao.stuHasField(t)){
                stuCodes=dao.stuOneDayCodes(students.getSno(),t);
            }
            request.getSession().setAttribute("students",students);
            request.getSession().setAttribute("stuCodes",stuCodes);
            RequestDispatcher rd= getServletContext().getRequestDispatcher("/stuOneDayReport.jsp");
            rd.forward(request,response);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
