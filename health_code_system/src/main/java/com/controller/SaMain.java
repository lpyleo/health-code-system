package com.controller;

import com.dao.DaoException;
import com.dao.UsersDao;
import com.dao.UsersDaoImpl;
import com.model.users.StuCodes;
import com.model.users.Students;
import com.model.users.TeaCodes;
import com.model.users.Teachers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

@WebServlet(name = "SaMain", value = "/SaMain")
public class SaMain extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Teachers teachers=(Teachers) request.getSession().getAttribute("teachers");
        String start1=request.getParameter("start1");
        if (start1!=null){
            String t=start1.substring(6)+"-"+start1.substring(0,2)+"-"+start1.substring(3,5);
            start1=t;
        }
        Calendar now=Calendar.getInstance();
        int year=now.get(Calendar.YEAR);
        int month=now.get(Calendar.MONTH)+1;
        int day=now.get(Calendar.DAY_OF_MONTH);
        String today="";
        if(month<10){
            if(day<10){
                today=String.valueOf(year)+"-"+"0"+String.valueOf(month)+"-"+"0"+String.valueOf(day);
            }else {
                today=String.valueOf(year)+"-"+"0"+String.valueOf(month)+"-"+String.valueOf(day);
            }
        }else {
            if(day<10){
                today=String.valueOf(year)+"-"+String.valueOf(month)+"-"+"0"+String.valueOf(day);
            }else {
                today=String.valueOf(year)+"-"+String.valueOf(month)+"-"+String.valueOf(day);
            }
        }
        int tdaka=0;
        int tnodaka=0;
        int tgold=0;
        int tgreen=0;
        int tyellow=0;
        int tred=0;
        int sdaka=0;
        int snodaka=0;
        int sgold=0;
        int sgreen=0;
        int syellow=0;
        int sred=0;
        UsersDao dao=new UsersDaoImpl();
        try {
            teachers=dao.findByNo(teachers.getTno());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        ArrayList<TeaCodes> teaCodes=new ArrayList<TeaCodes>();
        ArrayList<Teachers> teachers1=new ArrayList<Teachers>();
        ArrayList<StuCodes> stuCodes=new ArrayList<StuCodes>();
        ArrayList<Students> students=new ArrayList<Students>();
        if(teachers.getTrole().equals("院级管理员")){
            try {
                if(start1!=null){
                    if(dao.teaHasField(start1)){
                        teaCodes=dao.teaCollegeCodes(teachers.getTcollege(),start1);
                    }
                }else {
                    if (dao.teaHasField(today)){
                        teaCodes=dao.teaCollegeCodes(teachers.getTcollege(),today);
                    }
                }
                teachers1=dao.findByFuzzyName(teachers.getTcollege());
                if(start1!=null){
                    if(dao.stuHasField(start1)){
                        stuCodes=dao.stuCollegeCodes(teachers.getTcollege(),start1);
                    }
                }else {
                    if (dao.stuHasField(today)){
                        stuCodes=dao.stuCollegeCodes(teachers.getTcollege(),today);
                    }
                }
                students=dao.findStudentsByFuzzyName(teachers.getTcollege());
                for(int i=0;i<teaCodes.size();i++){
                    if(("0").equals(teaCodes.get(i).getAction())){
                        tnodaka++;
                    }else {
                        tdaka++;
                    }
                }
                for(int i=0;i<stuCodes.size();i++){
                    if(("0").equals(stuCodes.get(i).getAction())){
                        snodaka++;
                    }else {
                        sdaka++;
                    }
                }
                for(int i=0;i<teachers1.size();i++){
                    if(("金").equals(teachers1.get(i).getTcodecolor())){
                        tgold++;
                    }else if (("绿").equals(teachers1.get(i).getTcodecolor())){
                        tgreen++;
                    }else if (("黄").equals(teachers1.get(i).getTcodecolor())){
                        tyellow++;
                    }else if (("红").equals(teachers1.get(i).getTcodecolor())){
                        tred++;
                    }
                }
                for(int i=0;i<students.size();i++){
                    if(("金").equals(students.get(i).getScodecolor())){
                        sgold++;
                    }else if (("绿").equals(students.get(i).getScodecolor())){
                        sgreen++;
                    }else if (("黄").equals(students.get(i).getScodecolor())){
                        syellow++;
                    }else if (("红").equals(students.get(i).getScodecolor())){
                        sred++;
                    }
                }
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }else {
            try {
                if (start1!=null){
                    if (dao.teaHasField(start1)){
                        teaCodes=dao.teaAllCodes(start1);
                    }
                }else {
                    if (dao.teaHasField(today)){
                        teaCodes=dao.teaAllCodes(today);
                    }
                }
                teachers1=dao.findAllTeachers();
                if (start1!=null){
                    if (dao.stuHasField(start1)){
                        stuCodes=dao.stuAllCodes(start1);
                    }
                }else {
                    if (dao.stuHasField(today)){
                        stuCodes=dao.stuAllCodes(today);
                    }
                }
                students=dao.findAllStudents();
                for(int i=0;i<teaCodes.size();i++){
                    if(("0").equals(teaCodes.get(i).getAction())){
                        tnodaka++;
                    }else {
                        tdaka++;
                    }
                }
                for(int i=0;i<stuCodes.size();i++){
                    if(("0").equals(stuCodes.get(i).getAction())){
                        snodaka++;
                    }else {
                        sdaka++;
                    }
                }
                for(int i=0;i<teachers1.size();i++){
                    if(("金").equals(teachers1.get(i).getTcodecolor())){
                        tgold++;
                    }else if (("绿").equals(teachers1.get(i).getTcodecolor())){
                        tgreen++;
                    }else if (("黄").equals(teachers1.get(i).getTcodecolor())){
                        tyellow++;
                    }else if (("红").equals(teachers1.get(i).getTcodecolor())){
                        tred++;
                    }
                }
                for(int i=0;i<students.size();i++){
                    if(("金").equals(students.get(i).getScodecolor())){
                        sgold++;
                    }else if (("绿").equals(students.get(i).getScodecolor())){
                        sgreen++;
                    }else if (("黄").equals(students.get(i).getScodecolor())){
                        syellow++;
                    }else if (("红").equals(students.get(i).getScodecolor())){
                        sred++;
                    }
                }
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }
        request.getSession().setAttribute("tdaka",tdaka);
        request.getSession().setAttribute("tnodaka",tnodaka);
        request.getSession().setAttribute("tgold",tgold);
        request.getSession().setAttribute("tgreen",tgreen);
        request.getSession().setAttribute("tyellow",tyellow);
        request.getSession().setAttribute("tred",tred);
        request.getSession().setAttribute("sdaka",sdaka);
        request.getSession().setAttribute("snodaka",snodaka);
        request.getSession().setAttribute("sgold",sgold);
        request.getSession().setAttribute("sgreen",sgreen);
        request.getSession().setAttribute("syellow",syellow);
        request.getSession().setAttribute("sred",sred);
        request.getSession().setAttribute("teachers",teachers);
        RequestDispatcher rd= getServletContext().getRequestDispatcher("/saMain.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
