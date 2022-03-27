package com.dao;

import com.model.users.Teachers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeachersDaoImpl implements TeachersDao {
    //检查系统管理员登录信息是否正确
    public boolean checksalogin(Teachers teachers) throws DaoException{
        String sql = "SELECT * FROM teachers WHERE trole='系统管理员' AND tno=? AND tpassword=?";
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,teachers.getTno());
            pstmt.setString(2,teachers.getTpassword());
            ResultSet rs = pstmt.executeQuery();
            boolean bo;
            if(rs.next()){
                bo = true;
            } else {
                bo = false;
            }
            rs.close();
            pstmt.close();
            conn.close();
            return bo;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    //检查校级管理员登录信息是否正确
    public boolean checkschalogin(Teachers teachers) throws DaoException{
        String sql = "SELECT * FROM teachers WHERE trole='校级管理员' AND tno=? AND tpassword=?";
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,teachers.getTno());
            pstmt.setString(2,teachers.getTpassword());
            ResultSet rs = pstmt.executeQuery();
            boolean bo;
            if(rs.next()){
                bo = true;
            } else {
                bo = false;
            }
            rs.close();
            pstmt.close();
            conn.close();
            return bo;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    //检查院级管理员登录信息是否正确
    public boolean checkhalogin(Teachers teachers) throws DaoException{
        String sql = "SELECT * FROM teachers WHERE trole='院级管理员' AND tno=? AND tpassword=?";
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,teachers.getTno());
            pstmt.setString(2,teachers.getTpassword());
            ResultSet rs = pstmt.executeQuery();
            boolean bo;
            if(rs.next()){
                bo = true;
            } else {
                bo = false;
            }
            rs.close();
            pstmt.close();
            conn.close();
            return bo;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    //检查普通教师登录信息是否正确
    public boolean checktealogin(Teachers teachers) throws DaoException{
        String sql = "SELECT * FROM teachers WHERE tname=? AND tno=? AND RIGHT(tidnumber,8)=?";
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,teachers.getTname());
            pstmt.setString(2,teachers.getTno());
            pstmt.setString(3,teachers.getTidnumber());
            ResultSet rs = pstmt.executeQuery();
            boolean bo;
            if(rs.next()){
                bo = true;
            } else {
                bo = false;
            }
            rs.close();
            pstmt.close();
            conn.close();
            return bo;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
