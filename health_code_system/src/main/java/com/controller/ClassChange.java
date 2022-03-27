package com.controller;

import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.users.Classes;
import com.model.users.Colleges;
import com.model.users.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ClassChange", value = "/ClassChange")
public class ClassChange extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String no=request.getParameter("classno");
        String tno=request.getParameter("teacherno");
        UsersDao dao=new UsersDaoImpl();
        try {
            Classes classes=dao.findClassesByNo(no);
            Teachers teachers=dao.findByNo(tno);
            request.getSession().setAttribute("classes",classes);
            request.getSession().setAttribute("teachers",teachers);
            RequestDispatcher rd= getServletContext().getRequestDispatcher("/changeClass.jsp");
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
