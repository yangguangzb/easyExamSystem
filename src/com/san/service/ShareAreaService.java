package com.san.service;

import com.san.model.*;

import java.util.List;

public interface ShareAreaService {
     ShowPostCreation listAllPostCreation(PostCreation postCreation, PostComment postComment);// 显示所有帖子
     List<ShowPostCreation> listAllPostCreation();//显示所有帖子
     ShowPostCreationUser getPostCreation(int postCreationId);//显示选择的帖子内容
     List<ShowPostCommentUser> listPostComment(int postCreationId);//显示帖子的所有评论
     void insertPostComment(PostComment postComment);
}
