package com.controller;

import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.users.Classes;
import com.model.users.Colleges;
import com.model.users.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ClassAdd", value = "/ClassAdd")
public class ClassAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsersDao dao = new UsersDaoImpl();
        String tno=request.getParameter("tno");
        Classes classes = new Classes();
        Teachers teachers=new Teachers();
        String message = "";
        try{
            teachers=dao.findByNo(tno);
            // 将传递来的字符串重新使用utf-8编码，以免产生乱码
            classes.setName(new String(request.getParameter("name")
                    .getBytes("iso-8859-1"),"UTF-8"));
            classes.setNo(new String(request.getParameter("no")
                    .getBytes("iso-8859-1"),"UTF-8"));
            classes.setHeadmaster(new String(request.getParameter("headmaster")
                    .getBytes("iso-8859-1"),"UTF-8"));
            classes.setCollege(new String(request.getParameter("college")
                    .getBytes("iso-8859-1"),"UTF-8"));
            classes.setMajor(new String(request.getParameter("major")
                    .getBytes("iso-8859-1"),"UTF-8"));
            boolean success = dao.addClasses(classes);
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
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/resultClass.jsp");
        rd.forward (request,response);
    }
}
