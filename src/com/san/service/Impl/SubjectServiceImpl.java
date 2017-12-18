package com.san.service.Impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.san.dao.Impl.SubjectDaoImpl;
import com.san.model.BrushList;
import com.san.model.Subject;



public class SubjectServiceImpl {
	/**
	 * @param courseName 	课程名称
	 * @param subjectId	             编号
	 * @param subjectType	类型
	 */
	SubjectDaoImpl subjectDaoImpl=new SubjectDaoImpl();
	public List<Subject> display(String courseName,String subjectId,String subjectType) throws NumberFormatException, SQLException{
		int Id=0;
		String[] split = subjectId.split("-");
		Id=(Integer.parseInt(split[0])-1);
		return subjectDaoImpl.checkSubject(courseName, Id, subjectType);
	}
	//插入测试成绩sevice
	public int insertGradeSevice(String brushName,String courseName,int userId,float grade) throws SQLException{
		//得到刷题区id
		BrushList brushList = subjectDaoImpl.checkBrushId(brushName, courseName);
		int brushId=brushList.getBrushId();
		int insertGrade = subjectDaoImpl.insertGrade(brushId, courseName, userId, grade);
		return insertGrade;
	}
	//刷题成绩排名
	@Test
	public List<Map<String,Object>> pankGradeService(){
		try {
			List<Map<String,Object>> listMap=subjectDaoImpl.pankGradeDaoImpl();
			for (Map<String, Object> map : listMap) {
				map.put("grades",(int)Double.parseDouble(map.get("grade").toString()));
			}
			for (Map<String, Object> map : listMap) {
				System.out.println(map);
			}
			return subjectDaoImpl.pankGradeDaoImpl();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//后台:根据不同条件查询题目信息
	public List<Subject> checkSubjectService(String subjectId,String brushName,String courseName,String subjectType){
		try {
			return subjectDaoImpl.checkSubject(subjectId, brushName, courseName, subjectType);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//后台:根据题目id查询题目信息
	public Subject checkSubjectByIdService(String subjectId){
		try {
			return subjectDaoImpl.checkSubjectById(subjectId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//后台删除谋道题目
	public int delSubjectService(String subjectId){
		int intsubjectId=0;
		if(subjectId!=""){
			intsubjectId=Integer.parseInt(subjectId);
		}
		try {
			return subjectDaoImpl.delSubject(intsubjectId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	//后台添加题目
	public int addSubjectService(String brushName,String subjectType,String courseName,String title,String Aoption,
			String Boption,String Coption,String Doption,String answer,String analysis){
		try {
			if("".equals(analysis)){
				analysis="暂无解析";
			}
			return subjectDaoImpl.addSubjectDaoImpl(brushName, subjectType, courseName,title,Aoption, Boption, Coption, Doption, answer, analysis);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	//修改题目信息
	public int editSubjectService(String subjectId,String brushName,String subjectType,String courseName,String title,String Aoption,
			String Boption,String Coption,String Doption,String answer,String analysis){
		int intSubjectId=Integer.parseInt(subjectId);
		if("".equals(analysis)){
			analysis="暂无解析";
		}
		try {
			return subjectDaoImpl.editSubjectDaoImpl(intSubjectId, brushName, subjectType, courseName, title, Aoption, Boption, Coption, Doption, answer, analysis);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
