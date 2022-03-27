package com.controller;

import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.users.Colleges;
import com.model.users.Majors;
import com.model.users.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ShowAllMajors", value = "/ShowAllMajors")
public class ShowAllMajors extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Teachers teachers=(Teachers)request.getSession().getAttribute("teachers");
        UsersDao dao=new UsersDaoImpl();
        ArrayList<Majors> majors= null;
        try {
            if(teachers.getTrole().equals("院级管理员")){
                majors=new ArrayList<Majors>(dao.findMajorsByFuzzyName(teachers.getTcollege()));
            }else {
                majors = new ArrayList<Majors>(dao.findAllMajors());
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("teachers",teachers);
        request.getSession().setAttribute("majors",majors);
        RequestDispatcher rd= request.getRequestDispatcher("/majorManagement.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
