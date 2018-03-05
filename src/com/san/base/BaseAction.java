package com.san.base;
import java.lang.reflect.ParameterizedType;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.san.service.UserService;
/**
 * action基类
 * @author zhangbiao
 * @param <T>
 */
public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{
	private static final long serialVersionUID = 1L;
	//封装数据
	private T t;
	public T getModel() {
		return t;
	}
	
	//实例化t
	public BaseAction() {
		try {
			//获得T运行时的Class
			ParameterizedType paramType = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class<T> clazz= (Class<T>) paramType.getActualTypeArguments()[0];
			//反射建立实例
			t=clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	//--------------------service层的方法-------------------------------
	//用户service
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public UserService getUserService() {
		return userService;
	}
	
	
	
	//--------------------------------------------------------------
	
	//简化值栈操作
	/**
	 * 压栈
	 * @param o
	 */
	public void push(Object o){
		ActionContext.getContext().getValueStack().push(o);
	}
	
	/**
	 * 值栈的set
	 * @param key
	 * @param o
	 */
	public void set(String key,Object o){
		ActionContext.getContext().getValueStack().set(key, o);
	}
	
	/**
	 * map的put
	 * @param key
	 * @param o
	 */
	public void put(String key,Object o){
		ActionContext.getContext().put(key, o);
	}
	
	/**
	 * session的put
	 * @param key
	 * @param o
	 */
	public void putSession(String key,Object o){
		ActionContext.getContext().getSession().put(key, o);
	}
	
	/**
	 * application的put
	 * @param key
	 * @param o
	 */
	public void putApplication(String key,Object o){
		ActionContext.getContext().getApplication().put(key, o);
	}
	
}
