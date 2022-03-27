package com.controller;

import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.users.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "ImportExcelMajors", value = "/ImportExcelMajors")
@MultipartConfig
public class ImportExcelMajors extends HttpServlet {
    // 获取文件名
    private String getFileName(Part part) {
        String fname = null;
        String header = part.getHeader("content-disposition");
        fname = header.substring(header.lastIndexOf("=") + 2, header.length() - 1);
        return fname;
    }

    // 判断是否为表格文件
    private boolean isXls(String fname) {
        // 获取后缀名
        String fileBehind = fname.substring(fname.lastIndexOf(".") + 1, fname.length());
        if (fileBehind.equals("xls")||fileBehind.equals("xlsx")) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String tno=request.getParameter("tno");
        String message="";
        UsersDao dao=new UsersDaoImpl();
        Teachers teachers=new Teachers();
        try {
            teachers=dao.findByNo(tno);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        String path=this.getServletContext().getRealPath("/");
        Part part=request.getPart("excelFile");
        //excel表存到excel文件夹下
        path=path+"excel";
        File file=new File(path);
        // 如果目录不存在则新建目录
        if (!file.exists()) {
            file.mkdirs();
        }
        //返回文件名
        String filename=getFileName(part);
        if(isXls(filename)){
            part.write(path+"/"+filename);
            request.getSession().setAttribute("filepath",path+"/"+filename);
            request.getSession().setAttribute("teachers",teachers);
            RequestDispatcher rd= request.getRequestDispatcher("/ImportExcelInfoMajors");
            rd.forward(request,response);
        } else {
            message="专业信息导入失败！";
            request.getSession().setAttribute("message",message);
            request.getSession().setAttribute("teachers",teachers);
            RequestDispatcher rd= request.getRequestDispatcher("/resultMajor.jsp");
            rd.forward(request,response);
        }
    }
}
