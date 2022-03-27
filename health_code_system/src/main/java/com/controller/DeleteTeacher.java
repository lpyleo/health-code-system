package com.controller;

import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.users.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteTeacher", value = "/DeleteTeacher")
public class DeleteTeacher extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String no=request.getParameter("teano");
        String tno=request.getParameter("teacherno");
        UsersDao dao=new UsersDaoImpl();
        String message="";
        Teachers teachers=new Teachers();
        try {
            teachers=dao.findByNo(tno);
            if(dao.deleteTeacher(no)){
                message="教师信息删除成功！";
            } else {
                message="教师信息删除失败！";
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("teachers",teachers);
        request.getSession().setAttribute("message",message);
        RequestDispatcher rd= getServletContext().getRequestDispatcher("/resultTeacher.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
