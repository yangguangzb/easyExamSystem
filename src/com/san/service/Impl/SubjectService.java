package com.san.service.Impl;

import java.sql.SQLException;
import java.util.List;

import com.san.dao.Impl.SubjectDaoImpl;
import com.san.model.Subject;


public class SubjectService {
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
}
