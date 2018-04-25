package com.san.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.san.base.BaseAction;
import com.san.model.Answer;
import com.san.model.Question;
import com.san.model.User;
import com.san.service.Impl.IntegralServiceImpl;
import com.san.service.Impl.QuestionServiceImpl;

public class QuestionAction extends BaseAction<Question>{
	private static final long serialVersionUID = 1L;
	IntegralServiceImpl integralServiceImpl=new IntegralServiceImpl();
	QuestionServiceImpl questionServiceImpl=new QuestionServiceImpl();
	
	/**
	 * 跳转到问题界面
	 */
	public String toQuestion(){
		return "toQuestion";
	}
	
	/**
	 * 待回答问题处理
	 * @return
	 */
	public String notAnswerQuestion(){
		User user=(User) getSession().getAttribute("user");
		List<Question> notAnswer=questionServiceImpl.notAnswerService(user.getUserId());
		getRequest().setAttribute("notAnswer", notAnswer);
		return "notAnswerQuestion";
	}
	
	/**
	 * 用户提出问题
	 * @return
	 * @throws IOException
	 */
	public String putQuestion() throws IOException{
		//获取课程名,问题积分,问题标题,问题内容
		String courseName=this.getModel().getCourseName();
		String questionReward=this.getModel().getQuestionReward()+"";
		String questionTitle=this.getModel().getQuestionTitle();
		String questionContent=this.getModel().getQuestionContent();
		//判断用户提出问题设置积分是否够
		User user=(User)getSession().getAttribute("user");
		User newUser=integralServiceImpl.isQuestionPointsService(user.getUserId(),questionReward,questionTitle,questionContent,courseName);
		//动态修改用户积分并保存
		if(newUser==null){
			getPrintWriter().write("-1");//积分不够
			return null;
		}else{
			//积分够，修改session中用户积分信息
			getSession().setAttribute("user",newUser);
			getPrintWriter().write("1");
			return null;
		}
	}
	
	/**
	 * 用户回答问题处理
	 * @return
	 * @throws IOException 
	 */
	public String answerQuestion() throws IOException{
		//回答内容
		String answerContent=getRequest().getParameter("answerContent");
		//问题编号
		String questionId=getRequest().getParameter("questionId");
		User user=(User)getRequest().getSession().getAttribute("user");
		String i=questionServiceImpl.answerQuestionService(questionId,user.getUserId(), answerContent)+"";
		getPrintWriter().write(i);
		return null;
	}
	
	/**
	 * 显示网友回答的答案showAllAnswer
	 * @return
	 */
	public String showAllAnswer(){
		String questionId=getRequest().getParameter("questionId");
		List<Answer> showAllAnswer=questionServiceImpl.showAllAnswerService(questionId);
		for (Answer answer : showAllAnswer) {
			if(answer.getIsAdoption()==1){
				//该问题被采纳(设置值为回答Id唯一)
				getRequest().setAttribute("isAdoption",1);
			}
		}
		Question questionById=questionServiceImpl.questionByIdService(questionId);
		if(showAllAnswer.size()==0){
			//没有网友答案
			getRequest().setAttribute("showAllAnswer",0);
		}else{
			getRequest().setAttribute("showAllAnswer", showAllAnswer);
		}
		getRequest().setAttribute("questionById", questionById);
		//我的某个具体问题处理
		if(getRequest().getParameter("flagdetail")!=null&&"detail".equals(getRequest().getParameter("flagdetail"))){
			//转发到我的某个问题的具体内容中
			return "myQuestionDetail";
		}
		return "showAllAnswer";
	}
	
	/**
	 * 我的某一个问题具体显示(包含网友答案等)
	 * @return
	 */
	public String myQuestionDetail(){
		String questionId=getRequest().getParameter("questionId");
		List<Answer> showAllAnswer=questionServiceImpl.showAllAnswerService(questionId);
		for (Answer answer : showAllAnswer) {
			if(answer.getIsAdoption()==1){
				//该问题被采纳(设置值为回答Id唯一)
				getRequest().setAttribute("isAdoption",1);
			}
		}
		Question questionById=questionServiceImpl.questionByIdService(questionId);
		if(showAllAnswer.size()==0){
			//没有网友答案
			getRequest().setAttribute("showAllAnswer",0);
		}else{
			getRequest().setAttribute("showAllAnswer", showAllAnswer);
		}
		getRequest().setAttribute("questionById", questionById);
		//我的某个具体问题处理
		return "myQuestionDetail";
	}
	
	
	/**
	 * 高分问题
	 * @return
	 */
	public String highQuestion(){
		User user=(User)getRequest().getSession().getAttribute("user");
		List<Question> highQuestion=questionServiceImpl.highQuestionService(user.getUserId());
		getRequest().setAttribute("highQuestion", highQuestion);
		return "highQuestion";
	}
	
	/**
	 * 我的所有问题显示
	 * @return
	 */
	public String myQuestion(){
		User user=(User) getRequest().getSession().getAttribute("user");
		List<Question> myQuestions=questionServiceImpl.myQuestion(user.getUserId());
		if(myQuestions.size()==0){
			getRequest().setAttribute("myQuestions", 0);
		}else{
			getRequest().setAttribute("myQuestions", myQuestions);
		}
		return "myQuestion";
	}
	
	/**
	 * 设置我的问题是否解决(包含网友答案等)
	 * @return
	 */
	public String myQuestionIsSolve(){
		//获得评论者Id(最好网友答案)
		String reviewerId=getRequest().getParameter("reviewerId");
		//获得该问题Id
		String questionId=getRequest().getParameter("questionId");
		questionServiceImpl.myQuestionDetailService(questionId, reviewerId);
		return "myQuestionIsSolve";
	}
	
	/**
	 * 我的回答
	 * @return
	 */
	public String myAnswer(){
		User user=(User) getRequest().getSession().getAttribute("user");
		List<Map<String, Object>> myAnswer=questionServiceImpl.myAnswerService(user.getUserId());
		if(myAnswer.size()==0){
			//没有回答
			getRequest().setAttribute("myAnswer", 0);
		}else{
			//用户有回答
			getRequest().setAttribute("myAnswer", myAnswer);
		}
		return "myAnswer";
	}
}
