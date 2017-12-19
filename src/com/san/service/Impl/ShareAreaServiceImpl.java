package com.san.service.Impl;

import com.san.dao.Impl.PostCommentDaoImpl;
import com.san.dao.Impl.PostCreationDaoImpl;
import com.san.dao.Impl.UserDaoImpl;
import com.san.dao.PostCommentDao;
import com.san.dao.PostCreationDao;
import com.san.dao.UserDao;
import com.san.model.*;
import com.san.service.ShareAreaService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShareAreaServiceImpl implements ShareAreaService {
    @Override
    public ShowPostCreation listAllPostCreation(PostCreation postCreation, PostComment postComment) {
        PostCreationDao postCreationDao=new PostCreationDaoImpl();
        PostCommentDao postCommentDao=new PostCommentDaoImpl();
        ShowPostCreation showPostCreation=new ShowPostCreation();
        int count=postCommentDao.totalPostComment(postCreation.getPostCreationId());
        String title=postCreation.getPostTitle();
        PostComment postCommentLatest=postCommentDao.getLatestComment(postCreation.getPostCreationId());
        Date date=postCommentLatest.getCommentTime();
        showPostCreation.setCommentCount(count);
        showPostCreation.setPostTitle(title);
        showPostCreation.setLatestTime(date);
        return showPostCreation;
    }

    @Override
    public List<ShowPostCreation> listAllPostCreation() {
        PostCreationDao postCreationDao=new PostCreationDaoImpl();
        PostCommentDao postCommentDao=new PostCommentDaoImpl();
        ShowPostCreation showPostCreation=new ShowPostCreation();
        UserDao userDao=new UserDaoImpl();
        ArrayList<ShowPostCreation> showPostCreationArrayList=new ArrayList<ShowPostCreation>();
        List<PostCreation> postCreationList=postCreationDao.listPostCreation();
        for(PostCreation postCreation:postCreationList)
        {
            User postCreator=userDao.getUser(postCreation.getPostCreatorId());
            ShowPostCreation showPostCreation1=new ShowPostCreation();
            String title=postCreation.getPostTitle(); // 标题
            int postCreationId=postCreation.getPostCreationId();//帖子创建编号
            int count=postCommentDao.totalPostComment(postCreation.getPostCreationId()); // 回复数目
            showPostCreation1.setPostCreationPerson(postCreator.getUserName());//创建者名称
            showPostCreation1.setPostTitle(title);
            showPostCreation1.setPostCreationId(postCreationId);
            showPostCreation1.setCommentCount(count);
            PostComment postComment=postCommentDao.getLatestComment(postCreation.getPostCreationId()); // 最新的评论
            // 如果有评论
            if(postComment!=null){
                User postCommentPerson=userDao.getUser(postComment.getReviewerId());
                showPostCreation1.setLatestTime(postComment.getCommentTime());
                showPostCreation1.setLatestPostCommentPerson(postCommentPerson.getUserName());//回复者名称
                showPostCreationArrayList.add(showPostCreation1);
            }
            else
            {
                showPostCreation1.setLatestTime(postCreation.getPostTime());
                showPostCreationArrayList.add(showPostCreation1);
            }
        }
        return showPostCreationArrayList;
    }

    @Override
    public ShowPostCreationUser getPostCreation(int postCreationId) {
        PostCreationDao postCreationDao=new PostCreationDaoImpl();
        return postCreationDao.getPostCreation(postCreationId);
    }

    @Override
    public List<ShowPostCommentUser> listPostComment(int postCreationId) {
        PostCommentDao postCommentDao=new PostCommentDaoImpl();
        return postCommentDao.listPostCommentByPostCreationId(postCreationId);
    }
}
