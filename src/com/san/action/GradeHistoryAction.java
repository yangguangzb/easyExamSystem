package com.san.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.san.base.BaseAction;
import com.san.model.Grade;
import com.san.model.Resource;
import com.san.model.User;
import com.san.service.HistoryService;
import com.san.service.Impl.HistoryServiceImpl;

public class GradeHistoryAction extends BaseAction<Resource> {
	private static final long serialVersionUID = 1L;
	/**
	 * 列出成绩记录
	 * @return
	 * @throws IOException
	 */
  public String listGradeHistory() throws IOException{
	  HttpServletResponse response = ServletActionContext.getResponse();
	   response.setContentType("text/html;charset=utf-8");
		 HttpServletRequest request=ServletActionContext.getRequest();//获取request

	  User user=(User)request.getSession().getAttribute("user");
      if(user!=null){
          PrintWriter pw=response.getWriter();
          HistoryService historyService=new HistoryServiceImpl();
          List<Grade> gradeList=historyService.listGradeByUser(user.getUserId());
          Gson gson=new Gson();
          String jsonObject=gson.toJson(gradeList);
          pw.print(jsonObject);
          return null;
      }
	return null;
	}
}
