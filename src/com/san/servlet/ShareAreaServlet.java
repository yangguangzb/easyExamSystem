package com.san.servlet;

import com.google.gson.Gson;
import com.san.model.ShowPostCreation;
import com.san.service.Impl.ShareAreaServiceImpl;
import com.san.service.ShareAreaService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ShareAreaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw=response.getWriter();
        ShareAreaService shareAreaService=new ShareAreaServiceImpl();
        List<ShowPostCreation> showPostCreationList=shareAreaService.listAllPostCreation();
        Gson gson=new Gson();
        String jsonObject=gson.toJson(showPostCreationList);
        pw.print(jsonObject);
    }
}
