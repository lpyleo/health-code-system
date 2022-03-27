package com.controller;

import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.users.Colleges;
import com.model.users.Majors;
import com.model.users.Teachers;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "ImportExcelInfoMajors", value = "/ImportExcelInfoMajors")
public class ImportExcelInfoMajors extends HttpServlet {
    private int totalrow=0;
    private int successfulrow=0;
    public void init(String filepath){
        totalrow=0;
        successfulrow=0;
        // 工作表
        Sheet sheet;
        // 工作簿
        Workbook workbook;
        // 单元格
        Cell[]cells=new Cell[20];
        Majors majors=new Majors();
        int i=1;
        try {
            // 设置要读取的工作簿路径
            workbook=Workbook.getWorkbook(new File(filepath));
            // 获得第一个工作表对象(编号从0开始)
            sheet=workbook.getSheet(0);
            while (true){
                if(i>=sheet.getRows())
                    break;
                // 获取每一行的单元格
                for (int m=0;m<4;m++) {
                    // 读取第i行第m列数据
                    cells[m]=sheet.getCell(m, i);
                }
                majors.setName(cells[0].getContents());
                majors.setNo(cells[1].getContents());
                majors.setDean(cells[2].getContents());
                majors.setCollege(cells[3].getContents());
                UsersDao dao=new UsersDaoImpl();
                if(dao.addMajor(majors)){
                    successfulrow++;
                }
                totalrow++;
                i++;
            }
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filepath=request.getSession().getAttribute("filepath").toString();
        init(filepath);
        String message="Excel中共有"+totalrow+"条数据，导入成功"+successfulrow+"条数据！";
        Teachers teachers=(Teachers) request.getSession().getAttribute("teachers");
        request.getSession().setAttribute("teachers",teachers);
        request.getSession().setAttribute("message",message);
        RequestDispatcher rd= request.getRequestDispatcher("/resultMajor.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
