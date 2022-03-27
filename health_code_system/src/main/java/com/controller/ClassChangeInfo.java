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

@WebServlet(name = "ClassChangeInfo", value = "/ClassChangeInfo")
public class ClassChangeInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String tno=request.getParameter("tno");
        String name=request.getParameter("name");
        String no=request.getParameter("no");
        String headmaster=request.getParameter("headmaster");
        String college=request.getParameter("college");
        String major=request.getParameter("major");
        UsersDao dao=new UsersDaoImpl();
        Teachers teachers=new Teachers();
        Classes classes=new Classes();
        classes.setName(name);
        classes.setNo(no);
        classes.setHeadmaster(headmaster);
        classes.setCollege(college);
        classes.setMajor(major);
        String message="";
        try {
            teachers=dao.findByNo(tno);
            if(dao.modifyClasses(classes)){
                message="班级信息修改成功！";
            } else{
                message="班级信息修改失败！";
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("teachers",teachers);
        request.getSession().setAttribute("message",message);
        RequestDispatcher rd= getServletContext().getRequestDispatcher("/resultClass.jsp");
        rd.forward(request,response);
    }
}
