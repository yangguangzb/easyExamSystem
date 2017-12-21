package com.san.dao.Impl;

import com.san.dao.PostCreationDao;
import com.san.model.Grade;
import com.san.model.PostCreation;
import com.san.model.ShowPostCreationUser;
import com.san.utils.C3p0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class PostCreationDaoImpl implements PostCreationDao {
    public void insertPostCreation(PostCreation postCreation) {
        try {
            QueryRunner runner=new QueryRunner(C3p0Util.getDataSource());
            String sql="insert into postCreation(postTitle,postCreatorId,creationResourcePath,postContent,postPriority) values(?,?,?.?,?)";
            Object[] params= {postCreation.getPostTitle(),postCreation.getPostCreatorId(),postCreation.getCreationResourcePath(),postCreation.getPostContent(),postCreation.getPostPriority()};
            runner.update(sql,params);

        }
        catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public List<PostCreation> listPostCreation() {
        try {
            QueryRunner runner=new QueryRunner(C3p0Util.getDataSource());
            String sql="select * from postCreation";
            return (List<PostCreation>) runner.query(sql,new BeanListHandler<PostCreation>(PostCreation.class));
        }
        catch (SQLException ex) {
            // TODO: handle exception
            ex.printStackTrace();
            return null;
        }
    }	

    public ShowPostCreationUser getPostCreation(int postCreationId) {
        try{
            QueryRunner runner=new QueryRunner(C3p0Util.getDataSource());
            String sql="select userName as postCreatorName,postCreationId,postTitle,discussionName,creationResourcePath,postContent,postPriority,postTime from postCreation,user where  userId=postCreatorId and postCreationId=?";
            return (ShowPostCreationUser) runner.query(sql,postCreationId,new BeanHandler(ShowPostCreationUser.class));
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
