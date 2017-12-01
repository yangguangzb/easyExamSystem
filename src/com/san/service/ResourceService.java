package com.san.service;

import com.san.dao.ResourceDao;
import com.san.model.Resource;
import com.san.model.UseRecord;
import com.san.model.User;

import java.util.List;

public interface ResourceService {
    public List<Resource> listAllResourceInTable();//列出所有资料
  //  public List<Resource> listAllResourceInTable(Resource resource,User user)
    public void getResource(User user, int resourceId, UseRecord useRecord);//下载资料
    public void uploadResource(User user,Resource resource,UseRecord useRecord);//上传资料
}
