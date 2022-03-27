package com.dao;

import com.model.users.*;

import java.sql.*;
import java.util.ArrayList;

public class UsersDaoImpl implements UsersDao {
    //检查系统管理员登录信息是否正确
    public Teachers checksalogin(Teachers teachers) throws DaoException{
        String sql = "SELECT * FROM teachers WHERE trole='系统管理员' AND tno=? AND tpassword=?";
        Teachers teachers1 = new Teachers();
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,teachers.getTno());
            pstmt.setString(2,teachers.getTpassword());
            ResultSet rst = pstmt.executeQuery();
            if(rst.next()){
                teachers1.setTname(rst.getString("tname"));
                teachers1.setTidnumber(rst.getString("tidnumber"));
                teachers1.setTno(rst.getString("tno"));
                teachers1.setTcollege(rst.getString("tcollege"));
                teachers1.setTrole(rst.getString("trole"));
                teachers1.setTpassword(rst.getString("tpassword"));
                teachers1.setTcodecolor(rst.getString("tcodecolor"));
                teachers1.setTlastredtime(rst.getInt("tlastredtime"));
                teachers1.setTlastyellowtime(rst.getInt("tlastyellowtime"));
            } else {
                return null;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return teachers1;
    }
    //检查校级管理员登录信息是否正确
    public Teachers checkschalogin(Teachers teachers) throws DaoException{
        String sql = "SELECT * FROM teachers WHERE trole='校级管理员' AND tno=? AND tpassword=?";
        Teachers teachers1 = new Teachers();
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,teachers.getTno());
            pstmt.setString(2,teachers.getTpassword());
            ResultSet rst = pstmt.executeQuery();
            if(rst.next()){
                teachers1.setTname(rst.getString("tname"));
                teachers1.setTidnumber(rst.getString("tidnumber"));
                teachers1.setTno(rst.getString("tno"));
                teachers1.setTcollege(rst.getString("tcollege"));
                teachers1.setTrole(rst.getString("trole"));
                teachers1.setTpassword(rst.getString("tpassword"));
                teachers1.setTcodecolor(rst.getString("tcodecolor"));
                teachers1.setTlastredtime(rst.getInt("tlastredtime"));
                teachers1.setTlastyellowtime(rst.getInt("tlastyellowtime"));
            } else {
                return null;
            }
        } catch (SQLException throwables) {
            return null;
        }
        return teachers1;
    }
    //检查院级管理员登录信息是否正确
    public Teachers checkhalogin(Teachers teachers) throws DaoException{
        String sql = "SELECT * FROM teachers WHERE trole='院级管理员' AND tno=? AND tpassword=?";
        Teachers teachers1 = new Teachers();
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,teachers.getTno());
            pstmt.setString(2,teachers.getTpassword());
            ResultSet rst = pstmt.executeQuery();
            if(rst.next()){
                teachers1.setTname(rst.getString("tname"));
                teachers1.setTidnumber(rst.getString("tidnumber"));
                teachers1.setTno(rst.getString("tno"));
                teachers1.setTcollege(rst.getString("tcollege"));
                teachers1.setTrole(rst.getString("trole"));
                teachers1.setTpassword(rst.getString("tpassword"));
                teachers1.setTcodecolor(rst.getString("tcodecolor"));
                teachers1.setTlastredtime(rst.getInt("tlastredtime"));
                teachers1.setTlastyellowtime(rst.getInt("tlastyellowtime"));
            } else {
                return null;
            }
        } catch (SQLException throwables) {
            return null;
        }
        return teachers1;
    }
    //检查普通教师登录信息是否正确
    public Teachers checktealogin(Teachers teachers) throws DaoException{
        String sql = "SELECT * FROM teachers WHERE tname=? AND tno=? AND RIGHT(tidnumber,8)=?";
        Teachers teachers1 = new Teachers();
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,teachers.getTname());
            pstmt.setString(2,teachers.getTno());
            pstmt.setString(3,teachers.getTidnumber());
            ResultSet rst = pstmt.executeQuery();
            if(rst.next()){
                teachers1.setTname(rst.getString("tname"));
                teachers1.setTidnumber(rst.getString("tidnumber"));
                teachers1.setTno(rst.getString("tno"));
                teachers1.setTcollege(rst.getString("tcollege"));
                teachers1.setTrole(rst.getString("trole"));
                teachers1.setTpassword(rst.getString("tpassword"));
                teachers1.setTcodecolor(rst.getString("tcodecolor"));
                teachers1.setTlastredtime(rst.getInt("tlastredtime"));
                teachers1.setTlastyellowtime(rst.getInt("tlastyellowtime"));
            } else {
                return null;
            }
        } catch (SQLException throwables) {
            return null;
        }
        return teachers1;
    }
    //检查学生登录方法
    public Students checkstulogin(Students students) throws DaoException{
        String sql = "SELECT * FROM students WHERE sname=? AND sno=? AND RIGHT(sidnumber,8)=?";
        Students students1 = new Students();
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,students.getSname());
            pstmt.setString(2,students.getSno());
            pstmt.setString(3,students.getSidnumber());
            ResultSet rst = pstmt.executeQuery();
            if(rst.next()){
                students1.setSname(rst.getString("sname"));
                students1.setSidnumber(rst.getString("sidnumber"));
                students1.setSno(rst.getString("sno"));
                students1.setScollege(rst.getString("scollege"));
                students1.setSmajor(rst.getString("smajor"));
                students1.setSclass(rst.getString("sclass"));
                students1.setScodecolor(rst.getString("scodecolor"));
                students1.setSlastredtime(rst.getInt("slastredtime"));
                students1.setSlastyellowtime(rst.getInt("slastyellowtime"));
            } else {
                return null;
            }
        } catch (SQLException throwables) {
            return null;
        }
        return students1;
    }
    //通过工号查询教师
    public Teachers findByNo(String tno) throws DaoException{
        String sql = "SELECT *" + " FROM teachers WHERE tno=?";
        Teachers teachers=new Teachers();
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,tno);
            try(ResultSet rst = pstmt.executeQuery()){
                if(rst.next()){
                    teachers.setTname(rst.getString("tname"));
                    teachers.setTidnumber(rst.getString("tidnumber"));
                    teachers.setTno(rst.getString("tno"));
                    teachers.setTcollege(rst.getString("tcollege"));
                    teachers.setTrole(rst.getString("trole"));
                    teachers.setTpassword(rst.getString("tpassword"));
                    teachers.setTcodecolor(rst.getString("tcodecolor"));
                    teachers.setTlastredtime(rst.getInt("tlastredtime"));
                    teachers.setTlastyellowtime(rst.getInt("tlastyellowtime"));
                }
            }
        }catch(SQLException se){
            return null;
        }
        return teachers;
    }
    //添加教师
    public boolean addTeacher (Teachers teachers) throws DaoException{
        String sql = "INSERT INTO teachers VALUES(?,?,?,?,?,?,?,?,?)";
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1,teachers.getTname());
            pstmt.setString(2,teachers.getTidnumber());
            pstmt.setString(3,teachers.getTno());
            pstmt.setString(4,teachers.getTcollege());
            pstmt.setString(5,teachers.getTrole());
            if(teachers.getTpassword().equals("")){
                pstmt.setString(6,null);
            }else{
                pstmt.setString(6,teachers.getTpassword());
            }
            pstmt.setString(7,null);
            pstmt.setString(8,null);
            pstmt.setString(9,null);
            pstmt.executeUpdate();
            return true;
        }catch(SQLException se){
            System.out.println(se);
            return false;
        }
    }
    // 查询所有教师
    public ArrayList<Teachers> findAllTeachers ()throws DaoException{
        ArrayList<Teachers> teaList = new ArrayList<Teachers>();
        String sql = "SELECT * FROM teachers";
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rst = pstmt.executeQuery()){
            while(rst.next()){
                Teachers teachers = new Teachers();
                teachers.setTname(rst.getString("tname"));
                teachers.setTidnumber(rst.getString("tidnumber"));
                teachers.setTno(rst.getString("tno"));
                teachers.setTcollege(rst.getString("tcollege"));
                teachers.setTrole(rst.getString("trole"));
                teachers.setTpassword(rst.getString("tpassword"));
                teachers.setTcodecolor(rst.getString("tcodecolor"));
                teachers.setTlastredtime(rst.getInt("tlastredtime"));
                teachers.setTlastyellowtime(rst.getInt("tlastyellowtime"));
                teaList.add(teachers);
            }
            return teaList;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //修改教师信息
    public boolean modifyTeacher(Teachers teachers)throws DaoException{
        String sql="UPDATE teachers SET tname=?,tidnumber=?,tno=?,tcollege=?,trole=?,tpassword=?,tcodecolor=?,tlastredtime=?,tlastyellowtime=? WHERE tno=?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setString(1,teachers.getTname());
            pstmt.setString(2,teachers.getTidnumber());
            pstmt.setString(3,teachers.getTno());
            pstmt.setString(4,teachers.getTcollege());
            pstmt.setString(5,teachers.getTrole());
            pstmt.setString(6,teachers.getTpassword());
            pstmt.setString(7,teachers.getTcodecolor());
            pstmt.setInt(8,teachers.getTlastredtime());
            pstmt.setInt(9,teachers.getTlastyellowtime());
            pstmt.setString(10,teachers.getTno());
            pstmt.executeUpdate();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }
    //根据姓名、工号、学院进行模糊查询
    public ArrayList<Teachers> findByFuzzyName(String tname)throws DaoException{
        ArrayList<Teachers> teaList=new ArrayList<Teachers>();
        String sql="SELECT * FROM teachers WHERE tname like ? OR tno like ? OR tcollege like ? OR tcodecolor like ?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,"%"+tname+"%");
            pstmt.setString(2,"%"+tname+"%");
            pstmt.setString(3,"%"+tname+"%");
            pstmt.setString(4,"%"+tname+"%");
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                Teachers teachers = new Teachers();
                teachers.setTname(rst.getString("tname"));
                teachers.setTidnumber(rst.getString("tidnumber"));
                teachers.setTno(rst.getString("tno"));
                teachers.setTcollege(rst.getString("tcollege"));
                teachers.setTrole(rst.getString("trole"));
                teachers.setTpassword(rst.getString("tpassword"));
                teachers.setTcodecolor(rst.getString("tcodecolor"));
                teachers.setTlastredtime(rst.getInt("tlastredtime"));
                teachers.setTlastyellowtime(rst.getInt("tlastyellowtime"));
                teaList.add(teachers);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return teaList;
    }
    //根据信息和学院模糊查询
    public ArrayList<Teachers> findByFuzzyNameAndCollege(String tname,String college)throws DaoException{
        ArrayList<Teachers> teaList=new ArrayList<Teachers>();
        String sql="SELECT * FROM teachers WHERE (tname like ? OR tno like ? OR tcollege like ? OR tcodecolor like ?) AND tcollege=?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,"%"+tname+"%");
            pstmt.setString(2,"%"+tname+"%");
            pstmt.setString(3,"%"+tname+"%");
            pstmt.setString(4,"%"+tname+"%");
            pstmt.setString(5,college);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                Teachers teachers = new Teachers();
                teachers.setTname(rst.getString("tname"));
                teachers.setTidnumber(rst.getString("tidnumber"));
                teachers.setTno(rst.getString("tno"));
                teachers.setTcollege(rst.getString("tcollege"));
                teachers.setTrole(rst.getString("trole"));
                teachers.setTpassword(rst.getString("tpassword"));
                teachers.setTcodecolor(rst.getString("tcodecolor"));
                teachers.setTlastredtime(rst.getInt("tlastredtime"));
                teachers.setTlastyellowtime(rst.getInt("tlastyellowtime"));
                teaList.add(teachers);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return teaList;
    }
    //根据教师工号删除教师信息
    public boolean deleteTeacher(String tno)throws DaoException{
        String sql="DELETE FROM teachers WHERE tno=?";
        try {
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,tno);
            if(pstmt.executeUpdate()>0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return false;
    }
    //更新健康码
    public boolean updateTeacherCode(String color,Teachers teachers) throws DaoException{
        String sql="UPDATE teachers SET tcodecolor=? WHERE tno=?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setString(1,color);
            pstmt.setString(2,teachers.getTno());
            pstmt.executeUpdate();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }
    //更新黄码天数
    public Teachers updateTeaYellow(Teachers teachers) throws DaoException{
        String sql="UPDATE teachers SET tlastyellowtime=? WHERE tno=?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)){
            if(teachers.getTlastyellowtime()<6){
                pstmt.setInt(1,teachers.getTlastyellowtime()+1);
            }else {
                pstmt.setInt(1,0);
            }
            pstmt.setString(2,teachers.getTno());
            pstmt.executeUpdate();
            return teachers;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }
    //更新红码天数
    public Teachers updateTeaRed(Teachers teachers) throws DaoException{
        String sql="UPDATE teachers SET tlastredtime=? WHERE tno=?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)){
            if(teachers.getTlastredtime()<6){
                pstmt.setInt(1,teachers.getTlastredtime()+1);
            }else {
                pstmt.setInt(1,0);
            }
            pstmt.setString(2,teachers.getTno());
            pstmt.executeUpdate();
            return teachers;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }
    //判断是否存在某个字段
    public boolean teaHasField(String field) throws DaoException{
        String sql="SELECT * FROM teacherscodes";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql);
                ResultSet rst = pstmt.executeQuery()){
            ResultSetMetaData rsmd=rst.getMetaData();
            for(int i=0;i<rsmd.getColumnCount();i++){
                if(rsmd.getColumnName(i+1).equals(field))
                    return true;
            }
            return false;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }
    //插入新字段
    public boolean addTeaNewField(String field) throws DaoException{
        String sql="ALTER TABLE teacherscodes ADD COLUMN `"+field+"` varchar(255) NULL DEFAULT 0";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.executeUpdate();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }
    //更新字段的值，color=0，未打卡，color=1，绿码，color=2，黄码，color=3，红码
    public boolean updateTeaField(TeaCodes teaCodes) throws DaoException{
        String sql="UPDATE teacherscodes SET `"+teaCodes.getField()+"` =? WHERE tno=?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setString(1,teaCodes.getAction());
            pstmt.setString(2,teaCodes.getNo());
            pstmt.executeUpdate();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }
    //查询所有人某天的打卡记录
    public ArrayList<TeaCodes> teaAllCodes(String date) throws DaoException{
        ArrayList<TeaCodes> teaList=new ArrayList<TeaCodes>();
        String sql="SELECT tname,tno,tcollege,`"+date+"` FROM teacherscodes";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                TeaCodes teaCodes = new TeaCodes();
                teaCodes.setName(rst.getString("tname"));
                teaCodes.setNo(rst.getString("tno"));
                teaCodes.setCollege(rst.getString("tcollege"));
                teaCodes.setField(date);
                teaCodes.setAction(rst.getString(date));
                teaList.add(teaCodes);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return teaList;
    }
    //查询某个人所有的打卡记录
    public ArrayList<TeaCodes> teaOneCodes(String no) throws DaoException{
        ArrayList<TeaCodes> teaList=new ArrayList<TeaCodes>();
        String sql="SELECT * FROM teacherscodes where tno=?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,no);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                ResultSetMetaData rsmd=rst.getMetaData();
                for(int i=4;i<=rsmd.getColumnCount();i++){
                    TeaCodes teaCodes = new TeaCodes();
                    teaCodes.setName(rst.getString("tname"));
                    teaCodes.setNo(rst.getString("tno"));
                    teaCodes.setCollege(rst.getString("tcollege"));
                    teaCodes.setField(rsmd.getColumnName(i));
                    teaCodes.setAction(rst.getString(rsmd.getColumnName(i)));
                    teaList.add(teaCodes);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return teaList;
    }
    //查询某人某天打卡记录
    public TeaCodes teaOneDayCodes(String no,String time) throws DaoException{
        String sql="SELECT tname,tno,tcollege,`"+time+"` FROM teacherscodes where tno=?";
        TeaCodes teaCodes=new TeaCodes();
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,no);
            ResultSet rst=pstmt.executeQuery();
            if (rst.next()){
                teaCodes.setName(rst.getString("tname"));
                teaCodes.setNo(rst.getString("tno"));
                teaCodes.setCollege(rst.getString("tcollege"));
                teaCodes.setField(time);
                teaCodes.setAction(rst.getString(time));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return teaCodes;
    }
    //查询某个学院所有的打卡记录
    public ArrayList<TeaCodes> teaCollegeCodes(String name,String date) throws DaoException{
        ArrayList<TeaCodes> teaList=new ArrayList<TeaCodes>();
        String sql="SELECT tname,tno,tcollege,`"+date+"` FROM teacherscodes where tcollege=?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,name);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                ResultSetMetaData rsmd=rst.getMetaData();
                for(int i=4;i<=rsmd.getColumnCount();i++){
                    TeaCodes teaCodes = new TeaCodes();
                    teaCodes.setName(rst.getString("tname"));
                    teaCodes.setNo(rst.getString("tno"));
                    teaCodes.setCollege(rst.getString("tcollege"));
                    teaCodes.setField(rsmd.getColumnName(i));
                    teaCodes.setAction(rst.getString(rsmd.getColumnName(i)));
                    teaList.add(teaCodes);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return teaList;
    }

    // 查询所有学院
    public ArrayList<Colleges> findAllColleges ()throws DaoException{
        ArrayList<Colleges> colList = new ArrayList<Colleges>();
        String sql = "SELECT * FROM colleges";
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rst = pstmt.executeQuery()){
            while(rst.next()){
                Colleges colleges = new Colleges();
                colleges.setName(rst.getString("name"));
                colleges.setNo(rst.getString("no"));
                colleges.setDean(rst.getString("dean"));
                colList.add(colleges);
            }
            return colList;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //通过学院号查询学院
    public Colleges findCollegeByNo(String no) throws DaoException{
        String sql = "SELECT *" + " FROM colleges WHERE no=?";
        Colleges colleges=new Colleges();
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,no);
            try(ResultSet rst = pstmt.executeQuery()){
                if(rst.next()){
                    colleges.setName(rst.getString("name"));
                    colleges.setNo(rst.getString("no"));
                    colleges.setDean(rst.getString("dean"));
                }
            }
        }catch(SQLException se){
            return null;
        }
        return colleges;
    }
    //修改学院信息
    public boolean modifyCollege(Colleges colleges)throws DaoException{
        String sql="UPDATE colleges SET name=?,no=?,dean=? WHERE no=?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setString(1,colleges.getName());
            pstmt.setString(2,colleges.getNo());
            pstmt.setString(3,colleges.getDean());
            pstmt.setString(4,colleges.getNo());
            pstmt.executeUpdate();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }
    //根据学院编号删除学院信息
    public boolean deleteCollege(String no)throws DaoException{
        String sql="DELETE FROM colleges WHERE no=?";
        try {
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,no);
            if(pstmt.executeUpdate()>0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return false;
    }
    //根据信息模糊查询学院
    public ArrayList<Colleges> findCollegesByFuzzyName(String name)throws DaoException{
        ArrayList<Colleges> colList=new ArrayList<Colleges>();
        String sql="SELECT * FROM colleges WHERE name like ? OR no like ? OR dean like ?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,"%"+name+"%");
            pstmt.setString(2,"%"+name+"%");
            pstmt.setString(3,"%"+name+"%");
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                Colleges colleges = new Colleges();
                colleges.setName(rst.getString("name"));
                colleges.setNo(rst.getString("no"));
                colleges.setDean(rst.getString("dean"));
                colList.add(colleges);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return colList;
    }
    //根据信息和学院名模糊查询学院
    public ArrayList<Colleges> findCollegesAndCollegesByFuzzyName(String name,String college)throws DaoException{
        ArrayList<Colleges> colList=new ArrayList<Colleges>();
        String sql="SELECT * FROM colleges WHERE (name like ? OR no like ? OR dean like ?) AND name=? ";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,"%"+name+"%");
            pstmt.setString(2,"%"+name+"%");
            pstmt.setString(3,"%"+name+"%");
            pstmt.setString(4,college);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                Colleges colleges = new Colleges();
                colleges.setName(rst.getString("name"));
                colleges.setNo(rst.getString("no"));
                colleges.setDean(rst.getString("dean"));
                colList.add(colleges);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return colList;
    }
    //添加学院
    public boolean addCollege (Colleges colleges) throws DaoException{
        String sql = "INSERT INTO colleges VALUES(?,?,?)";
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1,colleges.getName());
            pstmt.setString(2,colleges.getNo());
            pstmt.setString(3,colleges.getDean());
            pstmt.executeUpdate();
            return true;
        }catch(SQLException se){
            System.out.println(se);
            return false;
        }
    }
    //查询所有专业
    public ArrayList<Majors> findAllMajors ()throws DaoException{
        ArrayList<Majors> majList = new ArrayList<Majors>();
        String sql = "SELECT * FROM majors";
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rst = pstmt.executeQuery()){
            while(rst.next()){
                Majors majors = new Majors();
                majors.setName(rst.getString("name"));
                majors.setNo(rst.getString("no"));
                majors.setDean(rst.getString("dean"));
                majors.setCollege(rst.getString("college"));
                majList.add(majors);
            }
            return majList;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //通过专业号查询专业
    public Majors findMajorByNo(String no) throws DaoException{
        String sql = "SELECT *" + " FROM majors WHERE no=?";
        Majors majors=new Majors();
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,no);
            try(ResultSet rst = pstmt.executeQuery()){
                if(rst.next()){
                    majors.setName(rst.getString("name"));
                    majors.setNo(rst.getString("no"));
                    majors.setDean(rst.getString("dean"));
                    majors.setCollege(rst.getString("college"));
                }
            }
        }catch(SQLException se){
            return null;
        }
        return majors;
    }
    //修改专业信息
    public boolean modifyMajor(Majors majors)throws DaoException{
        String sql="UPDATE majors SET name=?,no=?,dean=?,college=? WHERE no=?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setString(1,majors.getName());
            pstmt.setString(2,majors.getNo());
            pstmt.setString(3,majors.getDean());
            pstmt.setString(4,majors.getCollege());
            pstmt.setString(5,majors.getNo());
            pstmt.executeUpdate();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }
    //根据专业编号删除专业信息
    public boolean deleteMajor(String no)throws DaoException{
        String sql="DELETE FROM majors WHERE no=?";
        try {
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,no);
            if(pstmt.executeUpdate()>0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return false;
    }
    //根据信息模糊查询专业
    public ArrayList<Majors> findMajorsByFuzzyName(String name)throws DaoException{
        ArrayList<Majors> majList=new ArrayList<Majors>();
        String sql="SELECT * FROM majors WHERE name like ? OR no like ? OR dean like ? OR college like ?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,"%"+name+"%");
            pstmt.setString(2,"%"+name+"%");
            pstmt.setString(3,"%"+name+"%");
            pstmt.setString(4,"%"+name+"%");
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                Majors majors = new Majors();
                majors.setName(rst.getString("name"));
                majors.setNo(rst.getString("no"));
                majors.setDean(rst.getString("dean"));
                majors.setCollege(rst.getString("college"));
                majList.add(majors);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return majList;
    }
    //根据信息和学院模糊查询专业
    public ArrayList<Majors> findMajorsAndCollegesByFuzzyName(String name,String college)throws DaoException{
        ArrayList<Majors> majList=new ArrayList<Majors>();
        String sql="SELECT * FROM majors WHERE (name like ? OR no like ? OR dean like ? OR college like ?) AND college=?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,"%"+name+"%");
            pstmt.setString(2,"%"+name+"%");
            pstmt.setString(3,"%"+name+"%");
            pstmt.setString(4,"%"+name+"%");
            pstmt.setString(5,college);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                Majors majors = new Majors();
                majors.setName(rst.getString("name"));
                majors.setNo(rst.getString("no"));
                majors.setDean(rst.getString("dean"));
                majors.setCollege(rst.getString("college"));
                majList.add(majors);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return majList;
    }
    //添加专业
    public boolean addMajor (Majors majors) throws DaoException{
        String sql = "INSERT INTO majors VALUES(?,?,?,?)";
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1,majors.getName());
            pstmt.setString(2,majors.getNo());
            pstmt.setString(3,majors.getDean());
            pstmt.setString(4,majors.getCollege());
            pstmt.executeUpdate();
            return true;
        }catch(SQLException se){
            System.out.println(se);
            return false;
        }
    }

    //查询所有班级
    public ArrayList<Classes> findAllClasses ()throws DaoException{
        ArrayList<Classes> claList = new ArrayList<Classes>();
        String sql = "SELECT * FROM classes";
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rst = pstmt.executeQuery()){
            while(rst.next()){
                Classes classes = new Classes();
                classes.setName(rst.getString("name"));
                classes.setNo(rst.getString("no"));
                classes.setHeadmaster(rst.getString("headmaster"));
                classes.setCollege(rst.getString("college"));
                classes.setMajor(rst.getString("major"));
                claList.add(classes);
            }
            return claList;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //通过班级号查询班级
    public Classes findClassesByNo(String no) throws DaoException{
        String sql = "SELECT *" + " FROM classes WHERE no=?";
        Classes classes=new Classes();
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,no);
            try(ResultSet rst = pstmt.executeQuery()){
                if(rst.next()){
                    classes.setName(rst.getString("name"));
                    classes.setNo(rst.getString("no"));
                    classes.setHeadmaster(rst.getString("headmaster"));
                    classes.setCollege(rst.getString("college"));
                    classes.setMajor(rst.getString("major"));
                }
            }
        }catch(SQLException se){
            return null;
        }
        return classes;
    }
    //修改班级信息
    public boolean modifyClasses(Classes classes)throws DaoException{
        String sql="UPDATE classes SET name=?,no=?,headmaster=?,college=?,major=? WHERE no=?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setString(1,classes.getName());
            pstmt.setString(2,classes.getNo());
            pstmt.setString(3,classes.getHeadmaster());
            pstmt.setString(4,classes.getCollege());
            pstmt.setString(5,classes.getMajor());
            pstmt.setString(6,classes.getNo());
            pstmt.executeUpdate();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }
    //根据班级编号删除班级信息
    public boolean deleteClasses(String no)throws DaoException{
        String sql="DELETE FROM classes WHERE no=?";
        try {
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,no);
            if(pstmt.executeUpdate()>0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return false;
    }
    //根据信息模糊查询班级
    public ArrayList<Classes> findClassesByFuzzyName(String name)throws DaoException{
        ArrayList<Classes> claList=new ArrayList<Classes>();
        String sql="SELECT * FROM classes WHERE name like ? OR no like ? OR headmaster like ? OR college like ? OR major like ?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,"%"+name+"%");
            pstmt.setString(2,"%"+name+"%");
            pstmt.setString(3,"%"+name+"%");
            pstmt.setString(4,"%"+name+"%");
            pstmt.setString(5,"%"+name+"%");
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                Classes classes = new Classes();
                classes.setName(rst.getString("name"));
                classes.setNo(rst.getString("no"));
                classes.setHeadmaster(rst.getString("headmaster"));
                classes.setCollege(rst.getString("college"));
                classes.setMajor(rst.getString("major"));
                claList.add(classes);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return claList;
    }
    //根据信息和学院模糊查询班级
    public ArrayList<Classes> findClassesAndCollegesByFuzzyName(String name,String college)throws DaoException{
        ArrayList<Classes> claList=new ArrayList<Classes>();
        String sql="SELECT * FROM classes WHERE (name like ? OR no like ? OR headmaster like ? OR college like ? OR major like ?) AND college=?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,"%"+name+"%");
            pstmt.setString(2,"%"+name+"%");
            pstmt.setString(3,"%"+name+"%");
            pstmt.setString(4,"%"+name+"%");
            pstmt.setString(5,"%"+name+"%");
            pstmt.setString(6,college);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                Classes classes = new Classes();
                classes.setName(rst.getString("name"));
                classes.setNo(rst.getString("no"));
                classes.setHeadmaster(rst.getString("headmaster"));
                classes.setCollege(rst.getString("college"));
                classes.setMajor(rst.getString("major"));
                claList.add(classes);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return claList;
    }
    //添加班级
    public boolean addClasses (Classes classes) throws DaoException{
        String sql = "INSERT INTO classes VALUES(?,?,?,?,?)";
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1,classes.getName());
            pstmt.setString(2,classes.getNo());
            pstmt.setString(3,classes.getHeadmaster());
            pstmt.setString(4,classes.getCollege());
            pstmt.setString(5,classes.getMajor());
            pstmt.executeUpdate();
            return true;
        }catch(SQLException se){
            System.out.println(se);
            return false;
        }
    }

    //查询所有学生
    public ArrayList<Students> findAllStudents ()throws DaoException{
        ArrayList<Students> stuList = new ArrayList<Students>();
        String sql = "SELECT * FROM students";
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rst = pstmt.executeQuery()){
            while(rst.next()){
                Students students = new Students();
                students.setSname(rst.getString("sname"));
                students.setSidnumber(rst.getString("sidnumber"));
                students.setSno(rst.getString("sno"));
                students.setScollege(rst.getString("scollege"));
                students.setSmajor(rst.getString("smajor"));
                students.setSclass(rst.getString("sclass"));
                students.setScodecolor(rst.getString("scodecolor"));
                students.setSlastredtime(rst.getInt("slastredtime"));
                students.setSlastyellowtime(rst.getInt("slastyellowtime"));
                stuList.add(students);
            }
            return stuList;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //通过学号查询学生
    public Students findStudentsByNo(String sno) throws DaoException{
        String sql = "SELECT *" + " FROM students WHERE sno=?";
        Students students=new Students();
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,sno);
            try(ResultSet rst = pstmt.executeQuery()){
                if(rst.next()){
                    students.setSname(rst.getString("sname"));
                    students.setSidnumber(rst.getString("sidnumber"));
                    students.setSno(rst.getString("sno"));
                    students.setScollege(rst.getString("scollege"));
                    students.setSmajor(rst.getString("smajor"));
                    students.setSclass(rst.getString("sclass"));
                    students.setScodecolor(rst.getString("scodecolor"));
                    students.setSlastredtime(rst.getInt("slastredtime"));
                    students.setSlastyellowtime(rst.getInt("slastyellowtime"));
                }
            }
        }catch(SQLException se){
            return null;
        }
        return students;
    }
    //修改学生信息
    public boolean modifyStudents(Students students)throws DaoException{
        String sql="UPDATE students SET sname=?,sidnumber=?,sno=?,scollege=?,smajor=?,sclass=?,scodecolor=?,slastredtime=?,slastyellowtime=? WHERE sno=?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setString(1,students.getSname());
            pstmt.setString(2,students.getSidnumber());
            pstmt.setString(3,students.getSno());
            pstmt.setString(4,students.getScollege());
            pstmt.setString(5,students.getSmajor());
            pstmt.setString(6,students.getSclass());
            pstmt.setString(7,students.getScodecolor());
            pstmt.setInt(8,students.getSlastredtime());
            pstmt.setInt(9,students.getSlastyellowtime());
            pstmt.setString(10,students.getSno());
            pstmt.executeUpdate();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }
    //根据学号删除学生信息
    public boolean deleteStudents(String sno)throws DaoException{
        String sql="DELETE FROM students WHERE sno=?";
        try {
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,sno);
            if(pstmt.executeUpdate()>0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return false;
    }
    //根据信息模糊查询学生
    public ArrayList<Students> findStudentsByFuzzyName(String name)throws DaoException{
        ArrayList<Students> stuList=new ArrayList<Students>();
        String sql="SELECT * FROM students WHERE sname like ? OR sno like ? OR scollege like ? OR smajor like ? OR sclass like ? OR scodecolor like ?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,"%"+name+"%");
            pstmt.setString(2,"%"+name+"%");
            pstmt.setString(3,"%"+name+"%");
            pstmt.setString(4,"%"+name+"%");
            pstmt.setString(5,"%"+name+"%");
            pstmt.setString(6,"%"+name+"%");
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                Students students = new Students();
                students.setSname(rst.getString("sname"));
                students.setSidnumber(rst.getString("sidnumber"));
                students.setSno(rst.getString("sno"));
                students.setScollege(rst.getString("scollege"));
                students.setSmajor(rst.getString("smajor"));
                students.setSclass(rst.getString("sclass"));
                students.setScodecolor(rst.getString("scodecolor"));
                students.setSlastredtime(rst.getInt("slastredtime"));
                students.setSlastyellowtime(rst.getInt("slastyellowtime"));
                stuList.add(students);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return stuList;
    }
    //根据信息和学院模糊查询学生
    public ArrayList<Students> findStudentsAndCollegesByFuzzyName(String name,String college)throws DaoException{
        ArrayList<Students> stuList=new ArrayList<Students>();
        String sql="SELECT * FROM students WHERE (sname like ? OR sno like ? OR scollege like ? OR smajor like ? OR sclass like ? OR scodecolor like ?) AND scollege=?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,"%"+name+"%");
            pstmt.setString(2,"%"+name+"%");
            pstmt.setString(3,"%"+name+"%");
            pstmt.setString(4,"%"+name+"%");
            pstmt.setString(5,"%"+name+"%");
            pstmt.setString(6,"%"+name+"%");
            pstmt.setString(7,college);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                Students students = new Students();
                students.setSname(rst.getString("sname"));
                students.setSidnumber(rst.getString("sidnumber"));
                students.setSno(rst.getString("sno"));
                students.setScollege(rst.getString("scollege"));
                students.setSmajor(rst.getString("smajor"));
                students.setSclass(rst.getString("sclass"));
                students.setScodecolor(rst.getString("scodecolor"));
                students.setSlastredtime(rst.getInt("slastredtime"));
                students.setSlastyellowtime(rst.getInt("slastyellowtime"));
                stuList.add(students);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return stuList;
    }
    //添加学生
    public boolean addStudents (Students students) throws DaoException{
        String sql = "INSERT INTO students VALUES(?,?,?,?,?,?,?,?,?)";
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1,students.getSname());
            pstmt.setString(2,students.getSidnumber());
            pstmt.setString(3,students.getSno());
            pstmt.setString(4,students.getScollege());
            pstmt.setString(5,students.getSmajor());
            pstmt.setString(6,students.getSclass());
            pstmt.setString(7,null);
            pstmt.setString(8,null);
            pstmt.setString(9,null);
            pstmt.executeUpdate();
            return true;
        }catch(SQLException se){
            System.out.println(se);
            return false;
        }
    }
    //更新健康码
    public boolean updateStudentCode(String color,Students students) throws DaoException{
        String sql="UPDATE students SET scodecolor=? WHERE sno=?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setString(1,color);
            pstmt.setString(2,students.getSno());
            pstmt.executeUpdate();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }
    //更新黄码天数
    public Students updateStuYellow(Students students) throws DaoException{
        String sql="UPDATE students SET slastyellowtime=? WHERE sno=?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)){
            if(students.getSlastyellowtime()<6){
                pstmt.setInt(1,students.getSlastyellowtime()+1);
            }else {
                pstmt.setInt(1,0);
            }
            pstmt.setString(2,students.getSno());
            pstmt.executeUpdate();
            return students;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }
    //更新红码天数
    public Students updateStuRed(Students students) throws DaoException{
        String sql="UPDATE students SET slastredtime=? WHERE sno=?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)){
            if(students.getSlastredtime()<6){
                pstmt.setInt(1,students.getSlastredtime()+1);
            }else {
                pstmt.setInt(1,0);
            }
            pstmt.setString(2,students.getSno());
            pstmt.executeUpdate();
            return students;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }
    //判断是否存在某个字段
    public boolean stuHasField(String field) throws DaoException{
        String sql="SELECT * FROM studentscodes";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql);
                ResultSet rst = pstmt.executeQuery()){
            ResultSetMetaData rsmd=rst.getMetaData();
            for(int i=0;i<rsmd.getColumnCount();i++){
                if(rsmd.getColumnName(i+1).equals(field))
                    return true;
            }
            return false;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }
    //插入新字段
    public boolean addStuNewField(String field) throws DaoException{
        String sql="ALTER TABLE studentscodes ADD COLUMN `"+field+"` varchar(255) NULL DEFAULT 0";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.executeUpdate();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }
    //更新字段的值，color=0，未打卡，color=1，绿码，color=2，黄码，color=3，红码
    public boolean updateStuField(StuCodes stuCodes) throws DaoException{
        String sql="UPDATE studentscodes SET `"+stuCodes.getField()+"` =? WHERE sno=?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setString(1,stuCodes.getAction());
            pstmt.setString(2,stuCodes.getNo());
            pstmt.executeUpdate();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }
    //查询所有人某天的打卡记录
    public ArrayList<StuCodes> stuAllCodes(String date) throws DaoException{
        ArrayList<StuCodes> stuList=new ArrayList<StuCodes>();
        String sql="SELECT sname,sno,scollege,smajor,sclass,`"+date+"` FROM studentscodes";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                StuCodes stuCodes = new StuCodes();
                stuCodes.setName(rst.getString("sname"));
                stuCodes.setNo(rst.getString("sno"));
                stuCodes.setCollege(rst.getString("scollege"));
                stuCodes.setMajor(rst.getString("smajor"));
                stuCodes.setClasses(rst.getString("sclass"));
                stuCodes.setField(date);
                stuCodes.setAction(rst.getString(date));
                stuList.add(stuCodes);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return stuList;
    }
    //查询某个人所有的打卡记录
    public ArrayList<StuCodes> stuOneCodes(String no) throws DaoException{
        ArrayList<StuCodes> stuList=new ArrayList<StuCodes>();
        String sql="SELECT * FROM studentscodes where sno=?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,no);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                ResultSetMetaData rsmd=rst.getMetaData();
                for(int i=6;i<=rsmd.getColumnCount();i++){
                    StuCodes stuCodes = new StuCodes();
                    stuCodes.setName(rst.getString("sname"));
                    stuCodes.setNo(rst.getString("sno"));
                    stuCodes.setCollege(rst.getString("scollege"));
                    stuCodes.setMajor(rst.getString("smajor"));
                    stuCodes.setClasses(rst.getString("sclass"));
                    stuCodes.setField(rsmd.getColumnName(i));
                    stuCodes.setAction(rst.getString(rsmd.getColumnName(i)));
                    stuList.add(stuCodes);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return stuList;
    }
    //查询某人某天打卡记录
    public StuCodes stuOneDayCodes(String no,String time) throws DaoException{
        String sql="SELECT sname,sno,scollege,smajor,sclass,`"+time+"` FROM studentscodes where sno=?";
        StuCodes stuCodes=new StuCodes();
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,no);
            ResultSet rst=pstmt.executeQuery();
            if (rst.next()){
                stuCodes.setName(rst.getString("sname"));
                stuCodes.setNo(rst.getString("sno"));
                stuCodes.setCollege(rst.getString("scollege"));
                stuCodes.setMajor(rst.getString("smajor"));
                stuCodes.setClasses(rst.getString("sclass"));
                stuCodes.setField(time);
                stuCodes.setAction(rst.getString(time));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return stuCodes;
    }
    //查询某个学院所有的打卡记录
    public ArrayList<StuCodes> stuCollegeCodes(String name,String date) throws DaoException{
        ArrayList<StuCodes> stuList=new ArrayList<StuCodes>();
        String sql="SELECT sname,sno,scollege,smajor,sclass,`"+date+"` FROM studentscodes where scollege=?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,name);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                ResultSetMetaData rsmd=rst.getMetaData();
                for(int i=6;i<=rsmd.getColumnCount();i++){
                    StuCodes stuCodes = new StuCodes();
                    stuCodes.setName(rst.getString("sname"));
                    stuCodes.setNo(rst.getString("sno"));
                    stuCodes.setCollege(rst.getString("scollege"));
                    stuCodes.setMajor(rst.getString("smajor"));
                    stuCodes.setClasses(rst.getString("sclass"));
                    stuCodes.setField(rsmd.getColumnName(i));
                    stuCodes.setAction(rst.getString(rsmd.getColumnName(i)));
                    stuList.add(stuCodes);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return stuList;
    }
    //模糊查询StuCodes
    public ArrayList<StuCodes> stuCodeFuzzyQuery(String name,String date) throws DaoException{
        ArrayList<StuCodes> stuList=new ArrayList<StuCodes>();
        String sql="SELECT * FROM studentscodes WHERE sname like ? OR sno like ? OR scollege like ? OR smajor like ? OR sclass like ? OR '"+date+"' like ?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,"%"+name+"%");
            pstmt.setString(2,"%"+name+"%");
            pstmt.setString(3,"%"+name+"%");
            pstmt.setString(4,"%"+name+"%");
            pstmt.setString(5,"%"+name+"%");
            pstmt.setString(6,"%"+name+"%");
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                StuCodes stuCodes = new StuCodes();
                stuCodes.setName(rst.getString("sname"));
                stuCodes.setNo(rst.getString("sno"));
                stuCodes.setCollege(rst.getString("scollege"));
                stuCodes.setMajor(rst.getString("smajor"));
                stuCodes.setClasses(rst.getString("sclass"));
                stuCodes.setField(date);
                stuCodes.setAction(rst.getString(date));
                stuList.add(stuCodes);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return stuList;
    }
    //模糊查询TeaCodes
    public ArrayList<TeaCodes> teaCodeFuzzyQuery(String name,String date) throws DaoException{
        ArrayList<TeaCodes> teaList=new ArrayList<TeaCodes>();
        String sql="SELECT * FROM teacherscodes WHERE tname like ? OR tno like ? OR tcollege like ? OR '"+date+"' like ?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,"%"+name+"%");
            pstmt.setString(2,"%"+name+"%");
            pstmt.setString(3,"%"+name+"%");
            pstmt.setString(4,"%"+name+"%");
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                TeaCodes teaCodes = new TeaCodes();
                teaCodes.setName(rst.getString("tname"));
                teaCodes.setNo(rst.getString("tno"));
                teaCodes.setCollege(rst.getString("tcollege"));
                teaCodes.setAction(rst.getString(date));
                teaCodes.setField(date);
                teaList.add(teaCodes);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return teaList;
    }
    //模糊查询StuCodes
    public ArrayList<StuCodes> stuCollegeCodeFuzzyQuery(String co,String name,String date) throws DaoException{
        ArrayList<StuCodes> stuList=new ArrayList<StuCodes>();
        String sql="SELECT * FROM studentscodes WHERE (sname like ? OR sno like ? OR scollege like ? OR smajor like ? OR sclass like ? OR '"+date+"' like ?) AND scollege=?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,"%"+name+"%");
            pstmt.setString(2,"%"+name+"%");
            pstmt.setString(3,"%"+name+"%");
            pstmt.setString(4,"%"+name+"%");
            pstmt.setString(5,"%"+name+"%");
            pstmt.setString(6,"%"+name+"%");
            pstmt.setString(7,co);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                StuCodes stuCodes = new StuCodes();
                stuCodes.setName(rst.getString("sname"));
                stuCodes.setNo(rst.getString("sno"));
                stuCodes.setCollege(rst.getString("scollege"));
                stuCodes.setMajor(rst.getString("smajor"));
                stuCodes.setClasses(rst.getString("sclass"));
                stuCodes.setField(date);
                stuCodes.setAction(rst.getString(date));
                stuList.add(stuCodes);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return stuList;
    }
    //模糊查询TeaCodes
    public ArrayList<TeaCodes> teaCollegeCodeFuzzyQuery(String co,String name,String date) throws DaoException{
        ArrayList<TeaCodes> teaList=new ArrayList<TeaCodes>();
        String sql="SELECT * FROM teacherscodes WHERE (tname like ? OR tno like ? OR tcollege like ? OR '"+date+"' like ?) AND tcollege=?";
        try(
                Connection conn=getConnection();
                PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setString(1,"%"+name+"%");
            pstmt.setString(2,"%"+name+"%");
            pstmt.setString(3,"%"+name+"%");
            pstmt.setString(4,"%"+name+"%");
            pstmt.setString(5,co);
            ResultSet rst=pstmt.executeQuery();
            while (rst.next()){
                TeaCodes teaCodes = new TeaCodes();
                teaCodes.setName(rst.getString("tname"));
                teaCodes.setNo(rst.getString("tno"));
                teaCodes.setCollege(rst.getString("tcollege"));
                teaCodes.setAction(rst.getString(date));
                teaCodes.setField(date);
                teaList.add(teaCodes);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return teaList;
    }
}