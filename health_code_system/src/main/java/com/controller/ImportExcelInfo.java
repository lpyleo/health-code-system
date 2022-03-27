package com.controller;

import com.model.users.Colleges;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "ImportExcelInfo", value = "/ImportExcelInfo")
public class ImportExcelInfo extends HttpServlet {
    public void init(String filepath){
        Sheet sheet;
        Workbook workbook;
        Cell []cells=new Cell[20];
        Colleges colleges=new Colleges();
        int totalrow=0;
        int successfulrow=0;
        int i=1;
        // 设置要读取的工作簿路径
        workbook=Workbook.getWorkbook(new File(filepath));
        // 获得第一个工作表对象(编号从0开始)
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
