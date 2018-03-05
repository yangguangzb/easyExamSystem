package com.san.action;
import org.apache.struts2.ServletActionContext;
import com.san.base.BaseAction;
import com.san.model.User;
import com.san.service.UserService;
import com.san.service.Impl.UserServiceImpl;
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
	
	public String forgetPassword(){
		int i=userService.isE_mail(this.getModel().getE_mail());
		if(i==1){
			//邮箱邮箱
			return "forgetPassword";
		}else{
			//输入邮箱无效
			addFieldError("","输入邮箱有误");
			return "errorMail";
		}
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
