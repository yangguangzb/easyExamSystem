package com.san.servlet;

import com.san.model.*;
import com.san.service.Impl.ShareAreaServiceImpl;
import com.san.service.ShareAreaService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShareAreaCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if(method.equals("listPost")){
            listPost(request,response);
        }
        if(method.equals("insertPost")){
            insertPost(request,response);
        }
    }
    void listPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ShareAreaService shareAreaService=new ShareAreaServiceImpl();
        String postCreationId=request.getParameter("postCreationId");
        int postCreationIds=Integer.parseInt(postCreationId);
        ShowPostCreationUser showPostCreationUser=shareAreaService.getPostCreation(postCreationIds);
        List<ShowPostCommentUser> postCommentList=shareAreaService.listPostComment(postCreationIds);
        // 将信息存入到session中
        request.getSession().setAttribute("postCommentList",postCommentList);
        request.getSession().setAttribute("showPostCreationUser",showPostCreationUser);
        request.getRequestDispatcher("sharecomment.jsp").forward(request,response);
    }
    void insertPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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
        request.getRequestDispatcher("share.jsp").forward(request,response);//请求转发
    }
}
