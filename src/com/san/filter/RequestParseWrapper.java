package com.san.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.multipart.JakartaMultiPartRequest;

public class RequestParseWrapper  extends JakartaMultiPartRequest {
	@Override
	public void parse(HttpServletRequest   servletRequest,   String   saveDir)throws  IOException{   
	}	
}
