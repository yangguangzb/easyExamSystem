package com.san.dao.Impl;

import java.sql.SQLException;
import java.util.List;

import com.san.model.Subject;
import com.san.model.UseRecord;
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
	public List<Resource> listResource(String courseName) {
		// TODO Auto-generated method stub
		try {
			QueryRunner runner=new QueryRunner(C3p0Util.getDataSource());
			String sql="select * from resource2 where resourceId=?,uploadId=?,courseId=?,courseName=?,resource=?,downNumber=?,integration=?";
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
	public List<Resource> listResource() {
		// TODO Auto-generated method stub
		try {
			QueryRunner runner=new QueryRunner(C3p0Util.getDataSource());
			String sql="select * from resource2";
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
	public Resource getResource(int resourceId) {
		// TODO Auto-generated method stub
		try{
			QueryRunner runner=new QueryRunner(C3p0Util.getDataSource());
			String sql="select * from resource2 where resourceId=?";
			return (Resource) runner.query(sql,resourceId,new BeanHandler(Resource.class));
		}
		catch (SQLException ex){
			ex.printStackTrace();
		}
		return null;
	}
	/*
    * 删除资料
    * @param resource
    * @throws SQLException
    * return void
    * */
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
	public void insertResource(Resource resource) {
		// TODO Auto-generated method stub
		try {
			QueryRunner runner=new QueryRunner(C3p0Util.getDataSource());
			String sql="insert into resource2(resourceId,uploadId,courseName,resourceName,resourceDescription,resourcePath,downNumber,integration) values(?,?,?,?,?,?,?,?)";
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
	public void updateResource(Resource resource) {
		// TODO Auto-generated method stub
		try {
			QueryRunner runner=new QueryRunner(C3p0Util.getDataSource());
			String sql="update resource2 set  ResourceDescription=? where ResourceId=?";
			Object[] params= {resource.getResourceDescription(),resource.getResourceId()};
			runner.update(sql,params);
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void updateDownNumber(Resource resource) {
		try{
		    QueryRunner runner=new QueryRunner(C3p0Util.getDataSource());
		    String sql="update resource2 set downNumber=?+1 where resourceId=?";
		    Object[] params={resource.getDownNumber(),resource.getResourceId()};
		    runner.update(sql,params);
        }
        catch (SQLException ex){
		    ex.printStackTrace();
		}

	}
	/**
	 * 根据条件查询资源
	 * @param courseName
	 * @param uploadId
	 * @return
	 * @throws SQLException
	 */
	public List<Resource> checkResourceService(String courseName,int uploadId) throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		StringBuffer sql=new StringBuffer("select * from resource2");
		if(!"".equals(courseName)){
			sql.append(" and courseName='"+courseName+"'");
		}
		if(uploadId!=0){
			sql.append(" and uploadId="+uploadId+"");
		}
		String sql2=sql.toString().replaceFirst("and","where");
		return qr.query(sql2,new BeanListHandler<Resource>(Resource.class));
	}
	/**
	 * 后台删除资源
	 * @param resourceId
	 * @return
	 * @throws SQLException
	 */
	public int delDatasDaoImpl(int resourceId) throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		return qr.update("delete  from resource2 where resourceId=?",resourceId);
	}
	/**
	 * 后台修改资源
	 */
	public int modifyDatasDaoImpl(int resourceId,String courseName,String resourceName,String resourceDescription,
    		String resourcePath,int integration) throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		return qr.update("update resource2 set courseName=?,resourceName=?,resourceDescription=?,resourcePath=?,integration=? where resourceId=?"
				,courseName,resourceName,resourceDescription,resourcePath,integration,resourceId);
	}
}
