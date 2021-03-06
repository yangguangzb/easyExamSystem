package com.san.servlet;

import com.google.gson.Gson;
import com.san.model.Grade;
import com.san.model.User;
import com.san.service.HistoryService;
import com.san.service.Impl.HistoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class GradeHistoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=(User)request.getSession().getAttribute("user");
        if(user!=null){
            PrintWriter pw=response.getWriter();
            HistoryService historyService=new HistoryServiceImpl();
            List<Grade> gradeList=historyService.listGradeByUser(user.getUserId());
            Gson gson=new Gson();
            String jsonObject=gson.toJson(gradeList);
            pw.print(jsonObject);
            return ;
        }
    }
}
