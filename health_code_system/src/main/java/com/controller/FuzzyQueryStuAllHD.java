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
import java.util.ArrayList;

@WebServlet(name = "FuzzyQueryStuAllHD", value = "/FuzzyQueryStuAllHD")
public class FuzzyQueryStuAllHD extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Teachers teachers=(Teachers)request.getSession().getAttribute("teachers");
        String name=request.getParameter("name");
        UsersDao dao=new UsersDaoImpl();
        ArrayList<Students> students= null;
        try {
            teachers=dao.findByNo(teachers.getTno());
            if (teachers.getTrole().equals("院级管理员")){
                students=dao.findStudentsAndCollegesByFuzzyName(name,teachers.getTcollege());
            }else {
                students = dao.findStudentsByFuzzyName(name);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("teachers",teachers);
        request.getSession().setAttribute("students",students);
        RequestDispatcher rd= getServletContext().getRequestDispatcher("/fuzzyQueryStuAllHD.jsp");
        rd.forward(request,response);
    }
}
