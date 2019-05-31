package com.san.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.san.base.BaseAction;
import com.san.model.Resource;
import com.san.model.Subject;
import com.san.model.UseRecord;
import com.san.model.User;
import com.san.service.HistoryService;
import com.san.service.Impl.HistoryServiceImpl;

public class ResourceHistoryAction extends BaseAction<Resource>{
	/**
	 * 列出资料使用记录
	 * @return
	 * @throws IOException 
	 */
   public String listResourceHistory() throws IOException{
	   HttpServletResponse response = ServletActionContext.getResponse();
	   response.setContentType("text/html;charset=utf-8");
		 HttpServletRequest request=ServletActionContext.getRequest();//获取request
	   User user=(User) request.getSession().getAttribute("user");
       if(user!=null){
           PrintWriter pw=response.getWriter();
           HistoryService historyService=new HistoryServiceImpl();
           List<UseRecord> useRecordList=historyService.listResourceUseRecord(user.getUserId());
           Gson gson=new Gson();
           String jsonObject=gson.toJson(useRecordList);
           pw.print(jsonObject);
           return null ;
       }
	return null;
   }
}
