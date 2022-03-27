package com.controller;

import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.users.StuCodes;
import com.model.users.Students;
import com.model.users.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "StuMain", value = "/StuMain")
public class StuMain extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Students students=(Students) request.getSession().getAttribute("students");
        int daka=0;
        int nodaka=0;
        int gold=0;
        int green=0;
        int yellow=0;
        int red=0;
        UsersDao dao=new UsersDaoImpl();
        ArrayList<StuCodes> stuCodes=new ArrayList<StuCodes>();
        try {
            stuCodes=dao.stuOneCodes(students.getSno());
            for(int i=0;i<stuCodes.size();i++){
                if(("0").equals(stuCodes.get(i).getAction())){
                    nodaka++;
                }else if (("1").equals(stuCodes.get(i).getAction())){
                    daka++;
                    green++;
                }else if (("2").equals(stuCodes.get(i).getAction())){
                    daka++;
                    yellow++;
                }else if (("3").equals(stuCodes.get(i).getAction())){
                    daka++;
                    red++;
                }else if (("4").equals(stuCodes.get(i).getAction())){
                    daka++;
                    gold++;
                }
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("daka",daka);
        request.getSession().setAttribute("nodaka",nodaka);
        request.getSession().setAttribute("gold",gold);
        request.getSession().setAttribute("green",green);
        request.getSession().setAttribute("yellow",yellow);
        request.getSession().setAttribute("red",red);
        request.getSession().setAttribute("students",students);
        RequestDispatcher rd= getServletContext().getRequestDispatcher("/stuMain.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
