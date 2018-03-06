package com.san.action;
import org.apache.struts2.ServletActionContext;
import com.san.base.BaseAction;
import com.san.model.User;
import com.san.service.UserService;
import com.san.service.Impl.UserServiceImpl;
import com.san.utils.ActivationCode;
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
		int i=userService.backPassword(this.getModel().getE_mail(),this.getModel().getPassword());
		if(i==1){
			//重置密码成功、
			return "resetPassword_success";
		}
		addFieldError("","重置密码失败");
		return "resetPassword_fail";
	}
	
	
	
	/**
	 * 用户退出系统
	 * @return
	 */
	public String signOut(){
		//退出系统
		ServletActionContext.getRequest().getSession().invalidate();
		return "signOut";
	}
}
