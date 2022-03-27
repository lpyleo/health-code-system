package com.controller;

import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.users.Colleges;
import com.model.users.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ShowAllColleges", value = "/ShowAllColleges")
public class ShowAllColleges extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Teachers teachers=(Teachers)request.getSession().getAttribute("teachers");
        UsersDao dao=new UsersDaoImpl();
        ArrayList<Colleges> colleges= null;
        try {
            if(teachers.getTrole().equals("院级管理员")){
                colleges=new ArrayList<Colleges>(dao.findCollegesByFuzzyName(teachers.getTcollege()));
            }else{
                colleges = new ArrayList<Colleges>(dao.findAllColleges());
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("teachers",teachers);
        request.getSession().setAttribute("colleges",colleges);
        RequestDispatcher rd= request.getRequestDispatcher("/collegeManagement.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
