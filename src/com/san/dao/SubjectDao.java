package com.san.dao;

import java.sql.SQLException;
import java.util.List;
import com.san.model.Subject;
public interface SubjectDao {
	public List<Subject> checkSubject(String courseName,int startPage,String subjectType) throws SQLException;
}
