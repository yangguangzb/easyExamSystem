package com.san.dao;

import com.san.model.PostComment;
import com.san.model.ShowPostCommentUser;

import java.util.List;

public interface PostCommentDao {
    List<ShowPostCommentUser> listPostCommentByPostCreationId(int postCreationId);//列出某个帖子的所有评论
    void insertPostComment(PostComment postComment);//插入评论
    int totalPostComment(int postCreationId);// 列出某个帖子的评论数目
    PostComment getLatestComment(int postCreationId);// 获取最新的评论
}
