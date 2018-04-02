package com.san.service;

import java.util.List;

import com.san.model.Grade;

public interface SubjectService {
	/**
	 * 显示成绩排名
	 * @return
	 */
	public List<Grade> showGradeRank();
	
	
}
