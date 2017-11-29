package com.san.dao.Impl;

import com.san.dao.UseRecordDao;
import com.san.model.Resource;
import com.san.model.UseRecord;
import com.san.utils.C3p0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class UseRecordDaoImpl implements UseRecordDao {
    @Override
    public List<UseRecord> listUseRecord() {
        try {
            QueryRunner runner=new QueryRunner(C3p0Util.getDataSource());
            String sql="select * from resource";
            return (List<UseRecord>) runner.query(sql,new BeanListHandler<UseRecord>(UseRecord.class));
        }
        catch (SQLException ex) {
            // TODO: handle exception
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<UseRecord> listUseRecord(int userId) {
        try {
            QueryRunner runner=new QueryRunner(C3p0Util.getDataSource());
            String sql="select * from resource where userId=?";
            return (List<UseRecord>) runner.query(sql,new BeanListHandler<UseRecord>(UseRecord.class),userId);
        }
        catch (SQLException ex) {
            // TODO: handle exception
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void insertUseRecord(UseRecord useRecord) {
        try {
            QueryRunner runner=new QueryRunner(C3p0Util.getDataSource());
            String sql="insert into useRecord(recordId,userId,useType,useNumber,useTime) values(?,?,?,?,?)";
            Object[] params= {useRecord.getRecordId(),useRecord.getUserId(),useRecord.getUseType(),useRecord.getUseNumber(),useRecord.getUseTime()};
            runner.update(sql,params);
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }

    }



    @Override
    public UseRecord getUseRecord(int RecordId) {
        try{
            QueryRunner runner=new QueryRunner(C3p0Util.getDataSource());
            String sql="select * from useRecord where RecordId=?";
            return (UseRecord) runner.query(sql,new BeanHandler(UseRecord.class),RecordId);
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public int getTotalRecord() {
        try{
            QueryRunner runner=new QueryRunner(C3p0Util.getDataSource());
            String sql="select count(*) from useRecord ";
            long totalrecord=(long)runner.query(sql, new ScalarHandler());
            return (int) totalrecord;
        }
        catch (SQLException ex){
            return 0;
        }
    }

    @Override
    public int getTotalRecord(int userId) {
        try{
            QueryRunner runner=new QueryRunner(C3p0Util.getDataSource());
            String sql="select count(*) from useRecord ";
            long totalrecord=(long)runner.query(sql, new ScalarHandler());
            return (int) totalrecord;
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        return 0;
    }
}
