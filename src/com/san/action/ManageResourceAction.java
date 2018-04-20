package com.san.action;

import java.io.IOException;
import java.util.List;

import com.san.base.BaseAction;
import com.san.model.Resource;
import com.san.service.Impl.ResourceServiceImpl;

public class ManageResourceAction extends BaseAction<Resource>{
	private static final long serialVersionUID = 1L;
	ResourceServiceImpl resourceServiceImpl=new ResourceServiceImpl();
	
	/**
	 * 查询资源
	 * @return
	 */
	public String checkDatas(){
		String courseName=getRequest().getParameter("courseName");
		String userId=getRequest().getParameter("userId");
		List<Resource> resourceList=resourceServiceImpl.checkResourceService(courseName, userId);
		getRequest().setAttribute("resourceList", resourceList);
		//getRequest().getRequestDispatcher("../admin2/data-list.jsp").forward(request, response);
		return "checkDatas";
	}
	
	/**
	 * 删除资源
	 * @return
	 * @throws IOException 
	 */
	public String delDatas() throws IOException{
		String resourceId=getRequest().getParameter("resourceId");
		String i=""+resourceServiceImpl.delDatasService(resourceId);
		getPrintWriter().write(i);
		return "delDatas";
	}
	
	/**
	 * 修改资源
	 * @return
	 * @throws IOException 
	 */
	public String modifyDatas() throws IOException{
		String resourceId=this.getModel().getResourceId()+"";
		String courseName=this.getModel().getCourseName();
		String resourceName=this.getModel().getResourceName();
		String resourceDescription=this.getModel().getResourceDescription();
		String resourcePath=this.getModel().getResourcePath();
		String integration=this.getModel().getIntegration()+"";
		String i=""+resourceServiceImpl.modifyDatasService(resourceId, courseName, resourceName, resourceDescription, resourcePath, integration);
		getPrintWriter().write(i);
		return "modifyDatas";
	}
}
