package com.san.servlet;

import com.google.gson.Gson;
import com.san.dao.Impl.ResourceDaoImpl;
import com.san.dao.ResourceDao;
import com.san.model.Resource;
import com.san.model.UseRecord;
import com.san.model.User;
import com.san.service.Impl.ResourceServiceImpl;
import com.san.service.ResourceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ResourceServlet")
public class ResourceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if(method.equals("getResource")){
            getResource(request,response);
        }
        if(method.equals("listResource")){
            listResource(request,response);
        }

    }
     void getResource(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
            User user=(User)request.getSession().getAttribute("user");
          // PrintWriter out=response.getWriter();
            String resourceId=request.getParameter("resourceId");
        // out.write(resourceId);
            int resourceIds=Integer.parseInt(resourceId);
            if(user!=null){
               UseRecord useRecord=new UseRecord();
                ResourceService resourceService=new ResourceServiceImpl();
                resourceService.getResource(user,resourceIds,useRecord);
                request.getRequestDispatcher("data.jsp").forward(request,response);
            }
            else{
                response.sendRedirect("login.jsp");
            }


    }
    protected void listResource (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        PrintWriter pw = response.getWriter();
        ResourceService resourceService=new ResourceServiceImpl();
        List<Resource> resourceList=resourceService.listAllResourceInTable();
        //转换为json对象
        Gson gson=new Gson();
        String jsonObject=gson.toJson(resourceList);
        pw.write(jsonObject);
    }

}
