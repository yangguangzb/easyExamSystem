package com.san.dao.Impl;

import com.san.dao.GradeDao;
import com.san.model.Grade;
import com.san.model.Resource;
import com.san.utils.C3p0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class GradeDaoImpl implements GradeDao {
    public List<Grade> listGrade() {
        try {
            QueryRunner runner=new QueryRunner(C3p0Util.getDataSource());
            String sql="select * from grade";
            return (List<Grade>) runner.query(sql,new BeanListHandler<Grade>(Grade.class));
        }
        catch (SQLException ex) {
            // TODO: handle exception
            ex.printStackTrace();
            return null;
        }
    }

    public List<Grade> listGradeByUser(int userId) {
        try {
            QueryRunner runner=new QueryRunner(C3p0Util.getDataSource());
            String sql="select * from grade where userId=?";
            return (List<Grade>) runner.query(sql,new BeanListHandler<Grade>(Grade.class),userId);
        }
        catch (SQLException ex) {
            // TODO: handle exception
            ex.printStackTrace();
            return null;
        }
    }

    public List<Grade> listGradeByCourseAndUser(int userId, String course) {
        try {
            QueryRunner runner=new QueryRunner(C3p0Util.getDataSource());
            String sql="select * from grade where userId=? and course=?";
            Object[] params={userId,course};
            return (List<Grade>) runner.query(sql,new BeanListHandler<Grade>(Grade.class),params);
        }
        catch (SQLException ex) {
            // TODO: handle exception
            ex.printStackTrace();
            return null;
        }
    }
}
