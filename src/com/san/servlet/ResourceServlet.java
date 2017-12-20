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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

public class ResourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
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
                ResourceDao resourceDao=new ResourceDaoImpl();
                Resource resource=resourceDao.getResource(resourceIds);
                String filename=resource.getResourceName();//文件名字
                filename = new String(filename.getBytes("UTF-8"), "ISO-8859-1");
                response.setContentType(getServletContext().getMimeType(filename));//设置文件mine
                response.setHeader("Content-Disposition", "attachment;filename="+filename);
                String fullfileName=getServletContext().getRealPath("/WEB-INF"+resource.getResourcePath());
                InputStream in = new FileInputStream(fullfileName);
                OutputStream out = response.getOutputStream();

                //写文件
                int b;
                while((b=in.read())!= -1)
                {
                    out.write(b);
                }

                in.close();
                out.close();
                response.sendRedirect("data.jsp");
                return ;	

            }
            else{
                response.sendRedirect("login.jsp");
                return ;
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
        return ;
    }

}
