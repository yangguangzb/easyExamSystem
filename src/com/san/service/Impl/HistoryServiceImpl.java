package com.san.service.Impl;

import com.san.dao.GradeDao;
import com.san.dao.Impl.GradeDaoImpl;
import com.san.dao.Impl.UseRecordDaoImpl;
import com.san.dao.UseRecordDao;
import com.san.model.Grade;
import com.san.model.UseRecord;
import com.san.service.HistoryService;

import java.util.ArrayList;
import java.util.List;

public class HistoryServiceImpl implements HistoryService {

  /*
  * 列出某一用户的所有记录
  * */
    @Override
    public List<UseRecord> listUseRecord(int userId) {
        UseRecordDao useRecordDao=new UseRecordDaoImpl();
        List<UseRecord> useRecordList=new ArrayList<UseRecord>();
        useRecordList=useRecordDao.listUseRecord(userId);
      return   useRecordList;
    }

    @Override
    public List<UseRecord> listResourceUseRecord(int userId) {
        UseRecordDao useRecordDao=new UseRecordDaoImpl();
        List<UseRecord> useRecordList=useRecordDao.listResourceUseRecord(userId);
        return useRecordList;
    }

    @Override
    public List<Grade> listGradeByUser(int userId) {
        GradeDao gradeDao=new GradeDaoImpl();
        List<Grade> gradeList=gradeDao.listGradeByUser(userId);
        return gradeList;
    }
}
