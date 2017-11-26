package com.san.servlet;

import com.google.gson.Gson;
import com.san.dao.Impl.ResourceDaoImpl;
import com.san.dao.ResourceDao;
import com.san.model.Resource;
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
        PrintWriter pw = response.getWriter();
        ResourceService resourceService=new ResourceServiceImpl();
        List<Resource> resourceList=resourceService.listAllResourceInTable();
        //转换为json对象
        Gson gson=new Gson();
        String jsonObject=gson.toJson(resourceList);
        pw.write(jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

}
