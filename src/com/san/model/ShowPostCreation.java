package com.san.model;

import java.util.Date;

/*
* @Author: zijieya
* @Description: 以用户友好的方式 显示帖子列表
* */
public class ShowPostCreation {
    private int postCreationId;//帖子创建编号
    private int commentCount;// 评论数目
    private String postTitle;// 帖子标题
    private Date latestTime;//最新评论时间
    private String postCreationPerson;//创建帖子的人
    private String latestPostCommentPerson;//最新评论人
    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public Date getLatestTime() {
        return latestTime;
    }

    public void setLatestTime(Date latestTime) {
        this.latestTime = latestTime;
    }

    public String getPostCreationPerson() {
        return postCreationPerson;
    }

    public void setPostCreationPerson(String postCreationPerson) {
        this.postCreationPerson = postCreationPerson;
    }

    public String getLatestPostCommentPerson() {
        return latestPostCommentPerson;
    }

    public void setLatestPostCommentPerson(String latestPostCommentPerson) {
        this.latestPostCommentPerson = latestPostCommentPerson;
    }

    public int getPostCreationId() {
        return postCreationId;
    }

    public void setPostCreationId(int postCreationId) {
        this.postCreationId = postCreationId;
    }
}
