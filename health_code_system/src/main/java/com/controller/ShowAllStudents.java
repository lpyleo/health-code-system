package com.controller;

import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.users.Majors;
import com.model.users.Students;
import com.model.users.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ShowAllStudents", value = "/ShowAllStudents")
public class ShowAllStudents extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Teachers teachers=(Teachers)request.getSession().getAttribute("teachers");
        UsersDao dao=new UsersDaoImpl();
        ArrayList<Students> students= null;
        try {
            if(teachers.getTrole().equals("院级管理员")){
                students=new ArrayList<Students>(dao.findStudentsByFuzzyName(teachers.getTcollege()));
            }else {
                students = new ArrayList<Students>(dao.findAllStudents());
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("teachers",teachers);
        request.getSession().setAttribute("students",students);
        RequestDispatcher rd= request.getRequestDispatcher("/studentManagement.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
