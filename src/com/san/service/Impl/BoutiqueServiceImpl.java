package com.san.service.Impl;

import java.sql.SQLException;
import java.util.List;

import com.san.dao.Impl.BoutiqueDaoImpl;
import com.san.model.BrushList;
import com.san.model.Subject;

public class BoutiqueServiceImpl {
	BoutiqueDaoImpl boutiqueDaoImpl=new BoutiqueDaoImpl();
	//显示精品区所有信息
	public List<BrushList> displayAll(){
		try {
			return boutiqueDaoImpl.checkAllBoutique();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//查询具体精品区某门课程的信息
	public BrushList checkCourseService(String courseName){
		try {
			return boutiqueDaoImpl.checkCourse(courseName);
		} catch (SQLException e) {
			
		}
		return null;
	}
	//查看用户之前是否购买过该课程
	public boolean isBuyService(int userId,String useType){
		try {
			return boutiqueDaoImpl.isBuy(userId, useType);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//判断积分积分是否够,用户积分:integralNumber
	public boolean isPoints(int integralNumber,String courseName){
		try {
			BrushList brushList = boutiqueDaoImpl.checkCourse(courseName);
			if((brushList.getBrushIntegral()-3)<=integralNumber){
				//积分够,返回true
				return true;
			}else{
				//积分不够
				return false;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return true;
	}
	//积分够,扣除相应积分
	public int reducePointsService(int userId,int BrushIntegral,int integralNumber){
		try {
			return boutiqueDaoImpl.reducePoints(userId, BrushIntegral, integralNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	//查询精品区课程题目,
	public List<Subject> boutiqueSubjectService(String courseName){
		try {
			return boutiqueDaoImpl.checkBoutiqueSubject(courseName);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
}
