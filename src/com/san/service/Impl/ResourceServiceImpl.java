package com.san.service.Impl;

import com.san.dao.Impl.CourseDaoImpl;
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

import java.sql.SQLException;
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
    public void getResource(User user, int resourceId, UseRecord useRecord) {
        UserDao userDao=new UserDaoImpl();
        ResourceDao resourceDao=new ResourceDaoImpl();
        UseRecordDao useRecordDao=new UseRecordDaoImpl();
        //得到resource对象
        Resource resource=resourceDao.getResource(resourceId);
        //设置useRecord
        String useType="下载"+resource.getResourceName();
        int useNumber=0;//记录使用积分数目
        //记录相同useType 相同userId的记录条数
        int count=useRecordDao.getRecordByUseType(user.getUserId(),useType);
        //当count为0则需要扣积分
        if(count==0){
            useNumber=0-resource.getIntegration();
        }
        useRecord.setRecordId(0);
        useRecord.setUserId(user.getUserId());
        useRecord.setUseType(useType);
        useRecord.setUseNumber(useNumber);
      //  useRecord.setUseTime(d);
        //下载次数加一
        resourceDao.updateDownNumber(resource);
        //更新用户积分
        userDao.minusIntegralNumber(user,0-useNumber);
        //增加一条积分使用记录
        useRecordDao.insertUseRecord(useRecord);
    }

    public void uploadResource(User user, Resource resource) {
        String useType="上传"+resource.getResourceName();
        UseRecord useRecord=new UseRecord();
        UserDao userDao=new UserDaoImpl();
        ResourceDao resourceDao=new ResourceDaoImpl();
        UseRecordDao useRecordDao=new UseRecordDaoImpl();
        useRecord.setRecordId(0);
        useRecord.setUserId(user.getUserId());
        useRecord.setUseType(useType);
        //上传一个资料得5个积分
        useRecord.setUseNumber(5);

        //更新用户积分
        userDao.addIntegralNumber(user,resource.getIntegration());
        //增加一条积分使用记录
        useRecordDao.insertUseRecord(useRecord);
        //增加一条资源信息
        resourceDao.insertResource(resource);
    }
    public List<Resource> checkResourceService(String courseName,String userId){
    	int uploadId=0;
    	if(!"".equals(userId)){
    		uploadId=Integer.parseInt(userId);
    	}
    	CourseDaoImpl courseDaoImpl=new CourseDaoImpl();
    	try {
			return courseDaoImpl.checkResourceService(courseName, uploadId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
    }
}
