package com.san.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import com.san.model.Subject;
public interface SubjectService {
	/**
	 * 显示成绩排名
	 * @return
	 */
	public List<Map<String,Object>> pankGradeService();
	
	/**
	 * 显示题目
	 * @param courseName
	 * @param subjectId
	 * @param subjectType
	 * @return
	 * @throws NumberFormatException
	 * @throws SQLException
	 */
	public List<Subject> display(String courseName,String subjectId,String subjectType) 
	throws NumberFormatException, SQLException;
	
	/**
	 * 插入测试成绩
	 * @param brushName
	 * @param courseName
	 * @param userId
	 * @param grade
	 * @return
	 * @throws SQLException
	 */
	public int insertGradeSevice(String brushName,String courseName,int userId,float grade) throws SQLException;
	
	/**
	 * 后台:根据不同条件查询题目信息
	 * @param subjectId
	 * @param brushName
	 * @param courseName
	 * @param subjectType
	 * @return
	 */
	public List<Subject> checkSubjectService(String subjectId,String brushName,String courseName,String subjectType);
	
	/**
	 * 后台:根据题目id查询题目信息
	 * @param subjectId
	 * @return
	 */
	public Subject checkSubjectByIdService(String subjectId);
	
	/**
	 * 后台删除谋道题目
	 * @param subjectId
	 * @return
	 */
	public int delSubjectService(String subjectId);
	
	/**
	 * 后台添加题目
	 * @param brushName
	 * @param subjectType
	 * @param courseName
	 * @param title
	 * @param Aoption
	 * @param Boption
	 * @param Coption
	 * @param Doption
	 * @param answer
	 * @param analysis
	 * @return
	 */
	public int addSubjectService(String brushName,String subjectType,String courseName,String title,String Aoption,
			String Boption,String Coption,String Doption,String answer,String analysis);
	
	/**
	 * 修改题目信息
	 * @param subjectId
	 * @param brushName
	 * @param subjectType
	 * @param courseName
	 * @param title
	 * @param Aoption
	 * @param Boption
	 * @param Coption
	 * @param Doption
	 * @param answer
	 * @param analysis
	 * @return
	 */
	public int editSubjectService(String subjectId,String brushName,String subjectType,String courseName,String title,String Aoption,
			String Boption,String Coption,String Doption,String answer,String analysis);
}
