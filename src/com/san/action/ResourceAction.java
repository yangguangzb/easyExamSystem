package com.san.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.san.base.BaseAction;
import com.san.dao.ResourceDao;
import com.san.dao.Impl.ResourceDaoImpl;
import com.san.model.Resource;
import com.san.model.UseRecord;
import com.san.model.User;
import com.san.service.ResourceService;
import com.san.service.Impl.ResourceServiceImpl;

/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
public class ResourceAction extends BaseAction<Resource>  {
 private ResourceService resourceService=new ResourceServiceImpl();
 /**
  * @description 实现文件的下载
  * @return
 * @throws IOException 
  */
 public String getResource() throws IOException{
	 User user=(User) ActionContext.getContext().getSession().get("user");
	 int resourceIds=this.getModel().getResourceId();
	 HttpServletResponse response = ServletActionContext.getResponse();
	 if(user!=null){
         UseRecord useRecord=new UseRecord();
        ResourceService resourceService=new ResourceServiceImpl();
          resourceService.getResource(user,resourceIds,useRecord);
          ResourceDao resourceDao=new ResourceDaoImpl();
          Resource resource=resourceDao.getResource(resourceIds);
          String filename=resource.getResourceName();//文件名字
          filename = new String(filename.getBytes("UTF-8"), "ISO-8859-1");
          response.setContentType(ServletActionContext.getServletContext().getMimeType(filename));//设置文件mine
          response.setHeader("Content-Disposition", "attachment;filename="+filename);
          String fullfileName=ServletActionContext.getServletContext().getRealPath("/WEB-INF"+resource.getResourcePath());
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
         // response.sendRedirect("data.jsp");	
          return "data";

      }
      else{
         // response.sendRedirect("login.jsp");
          return "login";
      }

	 
 }
 /**
  * @description 列出资料
  * @return
  * @throws IOException
  */
 public String listResource() throws IOException{
	 HttpServletResponse response = ServletActionContext.getResponse();
	   response.setContentType("text/html;charset=utf-8");
     PrintWriter pw = response.getWriter();
     ResourceService resourceService=new ResourceServiceImpl();
     List<Resource> resourceList=resourceService.listAllResourceInTable();
     //转换为json对象
     Gson gson=new Gson();
     String jsonObject=gson.toJson(resourceList);
     pw.write(jsonObject);
     return null;
 }
 /**
  * 上传资料
  * @return
  */
 public String insertResource(){
	 User user=(User)ActionContext.getContext().getSession().get("user");
	 HttpServletRequest request=ServletActionContext.getRequest();//获取request
	 HttpServletResponse response = ServletActionContext.getResponse();//获取response
	 ResourceDao resourceDao=new ResourceDaoImpl();
     if(user!=null){
         Resource resource=new Resource();
       //  ResourceDao resourceDao=new ResourceDaoImpl();
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
                         if(item.getFieldName().equals("courseName"))
                             resource.setCourseName(item.getString("utf-8").trim());
                         if(item.getFieldName().equals("resourceName"))
                             resource.setResourceName(item.getString("UTF-8").trim());
                         if(item.getFieldName().equals("resourceDescription"))
                             resource.setResourceDescription(item.getString("utf-8").trim());
                         if(item.getFieldName().equals("integration")){
                             int integration=Integer.parseInt(item.getString("utf-8").trim());
                             resource.setIntegration(integration);
                         }
                        
                     }
                     //获取文件
                     else{
                   	  if(item.getInputStream() != null){
                   		  String realPath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/resource");
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
                             return "upload";
                   	  }
                     }


                 }
                 resourceService.uploadResource(user,resource);

             } catch (FileUploadException e) {
                 e.printStackTrace();
             } catch (Exception e) {
                 e.printStackTrace();
             }
         }
         resourceDao.insertResource(resource);
         resourceService.uploadResource(user,resource);
         return "successupload";

     }
     else {
         return "notlogin";
     }
 }
}
