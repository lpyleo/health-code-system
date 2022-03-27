package com.controller;

import com.dao.DaoException;
import com.dao.UsersDaoImpl;
import com.model.users.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SaLoginServlet", value = "/SaLoginServlet")
public class SaLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String tno = request.getParameter("tno");
        String tpassword = request.getParameter("tpassword");
        Teachers teachers = new Teachers();
        teachers.setTno(tno);
        teachers.setTpassword(tpassword);
        try {
            teachers = new UsersDaoImpl().checksalogin(teachers);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        if(teachers!=null){
            request.getSession().setAttribute("teachers",teachers);
            RequestDispatcher rd= getServletContext().getRequestDispatcher("/SaMain");
            rd.forward(request,response);
        } else {
            response.sendRedirect("loginFailed.jsp");
        }
    }
}
