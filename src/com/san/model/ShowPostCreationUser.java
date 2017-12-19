package com.san.model;

import java.util.Date;

public class ShowPostCreationUser {
    private int postCreationId;//帖子创建编号
    private String postTitle;//帖子标题
    private String postCreatorName;//帖子创建者名字
    private String discussionName;//区域名称
    private String creationResourcePath;//创建资源路径
    private String postContent;//内容
    private String postPriority;//优先级
    private Date postTime;//时间

    public int getPostCreationId() {
        return postCreationId;
    }

    public void setPostCreationId(int postCreationId) {
        this.postCreationId = postCreationId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getDiscussionName() {
        return discussionName;
    }

    public void setDiscussionName(String discussionName) {
        this.discussionName = discussionName;
    }

    public String getCreationResourcePath() {
        return creationResourcePath;
    }

    public void setCreationResourcePath(String creationResourcePath) {
        this.creationResourcePath = creationResourcePath;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getPostPriority() {
        return postPriority;
    }

    public void setPostPriority(String postPriority) {
        this.postPriority = postPriority;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public String getPostCreatorName() {
        return postCreatorName;
    }

    public void setPostCreatorName(String postCreatorName) {
        this.postCreatorName = postCreatorName;
    }
}
