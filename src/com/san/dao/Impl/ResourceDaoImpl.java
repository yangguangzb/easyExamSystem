package com.san.dao.Impl;

import java.sql.SQLException;
import java.util.List;

import com.san.model.Subject;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.san.dao.ResourceDao;
import com.san.model.Resource;
import com.san.utils.C3p0Util;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/* 资料数据库操作
* @ author zi
* */
public class ResourceDaoImpl implements ResourceDao {
/*
* 根据课程名列出资料
* @param course
* @throws SQLException
* return List<Resource>
* */
	@Override
	public List<Resource> listResource(String courseName) {
		// TODO Auto-generated method stub
		try {
			QueryRunner runner=new QueryRunner(C3p0Util.getDataSource());
			String sql="select * from resource where resourceId=?,uploadId=?,courseId=?,courseName=?,resource=?,downNumber=?,integration=?";
			return (List<Resource>) runner.query(sql, courseName,new BeanHandler(Resource.class));
			
			
		}
		catch (SQLException ex) {
			// TODO: handle exception
			ex.printStackTrace();
			return null;
		}
	}
	/*
    * 列出所有资料
    * @throws SQLException
    * return List<Resource>
    * */
	@Override
	public List<Resource> listResource() {
		// TODO Auto-generated method stub
		try {
			QueryRunner runner=new QueryRunner(C3p0Util.getDataSource());
			String sql="select * from resource";
			return (List<Resource>) runner.query(sql,new BeanListHandler<Resource>(Resource.class));
		}
		catch (SQLException ex) {
			// TODO: handle exception
			ex.printStackTrace();
			return null;
		}
	}
	/*
    * 根据资料编号列出资料
    * @param resourceId
    * @throws SQLException
    * return List<Resource>
    * */
	@Override
	public Resource getResource(String resourceId) {
		// TODO Auto-generated method stub
		return null;
	}
	/*
    * 删除资料
    * @param resource
    * @throws SQLException
    * return void
    * */
	@Override
	public void deleteResource(Resource resource) {
		// TODO Auto-generated method stub
		try {
			QueryRunner runner=new QueryRunner(C3p0Util.getDataSource());
			String sql="delete  from course where resourceId=?,uploadId=?,courseId=?,courseName=?,resource=?,downNumber=?,integration=? ";
			Object[] params= {resource.getResourceId(),resource.getUploadId(),resource.getCourseName(),resource.getResourceName(),resource.getResourceDescription(),resource.getResourcePath(),resource.getDownNumber(),resource.getIntegration()};
			runner.update(sql,params);
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/*
    * 增加资料
    * @param resource
    * @throws SQLException
    * return void
    * */
	@Override
	public void insertResource(Resource resource) {
		// TODO Auto-generated method stub
		try {
			QueryRunner runner=new QueryRunner(C3p0Util.getDataSource());
			String sql="insert into resource(resourceId,uploadId,courseName,resourceName,resourceDescription,resource,downNumber,integration) values(?,?,?,?,?,?,?,?)";
			Object[] params= {resource.getResourceId(),resource.getUploadId(),resource.getCourseName(),resource.getResourceName(),resource.getResourceDescription(),resource.getResourcePath(),resource.getDownNumber(),resource.getIntegration()};
			runner.update(sql,params);
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	/*
    * 更新资料
    * @param resourceId
    * @throws SQLException
    * return List<Resource>
    * */
	@Override
	public void updateResource(Resource resource) {
		// TODO Auto-generated method stub
		try {
			QueryRunner runner=new QueryRunner(C3p0Util.getDataSource());
			String sql="update resource set resourceId=?,uploadId=?,courseId=?,courseName=?,resource=?,downNumber=?,integration=?";
			Object[] params= {resource.getResourceId(),resource.getUploadId(),resource.getCourseName(),resource.getResourceName(),resource.getResourceDescription(),resource.getResourcePath(),resource.getDownNumber(),resource.getIntegration()};
			runner.update(sql,params);
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

	

}
