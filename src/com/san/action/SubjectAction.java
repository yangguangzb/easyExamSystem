package com.san.action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import com.san.base.BaseAction;
import com.san.model.Subject;
import com.san.model.User;
import com.san.service.SubjectService;
import com.san.service.Impl.SubjectServiceImpl;
/**
 * 刷题action
 * @author zhangbiao
 *
 */
public class SubjectAction extends BaseAction<Subject>{
	private static final long serialVersionUID = 1L;
	SubjectService subjectService=new SubjectServiceImpl();
	int k=0;					//设置题目编号
	List<Subject> subjectList;	//20道题目集合
	int grade=0;				//设置分数
	Subject nowSubject=null;	//设置当前题目;
	int j=k;					//设置上一题
	//显示成绩排名
	public String showGradeRank(){
		List<Map<String, Object>> gradeRank = subjectService.pankGradeService();
		getSession().setAttribute("gradeRank",gradeRank);
		System.out.println("测是");
		return "showGradeRank";
	}
	
	//显示题目
	public String display(){
		//把课程,题型,编号存到session中,方便界面取
		Subject subject=this.getModel();
		System.out.println(subject.getCourseName());
		System.out.println(subject.getSubjectId());
		getSession().setAttribute("courseName",subject.getCourseName());
		getSession().setAttribute("subjectId",subject.getSubjectId());
		getSession().setAttribute("subjectType",subject.getSubjectType());
		getSession().setAttribute("brushName", "普通区");
		//将上次成绩重置为0
		getSession().setAttribute("grade", 0);
		//显示20道题目
		try {
			k++;
			subjectList = subjectService.display(subject.getCourseName(), subject.getSubjectId()+"", subject.getSubjectType());
			getSession().setAttribute("subjectList", subjectList);
			nowSubject=subjectList.get(0);
			nowSubject.setSubjectId(k);//设置当前题目编号
			getSession().setAttribute("nowSubject", nowSubject);
			//转发无法响应(待解决)
			//request.getRequestDispatcher("/ordinary.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "display";
	}
	
	//显示下一题
	public String displayNext(){
		//显示下一题
		if(k<20){
			List<Subject> subjectList=(List<Subject>)getSession().getAttribute("subjectList");
			nowSubject=subjectList.get(k);
			//获得当前选项
			String choice="";
			if(getRequest().getParameter("choice")!=null){
				choice = getRequest().getParameter("choice");
			}
			//获取前一道题信息
			Subject lastSubject=subjectList.get(k-1);
			//前一道题答案
			String subjectAnswer=lastSubject.getSubjectAnswer();
			if(subjectAnswer.contains(choice)&&choice!=""){
				grade=grade+5;
			}
			//保存成绩
			getSession().setAttribute("grade",grade);
			nowSubject.setSubjectId(++k);//设置当前题目编号
			//把题目编号存入session,方便前台获取
			getSession().setAttribute("k", k);
			getSession().setAttribute("nowSubject", nowSubject);
		}
		return "displayNext";
	}
	
	//显示上一题
	public String displayLast(){
		//显示上一题
		k--;
		if(k>0){
			//题目已做完(第一道题)
			Subject nowSubject=null;
			List<Subject> subjectList=(List<Subject>)getSession().getAttribute("subjectList");
			nowSubject=subjectList.get(k);
			nowSubject.setSubjectId(k);
			getSession().setAttribute("nowSubject", nowSubject);
		}
		return "displayLast";
	}
	
	//查看解析
	public String displayParsing(){
		//查看解析
		Subject nowSubject=(Subject)getSession().getAttribute("nowSubject");
		String analysis=nowSubject.getAnalysis();
		String subjectAnswer=nowSubject.getSubjectAnswer();
		//解析
		getSession().setAttribute("analysis",analysis);
		return "displayParsing";
	}
	
	//统计分数
	public String gradeByOption() throws IOException{
		String grade2 = getSession().getAttribute("grade").toString();
		if("".equals(grade2)){
			grade=0;
		}else{
			grade=Integer.parseInt(getSession().getAttribute("grade").toString());
		}
		//销毁session,结束测试
		getSession().setAttribute("nowSubject",null);
		getSession().setAttribute("k",null);
		String choice = getRequest().getParameter("choice");
		//获取最后提交一道题的答案
		String answer=subjectList.get(k-1).getSubjectAnswer();
		if(answer.equals(choice)){
			grade+=5;
		}
		//插入测试成绩
		User user=(User)getSession().getAttribute("user");
		String brushName=getSession().getAttribute("brushName").toString();
		String courseName=getSession().getAttribute("courseName").toString();
		try {
			subjectService.insertGradeSevice(brushName, courseName, user.getUserId(), Float.parseFloat(grade+""));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//题目编号重置为0,重置选项信息
		k=0;
		getSession().setAttribute("courseName",null);
		getSession().setAttribute("subjectId",null);
		getSession().setAttribute("subjectType",null);
		getSession().setAttribute("grade",0);
		//向前台输出成绩
		getPrintWriter().write(grade+"");
		grade=0;
		return "gradeByOption";
	}
}
