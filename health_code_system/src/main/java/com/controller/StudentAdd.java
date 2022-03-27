package com.controller;

import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.users.Students;
import com.model.users.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "StudentAdd", value = "/StudentAdd")
public class StudentAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsersDao dao = new UsersDaoImpl();
        String tno=request.getParameter("tno");
        Students students = new Students();
        Teachers teachers=new Teachers();
        String message = "";
        try{
            teachers=dao.findByNo(tno);
            // 将传递来的字符串重新使用utf-8编码，以免产生乱码
            students.setSname(new String(request.getParameter("name")
                    .getBytes("iso-8859-1"),"UTF-8"));
            students.setSidnumber(new String(request.getParameter("idnumber")
                    .getBytes("iso-8859-1"),"UTF-8"));
            students.setSno(new String(request.getParameter("no")
                    .getBytes("iso-8859-1"),"UTF-8"));
            students.setScollege(new String(request.getParameter("college")
                    .getBytes("iso-8859-1"),"UTF-8"));
            students.setSmajor(new String(request.getParameter("major")
                    .getBytes("iso-8859-1"),"UTF-8"));
            students.setSclass(new String(request.getParameter("class")
                    .getBytes("iso-8859-1"),"UTF-8"));
            boolean success = dao.addStudents(students);
            if(success){
                message = "成功插入一条记录！";
            }else{
                message = "插入记录错误！";
            }
        }catch(Exception e){
            System.out.println(e);
            message = "插入记录错误！" + e;
        }
        request.getSession().setAttribute("teachers",teachers);
        request.getSession().setAttribute("message", message);
        RequestDispatcher rd =
                getServletContext().getRequestDispatcher("/resultStudent.jsp");
        rd.forward (request,response);
    }
}
