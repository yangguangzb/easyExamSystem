package com.san.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.san.model.BrushList;
import com.san.model.Subject;
import com.san.model.User;
import com.san.service.Impl.BoutiqueServiceImpl;
import com.san.service.Impl.IntegralServiceImpl;

public class BoutiqueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoutiqueServiceImpl boutiqueService=new BoutiqueServiceImpl();
	IntegralServiceImpl integralServiceImpl=new IntegralServiceImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//判断用户是否登录
		if(request.getSession().getAttribute("user")==null){
			response.sendRedirect("login.jsp");
			return ;
		}else if(request.getParameter("flag")!=null){
			String flag=request.getParameter("flag");
			//精品区下一题
			if(flag.equals("nextBoutSubject")){
				nextBoutSubject(request, response);
			}
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//判断用户是否登录
		if(request.getSession().getAttribute("user")==null){
			response.sendRedirect("login.jsp");
			return ;
		}else if(request.getParameter("flag")!=null){
			String flag=request.getParameter("flag");
			//显示精品区信息
			if(flag.equals("display")){
				display(request, response);
			}
			//具体精品课程
			if(flag.equals("detail")){
				String courseName=request.getParameter("courseName");
				detail(request, response,courseName);
			}
			//具体题目,开始刷题
			if(flag.equals("detailSubject")){
				String boutiqueSubjectId=request.getParameter("boutiqueSubjectId").toString();
				detailSubject(request, response, boutiqueSubjectId);
			}
			//提交答案处理
			if(flag.equals("answerCl")){
				String submitAnswer=request.getParameter("submitAnswer").toString();
				answerCl(request, response, submitAnswer);
			}
		}
	}
	//显示精品区信息
	public void display(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<BrushList> brushlist=boutiqueService.displayAll();
		//把精品区信息存入session
		request.getSession().setAttribute("brushlist", brushlist);
		//跳转到精品区界面
		response.sendRedirect("boutique.jsp");
	}
	//具体精品课程
	public void detail(HttpServletRequest request, HttpServletResponse response,String courseName)
			throws ServletException, IOException {
		//获取用户积分
		User user=(User) request.getSession().getAttribute("user");
		//获取课程信息,积分
		BrushList brushList = boutiqueService.checkCourseService(courseName);
		//判断用户以前是否购买过该课程
		boolean isBuy=boutiqueService.isBuyService(user.getUserId(),"精品区"+courseName);
		if(isBuy){
			//用户购买过该课程
			//查询题目,保存到session中
			List<Subject> boutiqueSubjectList = boutiqueService.boutiqueSubjectService(courseName);
			request.getSession().setAttribute("boutiqueSubjectList", boutiqueSubjectList);
			//跳转到具体课程刷题
			response.sendRedirect("boutiqueDetail.jsp");
		}else{
			//用户没有购买过该课程
			//判断用户积分是否足够购买该课程题目
			boolean isPoints=boutiqueService.isPoints(user.getIntegralNumber(), courseName);
			if(isPoints){
				//积分够,扣除相应积分
				boutiqueService.reducePointsService(user.getUserId(), brushList.getBrushIntegral(), user.getIntegralNumber());
				//记录用户消耗积分(积分使用记录表)
				integralServiceImpl.boutiqueReduceService(user.getUserId(), "精品区"+courseName, (-brushList.getBrushIntegral()+3));
				//查询题目,保存到session中
				List<Subject> boutiqueSubjectList = boutiqueService.boutiqueSubjectService(courseName);
				request.getSession().setAttribute("boutiqueSubjectList", boutiqueSubjectList);
				//跳转到具体课程刷题
				response.sendRedirect("boutiqueDetail.jsp");
			}else{
				//积分不够，跳转到积分购买界面
				response.getWriter().write("积分不够,请购买积分!");
				response.setHeader("refresh","2;url=buyPoints.jsp");
				return ;
			}
		}
	}
	//具体题目
	int boutId=0;
	List<Subject> boutiqueSubjectList;   //所有题目
	Subject nowBoutiqueSubject;			//当前题目
	public void detailSubject(HttpServletRequest request, HttpServletResponse response,String boutiqueSubjectId)
			throws ServletException, IOException {
		boutiqueSubjectList=(List<Subject>)request.getSession().getAttribute("boutiqueSubjectList");
		int subjectId=0;
		if(boutiqueSubjectId!=""){
			subjectId=Integer.parseInt(boutiqueSubjectId);
			boutId=subjectId-1;
		}
		if(boutiqueSubjectList.size()<subjectId){
			response.getWriter().write("-1");
			boutId=0;
			return ;
		}
		nowBoutiqueSubject=boutiqueSubjectList.get(boutId);
		//总共有多少道题目,存入session
		request.getSession().setAttribute("allSubject", boutiqueSubjectList.size());
		//现在的题目
		request.getSession().setAttribute("nowBoutiqueSubject",nowBoutiqueSubject);
		boutId++;
		//现在题目序号
		request.getSession().setAttribute("boutId", boutId);
	}
	//精品区下一题
	public void nextBoutSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String allSubject=request.getSession().getAttribute("allSubject").toString();
		int allIntSubject=Integer.parseInt(allSubject);
		if(boutId<allIntSubject){	//还有题目可做
			nowBoutiqueSubject=boutiqueSubjectList.get(boutId);
			//现在的题目
			request.getSession().setAttribute("nowBoutiqueSubject",nowBoutiqueSubject);
			boutId++;
			//现在题目序号
			request.getSession().setAttribute("boutId", boutId);
			response.sendRedirect("boutiqueDetail.jsp");
		}
	}
	//精品区答案处理
	public void answerCl(HttpServletRequest request, HttpServletResponse response,String submitAnswer)
			throws ServletException, IOException {
		//获取当前题目的答案
		String answer=nowBoutiqueSubject.getSubjectAnswer();
		if(submitAnswer.equals(answer)){
			//提交的答案正确
			response.getWriter().write("正确");
		}else{
			//提交的答案错误
			response.getWriter().write("错误");
		}
	}
}
