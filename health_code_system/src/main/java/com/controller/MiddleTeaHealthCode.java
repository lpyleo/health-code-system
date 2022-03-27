package com.controller;

import com.code.QuickMarkUtil;
import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.users.Teachers;

import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

@WebServlet(name = "MiddleTeaHealthCode", value = "/MiddleTeaHealthCode")
public class MiddleTeaHealthCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session=request.getSession();
        Teachers teachers=(Teachers) session.getAttribute("teachers");
        UsersDao dao=new UsersDaoImpl();
        try {
            teachers=dao.findByNo(teachers.getTno());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String curDate = s.format(c.getTime());
        String color = teachers.getTcodecolor();
        String contect = teachers.getTname()+"|"+teachers.getTno()+"|"+curDate;
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
