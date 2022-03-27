package com.dao;

import com.model.users.*;

import java.util.ArrayList;

public interface UsersDao extends Dao {
    //检查系统管理员登录方法
    public Teachers checksalogin(Teachers teachers) throws DaoException;
    //检查校级管理员登录方法
    public Teachers checkschalogin(Teachers teachers) throws DaoException;
    //检查院级管理员登录方法
    public Teachers checkhalogin(Teachers teachers) throws DaoException;
    //检查普通教师登录方法
    public Teachers checktealogin(Teachers teachers) throws DaoException;
    //检查学生登录方法
    public Students checkstulogin(Students students) throws DaoException;
    //通过工号查询教师
    public Teachers findByNo(String tno) throws DaoException;
    //添加教师
    public boolean addTeacher (Teachers teachers) throws DaoException;
    //查询所有教师
    public ArrayList<Teachers> findAllTeachers ()throws DaoException;
    //修改教师信息
    public boolean modifyTeacher(Teachers teachers)throws DaoException;
    //根据姓名模糊查询
    public ArrayList<Teachers> findByFuzzyName(String tname)throws DaoException;
    //根据信息和学院模糊查询
    public ArrayList<Teachers> findByFuzzyNameAndCollege(String tname,String college)throws DaoException;
    //根据教师工号删除教师信息
    public boolean deleteTeacher(String tno)throws DaoException;
    //更新健康码
    public boolean updateTeacherCode(String color,Teachers teachers) throws DaoException;
    //更新黄码天数
    public Teachers updateTeaYellow(Teachers teachers) throws DaoException;
    //更新红码天数
    public Teachers updateTeaRed(Teachers teachers) throws DaoException;
    //判断是否存在某个字段
    public boolean teaHasField(String field) throws DaoException;
    //插入新字段
    public boolean addTeaNewField(String field) throws DaoException;
    //更新字段的值，color=0，未打卡，color=1，绿码，color=2，黄码，color=3，红码
    public boolean updateTeaField(TeaCodes teaCodes) throws DaoException;
    //查询所有人某天的打卡记录
    public ArrayList<TeaCodes> teaAllCodes(String date) throws DaoException;
    //查询某个人所有的打卡记录
    public ArrayList<TeaCodes> teaOneCodes(String no) throws DaoException;
    //查询某人某天打卡记录
    public TeaCodes teaOneDayCodes(String no,String time) throws DaoException;
    //查询某个学院所有的打卡记录
    public ArrayList<TeaCodes> teaCollegeCodes(String name,String date) throws DaoException;

    //查询所有学院
    public ArrayList<Colleges> findAllColleges ()throws DaoException;
    //通过学院号查询学院
    public Colleges findCollegeByNo(String no) throws DaoException;
    //修改学院信息
    public boolean modifyCollege(Colleges colleges)throws DaoException;
    //根据学院编号删除学院信息
    public boolean deleteCollege(String no)throws DaoException;
    //根据信息模糊查询学院
    public ArrayList<Colleges> findCollegesByFuzzyName(String name)throws DaoException;
    //根据信息和学院名模糊查询学院
    public ArrayList<Colleges> findCollegesAndCollegesByFuzzyName(String name,String college)throws DaoException;
    //添加学院
    public boolean addCollege (Colleges colleges) throws DaoException;

    //查询所有专业
    public ArrayList<Majors> findAllMajors ()throws DaoException;
    //通过专业号查询专业
    public Majors findMajorByNo(String no) throws DaoException;
    //修改专业信息
    public boolean modifyMajor(Majors majors)throws DaoException;
    //根据专业编号删除专业信息
    public boolean deleteMajor(String no)throws DaoException;
    //根据信息模糊查询专业
    public ArrayList<Majors> findMajorsByFuzzyName(String name)throws DaoException;
    //根据信息和学院模糊查询专业
    public ArrayList<Majors> findMajorsAndCollegesByFuzzyName(String name,String college)throws DaoException;
    //添加专业
    public boolean addMajor (Majors majors) throws DaoException;

    //查询所有班级
    public ArrayList<Classes> findAllClasses ()throws DaoException;
    //通过班级号查询班级
    public Classes findClassesByNo(String no) throws DaoException;
    //修改班级信息
    public boolean modifyClasses(Classes classes)throws DaoException;
    //根据班级编号删除班级信息
    public boolean deleteClasses(String no)throws DaoException;
    //根据信息模糊查询班级
    public ArrayList<Classes> findClassesByFuzzyName(String name)throws DaoException;
    //根据信息和学院模糊查询班级
    public ArrayList<Classes> findClassesAndCollegesByFuzzyName(String name,String college)throws DaoException;
    //添加班级
    public boolean addClasses (Classes classes) throws DaoException;

    //查询所有学生
    public ArrayList<Students> findAllStudents ()throws DaoException;
    //通过学号查询学生
    public Students findStudentsByNo(String no) throws DaoException;
    //修改学生信息
    public boolean modifyStudents(Students students)throws DaoException;
    //根据学号删除学生信息
    public boolean deleteStudents(String no)throws DaoException;
    //根据信息模糊查询学生
    public ArrayList<Students> findStudentsByFuzzyName(String name)throws DaoException;
    //根据信息和学院模糊查询学生
    public ArrayList<Students> findStudentsAndCollegesByFuzzyName(String name,String college)throws DaoException;
    //添加学生
    public boolean addStudents (Students students) throws DaoException;
    //更新健康码
    public boolean updateStudentCode(String color,Students students) throws DaoException;
    //更新黄码天数
    public Students updateStuYellow(Students students) throws DaoException;
    //更新红码天数
    public Students updateStuRed(Students students) throws DaoException;
    //判断是否存在某个字段
    public boolean stuHasField(String field) throws DaoException;
    //插入新字段
    public boolean addStuNewField(String field) throws DaoException;
    //更新字段的值，color=0，未打卡，color=1，绿码，color=2，黄码，color=3，红码，color=4，金码
    public boolean updateStuField(StuCodes stuCodes) throws DaoException;
    //查询所有人某天的打卡记录
    public ArrayList<StuCodes> stuAllCodes(String date) throws DaoException;
    //查询某个人所有的打卡记录
    public ArrayList<StuCodes> stuOneCodes(String no) throws DaoException;
    //查询某人某天打卡记录
    public StuCodes stuOneDayCodes(String no,String time) throws DaoException;
    //查询某个学院所有的打卡记录
    public ArrayList<StuCodes> stuCollegeCodes(String name,String date) throws DaoException;
    //模糊查询StuCodes
    public ArrayList<StuCodes> stuCodeFuzzyQuery(String name,String date) throws DaoException;
    //模糊查询TeaCodes
    public ArrayList<TeaCodes> teaCodeFuzzyQuery(String name,String date) throws DaoException;
    //模糊查询StuCodes
    public ArrayList<StuCodes> stuCollegeCodeFuzzyQuery(String co,String name,String date) throws DaoException;
    //模糊查询TeaCodes
    public ArrayList<TeaCodes> teaCollegeCodeFuzzyQuery(String co,String name,String date) throws DaoException;
}