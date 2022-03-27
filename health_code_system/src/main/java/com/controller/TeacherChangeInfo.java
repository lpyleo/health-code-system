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

@WebServlet(name = "TeacherChangeInfo", value = "/TeacherChangeInfo")
public class TeacherChangeInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String tno=request.getParameter("tno");
        String name=request.getParameter("name");
        String idnumber=request.getParameter("idnumber");
        String no=request.getParameter("no");
        String college=request.getParameter("college");
        String role=request.getParameter("role");
        String password=request.getParameter("password");
        UsersDao dao=new UsersDaoImpl();
        Teachers teachers=new Teachers();
        Teachers tea=new Teachers();
        tea.setTname(name);
        tea.setTidnumber(idnumber);
        tea.setTno(no);
        tea.setTcollege(college);
        tea.setTrole(role);
        tea.setTpassword(password);
        String message="";
        try {
            teachers=dao.findByNo(tno);
            if(dao.modifyTeacher(tea)){
                message="教师信息修改成功！";
            } else{
                message="教师信息修改失败！";
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("teachers",teachers);
        request.getSession().setAttribute("message",message);
        RequestDispatcher rd= getServletContext().getRequestDispatcher("/resultTeacher.jsp");
        rd.forward(request,response);
    }
}
