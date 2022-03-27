package com.controller;

import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.users.Classes;
import com.model.users.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "FuzzyQueryTeacher", value = "/FuzzyQueryTeacher")
public class FuzzyQueryTeacher extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name=request.getParameter("name");
        String tno=request.getParameter("tno");
        UsersDao dao=new UsersDaoImpl();
        ArrayList<Teachers> tea= null;
        Teachers teachers=new Teachers();
        try {
            teachers=dao.findByNo(tno);
            if (teachers.getTrole().equals("院级管理员")){
                tea=dao.findByFuzzyNameAndCollege(name,teachers.getTcollege());
            }else {
                tea = dao.findByFuzzyName(name);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("teachers",teachers);
        request.getSession().setAttribute("tea",tea);
        RequestDispatcher rd= getServletContext().getRequestDispatcher("/showFuzzyQueryTeachers.jsp");
        rd.forward(request,response);
    }
}
