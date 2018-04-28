package com.san.base;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.ParameterizedType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

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
	 * 获得putSession中的值
	 * @param o
	 * @return
	 */
	public Object getPutSession(Object o){
		return ActionContext.getContext().getSession().get(o);
	}
	
	/**
	 * application的put
	 * @param key
	 * @param o
	 */
	public void putApplication(String key,Object o){
		ActionContext.getContext().getApplication().put(key, o);
	}
	
	/**
	 * 获得session
	 * @return
	 */
	public HttpSession getSession(){
		return ServletActionContext.getRequest().getSession();
	}
	
	/**
	 * 向浏览器输出
	 * @return
	 * @throws IOException
	 */
	public PrintWriter getPrintWriter() throws IOException{
		 ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		 return ServletActionContext.getResponse().getWriter();
	}
	
	/**
	 * 获得response
	 * @return
	 */
	public HttpServletResponse getResponse(){
		
		return ServletActionContext.getResponse();
	}
	
	/**
	 * 获得request
	 * @return
	 */
	public HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}
	
}
