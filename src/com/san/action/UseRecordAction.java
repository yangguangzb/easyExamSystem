package com.san.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import com.san.base.BaseAction;
import com.san.model.UseRecord;
import com.san.model.User;
import com.san.service.Impl.IntegralServiceImpl;
import com.san.service.Impl.UserServiceImpl;
/**
 * 积分使用记录action
 * @author zhangbiao
 *
 */
public class UseRecordAction extends BaseAction<UseRecord>{
	private static final long serialVersionUID = 1L;
	IntegralServiceImpl integralServiceImpl=new IntegralServiceImpl();
	UserServiceImpl userServiceImpl=new UserServiceImpl(); 
	/**
	 * 购买积分
	 * @return
	 * @throws IOException 
	 */
	public String buyPoints() throws IOException{
		String buyNum=getRequest().getParameter("buyNum");
		User user=(User) getRequest().getSession().getAttribute("user");
		int i=integralServiceImpl.buyPointsService(buyNum, user.getUserId());
		//更新用户信息
		User user1=userServiceImpl.checkUserByIdService(user.getUserId());
		getRequest().getSession().setAttribute("user", user1);
		getPrintWriter().write(i+"");
		return null;
	}
	
	/**
	 * 后台查看积分
	 * @return
	 */
	public String backCheckIntegral(){
		String start=getRequest().getParameter("start");
		String end=getRequest().getParameter("end");
		String integralNumber=getRequest().getParameter("integralNumber");
		String username=getRequest().getParameter("username");
		List<Map<String, Object>> integralListMap= integralServiceImpl.checkIntegralService(start, end, integralNumber, username);
		getRequest().setAttribute("integralListMap", integralListMap);
		return "backCheckIntegral";
	}
	
	/**
	 * 管理员修改积分
	 * @return
	 * @throws IOException 
	 */
	public String modifyIntegral() throws IOException{
		String integralNumber = getRequest().getParameter("integralNumber");
		String[] integral = integralNumber.split("-");
		int jifen=0;
		if(integral[0]!=""){
			jifen=Integer.parseInt(integral[0]);
		}
		int userId=Integer.parseInt(integral[1]);
		String i=userServiceImpl.updateIntegralNumber(userId, jifen)+"";
		getPrintWriter().write(i);
		return null;
	}
	
	public HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}
	public PrintWriter getPrintWriter() throws IOException{
		 ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		 return ServletActionContext.getResponse().getWriter();
	}
}
