package com.san.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.san.base.BaseAction;
import com.san.model.Subject;
import com.san.model.UseRecord;
import com.san.model.User;
import com.san.service.HistoryService;
import com.san.service.Impl.HistoryServiceImpl;
import com.san.service.Impl.IntegralServiceImpl;

public class IntegrationAction extends BaseAction<UseRecord> {
	IntegralServiceImpl integralServiceImpl=new IntegralServiceImpl();
	/**
	 * 列出积分使用记录
	 * @return
	 * @throws IOException 
	 */
	public String listUseRecord() throws IOException{
		 HttpServletResponse response = ServletActionContext.getResponse();
		   response.setContentType("text/html;charset=utf-8");
			 HttpServletRequest request=ServletActionContext.getRequest();//获取request
		 User user=(User) request.getSession().getAttribute("user");
	        if(user!=null){
	            PrintWriter pw=response.getWriter();
	            HistoryService historyService=new HistoryServiceImpl();
	            List<UseRecord> useRecordList=historyService.listUseRecord(user.getUserId());
	            Gson gson=new Gson();
	            String jsonObject=gson.toJson(useRecordList);
	            pw.print(jsonObject);
	            return null;	
	        }
			return null;
	}
	public String updateIntegration(){
		 HttpServletRequest request=ServletActionContext.getRequest();//获取request
		 String buyNumber=request.getParameter("buyNumber");
		 User user=(User) request.getSession().getAttribute("user");
		 if(user!=null){
			 integralServiceImpl.buyPointsService(buyNumber, user.getUserId());
			 return "success";
		 }
		return null;
	}
}
