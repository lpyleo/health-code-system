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

@WebServlet(name = "StudentChangeInfo", value = "/StudentChangeInfo")
public class StudentChangeInfo extends HttpServlet {
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
        String major=request.getParameter("major");
        String classes=request.getParameter("class");
        UsersDao dao=new UsersDaoImpl();
        Teachers teachers=new Teachers();
        Students students=new Students();
        students.setSname(name);
        students.setSidnumber(idnumber);
        students.setSno(no);
        students.setScollege(college);
        students.setSmajor(major);
        students.setSclass(classes);
        String message="";
        try {
            teachers=dao.findByNo(tno);
            if(dao.modifyStudents(students)){
                message="学生信息修改成功！";
            } else{
                message="学生信息修改失败！";
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("teachers",teachers);
        request.getSession().setAttribute("message",message);
        RequestDispatcher rd= getServletContext().getRequestDispatcher("/resultStudent.jsp");
        rd.forward(request,response);
    }
}
