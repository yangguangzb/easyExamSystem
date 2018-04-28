package com.san.action;

import java.io.IOException;
import java.util.List;

import com.san.base.BaseAction;
import com.san.model.BrushList;
import com.san.model.Subject;
import com.san.model.User;
import com.san.service.Impl.BoutiqueServiceImpl;
import com.san.service.Impl.IntegralServiceImpl;
import com.san.service.Impl.UserServiceImpl;
import com.san.utils.DBUtil;

public class BoutiqueAction extends BaseAction<Subject>{
	private static final long serialVersionUID = 1L;
	BoutiqueServiceImpl boutiqueService=new BoutiqueServiceImpl();
	IntegralServiceImpl integralServiceImpl=new IntegralServiceImpl();
	UserServiceImpl userServiceImpl=new UserServiceImpl();
	
	//具体题目
	int boutId=0;
	List<Subject> boutiqueSubjectList;   //所有题目
	Subject nowBoutiqueSubject;			//当前题目
	
	/**
	 * 精品区下一题
	 * @return
	 */
	public String nextBoutSubject(){
		String allSubject=getRequest().getSession().getAttribute("allSubject").toString();
		int allIntSubject=Integer.parseInt(allSubject);
		String s=(String) getRequest().getSession().getAttribute("boutId");
		if(s==""){
			System.out.println();
		}
		String boutIdstr=(String)getRequest().getSession().getAttribute("boutId");
		int boutId=Integer.parseInt(boutIdstr);
		boutiqueSubjectList=(List<Subject>)getRequest().getSession().getAttribute("boutiqueSubjectList");
		if(boutId<allIntSubject){	//还有题目可做
			nowBoutiqueSubject=boutiqueSubjectList.get(boutId);
			//现在的题目
			getRequest().getSession().setAttribute("nowBoutiqueSubject",nowBoutiqueSubject);
			boutId++;
			//现在题目序号
			getRequest().getSession().setAttribute("boutId", boutId);
		}
		return "nextBoutSubject";
	}
	
	/**
	 * 显示精品区信息
	 * @return
	 */
	public String display(){
		List<BrushList> brushlist=boutiqueService.displayAll();
		//把精品区信息存入session
		getRequest().getSession().setAttribute("brushlist", brushlist);
		//跳转到精品区界面
		//response.sendRedirect("boutique.jsp");
		return "display";
	}
	
	/**
	 * 具体精品课程
	 * @return
	 * @throws IOException 
	 */
	public String detail() throws IOException{
		//获取用户积分
		User user=(User) getRequest().getSession().getAttribute("user");
		String courseName=this.getModel().getCourseName();
		//获取课程信息,积分
		BrushList brushList = boutiqueService.checkCourseService(courseName);
		//判断用户以前是否购买过该课程
		boolean isBuy=boutiqueService.isBuyService(user.getUserId(),"精品区"+courseName);
		if(isBuy){
			//用户购买过该课程
			//查询题目,保存到session中
			List<Subject> boutiqueSubjectList = boutiqueService.boutiqueSubjectService(courseName);
			getRequest().getSession().setAttribute("boutiqueSubjectList", boutiqueSubjectList);
			//跳转到具体课程刷题
			return "detail";
		}else{
			//用户没有购买过该课程
			//判断用户积分是否足够购买该课程题目
			boolean isPoints=boutiqueService.isPoints(user.getIntegralNumber(), courseName);
			if(isPoints){
				//积分够,扣除相应积分
				boutiqueService.reducePointsService(user.getUserId(), brushList.getBrushIntegral(), user.getIntegralNumber());
				//更新用户session中的积分数目
				User userNow=userServiceImpl.checkUserByIdService(user.getUserId());
				getRequest().getSession().setAttribute("user", userNow);
				//记录用户消耗积分(积分使用记录表)
				integralServiceImpl.boutiqueReduceService(user.getUserId(), "精品区"+courseName, (-brushList.getBrushIntegral()+3));
				//查询题目,保存到session中
				List<Subject> boutiqueSubjectList = boutiqueService.boutiqueSubjectService(courseName);
				getRequest().getSession().setAttribute("boutiqueSubjectList", boutiqueSubjectList);
				//跳转到具体课程刷题
				return "detail";
			}else{
				//积分不够，跳转到积分购买界面
				getPrintWriter().write("积分不够,请购买积分!");
				getResponse().setHeader("refresh","2;url=buyPoints.jsp");
				return null;
			}
		}
	}
	
	
	/**
	 * 具体题目,开始刷题
	 * @return
	 * @throws IOException 
	 */
	public String detailSubject() throws IOException{
		boutiqueSubjectList=(List<Subject>)getRequest().getSession().getAttribute("boutiqueSubjectList");
		int subjectId=0;
		String boutiqueSubjectId=this.getModel().getBoutiqueSubjectId();
		if(!boutiqueSubjectId.equals("")&&DBUtil.isNumeric(boutiqueSubjectId)){
			subjectId=Integer.parseInt(boutiqueSubjectId);
			boutId=subjectId-1;
		}else if(boutiqueSubjectId.equals("")){
			boutId=0;
		}else{
			getPrintWriter().write("-2");
			boutId=0;
			return null;
		}
		if(boutiqueSubjectList.size()<subjectId){
			getPrintWriter().write("-1");
			boutId=0;
			return null;
		}
		nowBoutiqueSubject=boutiqueSubjectList.get(boutId);
		//总共有多少道题目,存入session
		getRequest().getSession().setAttribute("allSubject", boutiqueSubjectList.size());
		//现在的题目
		getRequest().getSession().setAttribute("nowBoutiqueSubject",nowBoutiqueSubject);
		boutId++;
		//现在题目序号
		getRequest().getSession().setAttribute("boutId", boutId);
		System.out.println("boutId"+boutId);
		return "detailSubject";
	}
	
	/**
	 * 提交答案处理
	 * @return
	 * @throws IOException 
	 */
	public String answerCl() throws IOException{
		//获取当前题目的答案
		String answer=nowBoutiqueSubject.getSubjectAnswer();
		//String submitAnswer=request.getParameter("submitAnswer").toString();
		String submitAnswer=this.getModel().getSubjectAnswer();
		if(submitAnswer.equals(answer)){
			//提交的答案正确
			getPrintWriter().write("正确");
		}else{
			//提交的答案错误
			getPrintWriter().write("错误");
		}
		return null;
	}
}
