package com.san.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.san.base.BaseAction;
import com.san.model.PostComment;
import com.san.model.ShowPostCommentUser;
import com.san.model.ShowPostCreation;
import com.san.model.ShowPostCreationUser;
import com.san.model.User;
import com.san.service.ShareAreaService;
import com.san.service.Impl.ShareAreaServiceImpl;

public class ShareAreaAction extends  BaseAction<User>{
	private static final long serialVersionUID = 1L;
	//列出所有的分享标题
	public String listArea() throws IOException{
		 HttpServletResponse response = ServletActionContext.getResponse();//得到response
		  response.setContentType("text/html;charset=utf-8");//设置编码
	        PrintWriter pw=response.getWriter();
	        ShareAreaService shareAreaService=new ShareAreaServiceImpl();
	        List<ShowPostCreation> showPostCreationList=shareAreaService.listAllPostCreation();
	        Gson gson=new Gson();
	        String jsonObject=gson.toJson(showPostCreationList);
	        pw.print(jsonObject);
		    return null;	
	}
	//列出所有的评论
	public String listComment(){
		 HttpServletRequest request=ServletActionContext.getRequest();//获取request
		 HttpServletResponse response = ServletActionContext.getResponse();//获取response
		  ShareAreaService shareAreaService=new ShareAreaServiceImpl();
          String postCreationId=request.getParameter("postCreationId");
          int postCreationIds=Integer.parseInt(postCreationId);
          ShowPostCreationUser showPostCreationUser=shareAreaService.getPostCreation(postCreationIds);
          List<ShowPostCommentUser> postCommentList=shareAreaService.listPostComment(postCreationIds);
          // 将信息存入到session中
          request.getSession().setAttribute("postCommentList",postCommentList);
          request.getSession().setAttribute("showPostCreationUser",showPostCreationUser);
          return "sharecomment";
	}
	//增加评论
	public String insertComment(){
		 HttpServletRequest request=ServletActionContext.getRequest();//获取request
		 HttpServletResponse response = ServletActionContext.getResponse();//获取response
		  //从request中获取评论内容
        String commentContent=request.getParameter("commentContent");
        //从session中取数据
        User user=(User)request.getSession().getAttribute("user");
        ShowPostCreationUser showPostCreationUser=(ShowPostCreationUser) request.getSession().getAttribute("showPostCreationUser");
        ShareAreaService shareAreaService=new ShareAreaServiceImpl();
        PostComment postComment=new PostComment();
        postComment.setReviewerId(user.getUserId());//评论者编号
        postComment.setPostCreationId(showPostCreationUser.getPostCreationId());//帖子创建编号
        postComment.setCommentContent(commentContent);//评论信息
        shareAreaService.insertPostComment(postComment); //插入评论表中
        //request.getRequestDispatcher("share.jsp").forward(request,response);//请求转发
        return "share";
	}
	
}
