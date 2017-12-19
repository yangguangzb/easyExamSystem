package com.san.dao;

import com.san.model.Grade;

import java.util.List;

public interface GradeDao {
    public List<Grade> listGrade();//列出所有成绩
    public List<Grade> listGradeByUser(int userId);//列出某位用户的所有成绩
    public List<Grade> listGradeByCourseAndUser(int userId,String course);//列出某用户某门课程的成绩
}
