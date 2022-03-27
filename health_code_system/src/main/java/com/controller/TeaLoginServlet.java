package com.controller;

import com.dao.DaoException;
import com.dao.UsersDaoImpl;
import com.model.users.Students;
import com.model.users.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TeaLoginServlet", value = "/TeaLoginServlet")
public class TeaLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String role = request.getParameter("role");
        String name = request.getParameter("name");
        String no = request.getParameter("no");
        String idnumber = request.getParameter("password");
        if(role.equals("teacher")){
            Teachers teachers = new Teachers();
            teachers.setTname(name);
            teachers.setTno(no);
            teachers.setTidnumber(idnumber);
            try {
                teachers = new UsersDaoImpl().checktealogin(teachers);
            } catch (DaoException e) {
                e.printStackTrace();
            }
            if(teachers!=null){
                try {
                    request.getSession().setAttribute("teachers",new UsersDaoImpl().findByNo(no));
                } catch (DaoException e) {
                    e.printStackTrace();
                }
                RequestDispatcher rd= getServletContext().getRequestDispatcher("/TeaMain");
                rd.forward(request,response);
            } else {
                response.sendRedirect("loginFailed.jsp");
            }
        } else {
            Students students = new Students();
            students.setSname(name);
            students.setSno(no);
            students.setSidnumber(idnumber);
            try {
                students = new UsersDaoImpl().checkstulogin(students);
            } catch (DaoException e) {
                e.printStackTrace();
            }
            if(students!=null){
                try {
                    request.getSession().setAttribute("students",new UsersDaoImpl().findStudentsByNo(no));
                } catch (DaoException e) {
                    e.printStackTrace();
                }
                RequestDispatcher rd= getServletContext().getRequestDispatcher("/StuMain");
                rd.forward(request,response);
            } else {
                response.sendRedirect("loginFailed.jsp");
            }
        }

    }
}
