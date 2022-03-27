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

@WebServlet(name = "FuzzyQueryCollege", value = "/FuzzyQueryCollege")
public class FuzzyQueryCollege extends HttpServlet {
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
        ArrayList<Colleges> colleges= null;
        Teachers teachers=new Teachers();
        try {
            teachers=dao.findByNo(tno);
            if (teachers.getTrole().equals("院级管理员")){
                colleges=dao.findCollegesAndCollegesByFuzzyName(name,teachers.getTcollege());
            }else {
                colleges = dao.findCollegesByFuzzyName(name);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("teachers",teachers);
        request.getSession().setAttribute("colleges",colleges);
        RequestDispatcher rd= getServletContext().getRequestDispatcher("/showFuzzyQueryColleges.jsp");
        rd.forward(request,response);
    }
}
