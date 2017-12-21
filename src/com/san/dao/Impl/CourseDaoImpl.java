package com.san.dao.Impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.san.dao.CourseDao;
import com.san.model.Course;
import com.san.model.Resource;
import com.san.utils.C3p0Util;
/*
* @Author: zijieya
* @Description:
* */
public class CourseDaoImpl implements CourseDao {
   /*
   * 列出所有课程
   * @throws SQLException
   * @return List<Course>
   * */
	public List<Course> listCourse() {
		// TODO Auto-generated method stub
		try {
			QueryRunner runner=new QueryRunner(C3p0Util.getDataSource());
			String sql="select * from Course";
			return (List<Course>) runner.query(sql,new BeanHandler(Course.class));
		}
		catch (SQLException ex) {
			// TODO: handle exception
			ex.printStackTrace();
			return null;
		}
	}
    /*
    * 增加课程
    * @param course
    * @throws SQLException
    * @return voif
    * */
	public void insertCourse(Course course) {
		// TODO Auto-generated method stub
		try {
			QueryRunner runner=new QueryRunner(C3p0Util.getDataSource());
			String sql="insert into Course(courseName,courseDescription) values(?,?)";
			Object[] params= {course.getCourseName(),course.getCourseIntroduction()};
			runner.update(sql,params);
			
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
 /*
 * 更新课程
 * @param course
 * @throws SQLException
 * @return void
 * */
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		try {
			QueryRunner runner=new QueryRunner(C3p0Util.getDataSource());
			String sql="update course set courseName=?,courseIntroduction=?";
			Object[] params= {course.getCourseName(),course.getCourseIntroduction()};
			runner.update(sql,params);
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
 /*
 * 删除课程
 * @param course
 * @throws SQLException
 * @return void
 * */
	public void deleteCourse(Course course) {
		// TODO Auto-generated method stub
		try {
			QueryRunner runner=new QueryRunner(C3p0Util.getDataSource());
			String sql="delete  from course where courseName=? ";
			
			Object[] params= {course.getCourseName(),course.getCourseIntroduction()};
			runner.update(sql,course.getCourseName());
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
}
