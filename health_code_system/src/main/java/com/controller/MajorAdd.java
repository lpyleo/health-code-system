package com.controller;

import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.users.Colleges;
import com.model.users.Majors;
import com.model.users.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MajorAdd", value = "/MajorAdd")
public class MajorAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsersDao dao = new UsersDaoImpl();
        String tno=request.getParameter("tno");
        Majors majors = new Majors();
        Teachers teachers=new Teachers();
        String message = "";
        try{
            teachers=dao.findByNo(tno);
            // 将传递来的字符串重新使用utf-8编码，以免产生乱码
            majors.setName(new String(request.getParameter("name")
                    .getBytes("iso-8859-1"),"UTF-8"));
            majors.setNo(new String(request.getParameter("no")
                    .getBytes("iso-8859-1"),"UTF-8"));
            majors.setDean(new String(request.getParameter("dean")
                    .getBytes("iso-8859-1"),"UTF-8"));
            majors.setCollege(new String(request.getParameter("college")
                    .getBytes("iso-8859-1"),"UTF-8"));
            boolean success = dao.addMajor(majors);
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
                getServletContext().getRequestDispatcher("/resultMajor.jsp");
        rd.forward (request,response);
    }
}
