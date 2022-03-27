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

@WebServlet(name = "CollegeChangeInfo", value = "/CollegeChangeInfo")
public class CollegeChangeInfo extends HttpServlet {
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
        String dean=request.getParameter("dean");
        UsersDao dao=new UsersDaoImpl();
        Teachers teachers=new Teachers();
        Colleges colleges=new Colleges();
        colleges.setName(name);
        colleges.setNo(no);
        colleges.setDean(dean);
        String message="";
        try {
            teachers=dao.findByNo(tno);
            if(dao.modifyCollege(colleges)){
                message="学院信息修改成功！";
            } else{
                message="学院信息修改失败！";
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("teachers",teachers);
        request.getSession().setAttribute("message",message);
        RequestDispatcher rd= getServletContext().getRequestDispatcher("/resultCollege.jsp");
        rd.forward(request,response);
    }
}
