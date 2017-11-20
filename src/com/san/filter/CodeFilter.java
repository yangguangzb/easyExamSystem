package com.san.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

public class CodeFilter implements Filter{
	private FilterConfig filterConfig;
	public void destroy() {
		
	}
	/**
	 *编码过滤
	 */
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//String encoding = filterConfig.getInitParameter("encoding");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//放行
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}
	
}
/**
 * 写装饰类步骤
 * 1、实现与被包装对象相同接口
 * 2、定义一个与被包装类相同对象的引用
 * 3、定义一个构造方法,把被包装对象传过来
 * 4、对于不需要改写的方法,直接调用
 * 5、对于需要改写的方法,写自己的方法体
 *//*
class MyRequest extends HttpServletRequestWrapper {
	HttpServletRequest request;

	public MyRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}


	@Override
	public String getParameter(String name) {
		Map<String, String[]> map = getParameterMap();
		return map.get(name)[0];
	}

	@Override
	public String[] getParameterValues(String name) {
		Map<String, String[]> map = getParameterMap();
		return map.get(name);
	}

	private boolean flag = true;

	@Override
	public Map<String, String[]> getParameterMap() {
		Map<String, String[]> map = request.getParameterMap();// 乱码
		if (flag) {
			for (Map.Entry<String, String[]> m : map.entrySet()) {
				String[] values = m.getValue();
				for (int i = 0; i < values.length; i++) {
					try {
						values[i] = new String(
								values[i].getBytes("iso-8859-1"), "UTF-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}

			}
			flag = false;
		}
		return map;

	}

}
*/