package com.dao;

import com.model.users.Teachers;

public interface TeachersDao extends Dao {
    //检查系统管理员登录方法
    public boolean checksalogin(Teachers teachers) throws DaoException;
    //检查校级管理员登录方法
    public boolean checkschalogin(Teachers teachers) throws DaoException;
    //检查院级管理员登录方法
    public boolean checkhalogin(Teachers teachers) throws DaoException;
    //检查普通教师登录方法
    public boolean checktealogin(Teachers teachers) throws DaoException;
    //增加教师
    //删除教师
    //修改教师信息
    //模糊查询
}