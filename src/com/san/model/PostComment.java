package com.san.model;

import java.util.Date;
/*
* @Author: zijieya
* @Description: 帖子评论
* */
public class PostComment {
    private int postCommentId;//评论id;
    private int postCreationId;//帖子创建编号
    private int reviewerId;//评价者编号
    private String evaluationResourcePath;//评价资源路径
    private Date commentTime;//评价时间
    private String commentContent;//评论内容

    public int getPostCommentId() {
        return postCommentId;
    }

    public void setPostCommentId(int postCommentId) {
        this.postCommentId = postCommentId;
    }

    public int getPostCreationId() {
        return postCreationId;
    }

    public void setPostCreationId(int postCreationId) {
        this.postCreationId = postCreationId;
    }

    public int getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(int reviewerId) {
        this.reviewerId = reviewerId;
    }

    public String getEvaluationResourcePath() {
        return evaluationResourcePath;
    }

    public void setEvaluationResourcePath(String evaluationResourcePath) {
        this.evaluationResourcePath = evaluationResourcePath;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
}
