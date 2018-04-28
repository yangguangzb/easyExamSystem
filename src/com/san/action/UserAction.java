package com.san.action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import org.apache.struts2.ServletActionContext;
import com.san.base.BaseAction;
import com.san.model.User;
import com.san.service.UserService;
import com.san.service.Impl.UserServiceImpl;
import com.san.utils.ActivationCode;
import com.san.utils.DBUtil;
import com.san.utils.SendJMail;
/**
 * 用户action
 * @author zhangbiao
 *
 */
public class UserAction extends BaseAction<User> {
	private static final long serialVersionUID = 1L;
	UserService userService=new UserServiceImpl();
	/**
	 * 用户登录
	 * @return
	 */
	public String login(){
		User user = userService.login(this.getModel());
		if(user!=null){
			if(user.getVerification()==0){
				//用户被拉入黑名单
				addFieldError("","您被拉入黑名单，请与管理员联系");
				return "login";
			}else{
				//登录成功
				putSession("user",user);
				return SUCCESS;
			}
		}else{
			//登录失败
			addFieldError("","用户名与密码不匹配");
			return "login";
		}
	}
	
	/**
	 * 忘记密码，发送邮箱验证码
	 * @return
	 */
	public String forgetPassword(){
		int i=userService.isE_mail(this.getModel().getE_mail());
		if(i==1){
			//邮箱有效
			//保存有效的邮箱
			getSession().setAttribute("forgetPasswordEmail",getModel().getE_mail());
			//获取随机数验证码
			String forgetsuiji=ActivationCode.activationCode();
			//保存随机数
			getSession().setAttribute("forgetsuiji", forgetsuiji);
			//发送验证码
			SendJMail sd=new SendJMail();
			sd.sendMail(this.getModel().getE_mail(), "验证码为:"+forgetsuiji,"找回密码");
			return "forgetPassword";
		}else{
			//输入邮箱无效
			addFieldError("","输入邮箱有误");
			return "errorMail";
		}
	}
	
	/**
	 * 找回密码，验证用户输入验证码是否正确
	 * @return
	 */
	public String verificationCode(){
		String forgetsuiji=(String) getSession().getAttribute("forgetsuiji");
		if(this.getModel().getVerificationCode().equals(forgetsuiji)){
			//验证码正确
			return "verificationCode_success";
		}else{
			addFieldError("","验证码有误");
			return "verificationCode_fail";
		}
	}
	
	/**
	 * 重置密码
	 * @return
	 */
	public String resetPassword(){
		String e_mail=(String) getSession().getAttribute("forgetPasswordEmail");
		int i=userService.backPassword(e_mail,this.getModel().getPassword());
		if(i==1){
			//重置密码成功、
			return "resetPassword_success";
		}
		addFieldError("","重置密码失败");
		return "resetPassword_fail";
	}
	
	/**
	 * 注册时，判断用户名是否合法
	 * @return
	 * @throws IOException 
	 */
	public String isExistenceUserName() throws IOException{
		String userName=getRequest().getParameter("userName");
		User user=userService.findUserByUserName(userName);
		if(user!=null){
			//用户名已存在
			getPrintWriter().write("-1");
		}else{
			//用户名不存在，下一步注册
			getSession().setAttribute("registerUserName", userName);
		}
		return null;
	}
	
	/**
	 * 注册时，判断邮箱是否合法
	 * @return
	 * @throws IOException 
	 */
	public String isExistenceEmail() throws IOException{
		String e_mail=getRequest().getParameter("e_mail");
		int i=userService.isE_mail(e_mail);
		if(i==1){
			//邮箱已存在
			getPrintWriter().write("-1");
		}else{
			//邮箱不存在，下一步注册
			getSession().setAttribute("registerE_mail",e_mail);
		}
		return null;
	}
	
	/**
	 * 注册时，保存密码
	 * @return
	 */
	public String savePassword(){
		String password=getRequest().getParameter("password");
		getSession().setAttribute("registerPassword", password);
		return null;
	}
	
	/**
	 * 注册时，发送激活码
	 * @return
	 */
	public String registerJihuoma(){
		//生成激活码
		Random rd=new Random();
		String jihuoma="";
		for(int i=0;i<6;i++){
			String m=""+rd.nextInt(10);
			jihuoma=jihuoma+m;
		}
		getSession().setAttribute("suiji",jihuoma);
		SendJMail sm=new SendJMail();
		sm.sendMail(getSession().getAttribute("registerE_mail").toString(), jihuoma,"用户激活码:");
		return null;
	}
	
	/**
	 * 注册时，验证激活码
	 * @return
	 * @throws IOException 
	 */
	public String registerYanEmail() throws IOException{
		String verifyNo=getRequest().getParameter("verificationCode");
		if(getSession().getAttribute("suiji")!=null){
			if(verifyNo.equals(getSession().getAttribute("suiji").toString())){
				String userName=getSession().getAttribute("registerUserName").toString();
				String e_mail=getSession().getAttribute("registerE_mail").toString();
				String password=getSession().getAttribute("registerPassword").toString();
				int k=userService.addUser(userName,e_mail,password);
				if(k==1){
					
				}else{
					getPrintWriter().write("-1");
				}
			}else{
				//验证码输入错误
				getPrintWriter().write("-1");
			}
		}else{
			//没有发验证码
			getPrintWriter().write("-1");
		}
		return null;
	}
	
	/**
	 * 用户退出系统
	 * @return
	 */
	public String signOut(){
		//退出系统
		ServletActionContext.getRequest().getSession().invalidate();
		System.out.println("测试");
		return "signOut";
	}
	
	/**
	 * 用户登录后，修改密码
	 * @return
	 */
	public String changePassword(){
		String password=getRequest().getParameter("pass").trim();
        User user=(User) getRequest().getSession().getAttribute("user");
        if(user!=null){
            user.setPassword(password);
            UserService userService=new UserServiceImpl();
            userService.updateUserByPassword(user);
            //response.sendRedirect("/login.jsp");
        }
		return "changePassword";
	}
	
}
