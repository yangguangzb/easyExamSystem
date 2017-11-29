package com.san.dao;

import com.san.model.Resource;
import com.san.model.UseRecord;

import java.util.List;

public interface UseRecordDao {
    public List<UseRecord> listUseRecord();//列出所有积分使用记录
    public List<UseRecord> listUseRecord(int userId);//列出某一用户的积分使用记录
   // public void deleteUseRecord(int RecordId);//删除某一条使用记录
   // public void deleteUseRecord();//删除所有积分使用记录
    public void insertUseRecord(UseRecord useRecord);//增加某一使用记录
  //  public void updateUseRecord(UseRecord useRecord);//更新某一积分使用记录
    public UseRecord getUseRecord(int RecordId);//得到某一条积分使用记录
    public int getTotalRecord();//得到积分使用记录数目
    public int getTotalRecord(int userId);//得到某一用户的使用记录数目
}
