package com.san.dao;

import java.util.List;

import com.san.model.Resource;

public interface ResourceDao {
public List<Resource> listResource(String courseName);//列出某门课程的资料
public List<Resource> listResource();//列出所有资料
public Resource getResource(int resourceId);//列出某个资料
public void deleteResource(Resource resource);//删除资料
public void insertResource(Resource resource);//添加资料
public void updateResource(Resource resource);//更新资料
public void updateDownNumber(Resource resource);//更新下载次数
}
