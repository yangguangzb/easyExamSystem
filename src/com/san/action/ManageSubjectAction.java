package com.san.action;

import java.io.IOException;
import java.util.List;

import com.san.base.BaseAction;
import com.san.model.Subject;
import com.san.service.Impl.SubjectServiceImpl;
/**
 * 后台题目管理action
 * @author zhangbiao
 *
 */
public class ManageSubjectAction extends BaseAction<Subject>{
	private static final long serialVersionUID = 1L;
	SubjectServiceImpl subjectServiceImpl=new SubjectServiceImpl();
	
	/**
	 * 根据id查询题目
	 * @return
	 */
	public String checkSubjectById(){
		String subjectId=getRequest().getParameter("subjectId");
		//保存标记
		getRequest().getSession().setAttribute("manageSubjectId", subjectId);
		Subject subjectById=subjectServiceImpl.checkSubjectByIdService(subjectId);
		getRequest().getSession().setAttribute("subjectById",subjectById);
		if(getRequest().getParameter("flag2")!=null&&"edit".equals(getRequest().getParameter("flag2"))){
			//response.sendRedirect("../admin2/subject-edit.jsp");
			return "edit";
		}
		//response.sendRedirect("../admin2/subject-detail.jsp");
		return "detail";
	}
	
	/**
	 * 题目管理,根据条件查询题目
	 * @return
	 */
	public String manageSubject(){
		String brushName=this.getModel().getBrushName();
		String subjectType=this.getModel().getSubjectType();
		String courseName=this.getModel().getCourseName();
		String subjectId=this.getModel().getSubjectId()+"";
		List<Subject> manageSubjectList=subjectServiceImpl.checkSubjectService(subjectId, brushName, courseName, subjectType);
		//保存记录数
		getRequest().getSession().setAttribute("subjectSize",manageSubjectList.size());
		//根据条件查询的题目,并保存到session中·
		//request.getSession().setAttribute("manageSubjectList", manageSubjectList);
		//response.sendRedirect("../admin2/subject-list.jsp");
		getRequest().setAttribute("manageSubjectList", manageSubjectList);
		getRequest().setAttribute("brushName", brushName);
		getRequest().setAttribute("subjectType", subjectType);
		getRequest().setAttribute("courseName", courseName);
		//getRequest().getRequestDispatcher("../admin2/subject-list.jsp").forward(request, response);
		return "manageSubject";
	}
	
	/**
	 * 删除一道题目
	 * @return
	 * @throws IOException 
	 */
	public String delSubject() throws IOException{
		String subjectId=getRequest().getParameter("subjectId");
		String i=subjectServiceImpl.delSubjectService(subjectId)+"";
		//向浏览器响应信息
		getPrintWriter().write(i);
		return "delSubject";
	}
	
	/**
	 * 添加题目
	 * @return
	 * @throws IOException 
	 */
	public String addSubject() throws IOException{
		String brushName=this.getModel().getBrushName();
		String subjectType=this.getModel().getSubjectType();
		String courseName=this.getModel().getCourseName();
		String title=this.getModel().getSubjectTitle();
		String Aoption=this.getModel().getOptionA();
		String Boption=this.getModel().getOptionB();
		String Coption=this.getModel().getOptionC();
		String Doption=this.getModel().getOptionD();
		String answer=this.getModel().getSubjectAnswer();
		String analysis=this.getModel().getAnalysis();
		String i=""+subjectServiceImpl.addSubjectService(brushName, subjectType, courseName, title,"A "+Aoption, "B "+Boption, "C "+Coption, "D "+Doption, answer, analysis);
		getPrintWriter().write(i);
		return "addSubject";
	}
	
	/**
	 * 修改题目信息
	 * @return
	 * @throws IOException 
	 */
	public String editSubject() throws IOException{
		String subjectId=this.getModel().getSubjectId()+"";
		String brushName=this.getModel().getBrushName();
		String subjectType=this.getModel().getSubjectType();
		String courseName=this.getModel().getCourseName();
		String title=this.getModel().getSubjectTitle();
		String Aoption=this.getModel().getOptionA();
		String Boption=this.getModel().getOptionB();
		String Coption=this.getModel().getOptionC();
		String Doption=this.getModel().getOptionD();
		String answer=this.getModel().getSubjectAnswer();
		String analysis=this.getModel().getAnalysis();
		String i=""+subjectServiceImpl.editSubjectService(subjectId, brushName, subjectType, courseName, title, Aoption, Boption, Coption, Doption, answer, analysis);
		getPrintWriter().write(i);
		return "editSubject";
	}
}
