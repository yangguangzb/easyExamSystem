package com.san.dao;

import java.util.List;

import com.san.model.Course;

public interface CourseDao {
 public List<Course> listCourse();//列出所有课程
 public void insertCourse(Course course);//增加课程
 public void updateCourse(Course course);//更新课程
 public void deleteCourse(Course course);//删除课程
}
