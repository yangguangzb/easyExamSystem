package com.san.service.Impl;

import com.san.dao.Impl.ResourceDaoImpl;
import com.san.dao.Impl.UseRecordDaoImpl;
import com.san.dao.Impl.UserDaoImpl;
import com.san.dao.ResourceDao;
import com.san.dao.UseRecordDao;
import com.san.dao.UserDao;
import com.san.model.Resource;
import com.san.model.UseRecord;
import com.san.model.User;
import com.san.service.ResourceService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/*
* 资料区相关操作
* */
public class ResourceServiceImpl implements ResourceService {

    /*
    * 列出所有资料
    * */
    @Override
    public List<Resource> listAllResourceInTable() {
       // List<Resource> resourceList=resourceDao.listResource();
      //  return resourceList;
        ResourceDao resourceDao=new ResourceDaoImpl();
        List<Resource> resourceList = new ArrayList<Resource>();
        resourceList=resourceDao.listResource();
        return resourceList;
    }
    /*
    * 下载成功后更新数据库

    * */
    @Override
    public void getResource(User user, int resourceId, UseRecord useRecord) {
        UserDao userDao=new UserDaoImpl();
        ResourceDao resourceDao=new ResourceDaoImpl();
        UseRecordDao useRecordDao=new UseRecordDaoImpl();
        //获取当前时间
       // Date d = new Date();
      /*  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");*/
        //得到resource对象
        Resource resource=resourceDao.getResource(resourceId);
        //设置useRecord
        int useNumber=0-resource.getIntegration();
        String useType="下载"+resource.getResourceName();
        useRecord.setRecordId(0);
        useRecord.setUserId(user.getUserId());
        useRecord.setUseType(useType);
        useRecord.setUseNumber(useNumber);
      //  useRecord.setUseTime(d);
        //下载次数加一
        resourceDao.updateDownNumber(resource);
        //更新用户积分
        userDao.minusIntegralNumber(user,resource.getIntegration());
        //增加一条积分使用记录
        useRecordDao.insertUseRecord(useRecord);
    }
}
