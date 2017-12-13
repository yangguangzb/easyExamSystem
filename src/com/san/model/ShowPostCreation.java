package com.san.model;

import java.util.Date;

/*
* 展示 所有的帖子
* */
public class ShowPostCreation {
    private int commentCount;// 评论数目
    private String postTitle;// 帖子标题
    private Date latestTime;//最新评论时间

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
}
