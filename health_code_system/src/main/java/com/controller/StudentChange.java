package com.controller;

import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.users.Students;
import com.model.users.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "StudentChange", value = "/StudentChange")
public class StudentChange extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String no=request.getParameter("studentno");
        String tno=request.getParameter("teacherno");
        UsersDao dao=new UsersDaoImpl();
        try {
            Students students=dao.findStudentsByNo(no);
            Teachers teachers=dao.findByNo(tno);
            request.getSession().setAttribute("students",students);
            request.getSession().setAttribute("teachers",teachers);
            RequestDispatcher rd= getServletContext().getRequestDispatcher("/changeStudent.jsp");
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
