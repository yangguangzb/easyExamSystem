package com.san.servlet;

import com.san.dao.Impl.ResourceDaoImpl;
import com.san.dao.ResourceDao;
import com.san.model.Resource;
import com.san.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

import com.san.service.Impl.ResourceServiceImpl;
import com.san.service.ResourceService;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class ResourceUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      User user=(User)request.getSession().getAttribute("user");
      if(user!=null){
          Resource resource=new Resource();
          ResourceDao resourceDao=new ResourceDaoImpl();
          ResourceService resourceService=new ResourceServiceImpl();
          resource.setResourceId(0);
          resource.setDownNumber(0);
          resource.setUploadId(user.getUserId());
          //从表单获取数据
          DiskFileItemFactory diskFileItemFactory=new DiskFileItemFactory();
          ServletFileUpload upload=new ServletFileUpload(diskFileItemFactory);
          if(upload.isMultipartContent(request)){
              try {
                  List<FileItem> list=upload.parseRequest(request);
                  //遍历list
                  for(FileItem item:list){
                      //获取普通表单数据
                      if(item.isFormField()){
                          if(item.getFieldName().equals("course"))
                              resource.setCourseName(item.getString("utf-8"));
                          if(item.getFieldName().equals("resourceName"))
                              resource.setResourceName(item.getString("UTF-8"));
                          if(item.getFieldName().equals("resourceDescription"))
                              resource.setResourceDescription(item.getString("utf-8"));
                          if(item.getFieldName().equals("integration")){
                              int integration=Integer.parseInt(item.getString("utf-8"));
                              resource.setIntegration(integration);
                          }
                      }
                      //获取文件
                      else{
                    	  if(item.getInputStream() != null){
                    		  String realPath = getServletContext().getRealPath("/WEB-INF/resource");
                              File file=new File(realPath,resource.getResourceName());
                            
      
                              String path="/resource/"+resource.getResourceName();
                              resource.setResourcePath(path);
                              item.write(file);
                              item.delete();
                    	  }
                    	  else
                    	  {
                    		  String message="文件为空！";
                    		  request.getSession().setAttribute("message", message);
                              request.getRequestDispatcher("dataupload.jsp").forward(request,response);
                    	  }
                      }


                  }
              } catch (FileUploadException e) {
                  e.printStackTrace();
              } catch (Exception e) {
                  e.printStackTrace();
              }
          }
          resourceDao.insertResource(resource);
          resourceService.uploadResource(user,resource);
          request.getRequestDispatcher("data.jsp").forward(request,response);

      }
      else {
          response.sendRedirect("login.jsp");
      }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
