package com.san.service.Impl;

import com.san.dao.Impl.ResourceDaoImpl;
import com.san.dao.ResourceDao;
import com.san.model.Resource;
import com.san.service.ResourceService;

import java.util.ArrayList;
import java.util.List;

public class ResourceServiceImpl implements ResourceService {
    private ResourceDao resourceDao=new ResourceDaoImpl();
    @Override
    public List<Resource> listAllResourceInTable() {
       // List<Resource> resourceList=resourceDao.listResource();
      //  return resourceList;
        List<Resource> resourceList = new ArrayList<Resource>();
        resourceList=resourceDao.listResource();
        return resourceList;
    }
}
