package com.san.servlet;

import com.san.model.PostComment;
import com.san.model.PostCreation;
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
    }
    void listPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ShareAreaService shareAreaService=new ShareAreaServiceImpl();
        String postCreationId=request.getParameter("postCreationId");
        int postCreationIds=Integer.parseInt(postCreationId);
        PostCreation postCreation=shareAreaService.getPostCreation(postCreationIds);
        List<PostComment> postCommentList=shareAreaService.listPostComment(postCreationIds);
        // 将信息存入到session中
        request.getSession().setAttribute("postCommentList",postCommentList);
        request.getSession().setAttribute("postCreation",postCreation);
        request.getRequestDispatcher("sharecomment.jsp").forward(request,response);
        return ;
    }
}
