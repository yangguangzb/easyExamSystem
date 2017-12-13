package com.san.service.Impl;

import com.san.dao.Impl.PostCommentDaoImpl;
import com.san.dao.Impl.PostCreationDaoImpl;
import com.san.dao.PostCommentDao;
import com.san.dao.PostCreationDao;
import com.san.model.PostComment;
import com.san.model.PostCreation;
import com.san.model.ShowPostCreation;
import com.san.service.ShareAreaService;

import java.util.Date;

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
}
