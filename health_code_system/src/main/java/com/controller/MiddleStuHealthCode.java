package com.controller;

import com.code.QuickMarkUtil;
import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.users.Students;

import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

@WebServlet(name = "MiddleStuHealthCode", value = "/MiddleStuHealthCode")
public class MiddleStuHealthCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session=request.getSession();
        Students students=(Students) session.getAttribute("students");
        UsersDao dao=new UsersDaoImpl();
        try {
            students=dao.findStudentsByNo(students.getSno());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String curDate = s.format(c.getTime());
        String color = students.getScodecolor();
        String contect = students.getSname()+"|"+students.getSno()+"|"+curDate;
        if(color.equals("金")) {
            try {
                BufferedImage QuickMarkImage = QuickMarkUtil.buildQuickMarkImage(contect,0xFF0b80ee);
                ImageIO.write(QuickMarkImage, "jpg",response.getOutputStream() );
                response.getOutputStream().flush();
                response.getOutputStream().close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(color.equals("红")) {
            try {
                BufferedImage QuickMarkImage = QuickMarkUtil.buildQuickMarkImage(contect,0xFFFF0000);
                ImageIO.write(QuickMarkImage, "jpg",response.getOutputStream() );
                response.getOutputStream().flush();
                response.getOutputStream().close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(color.equals("黄")) {
            try {
                BufferedImage QuickMarkImage = QuickMarkUtil.buildQuickMarkImage(contect,0xFFFFFF00);
                ImageIO.write(QuickMarkImage, "jpg",response.getOutputStream() );
                response.getOutputStream().flush();
                response.getOutputStream().close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                BufferedImage QuickMarkImage = QuickMarkUtil.buildQuickMarkImage(contect,0xFF008000);
                ImageIO.write(QuickMarkImage, "jpg",response.getOutputStream() );
                response.getOutputStream().flush();
                response.getOutputStream().close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
