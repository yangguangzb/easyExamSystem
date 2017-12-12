package com.san.model;

import java.util.Date;

public class PostCreation {
    private int postCreationId;//帖子创建编号
    private String postTitle;//帖子标题
    private String postCreatorId;//帖子创建者编号
    private String discussionName;//区域名称
    private String creationResourcePath;//创建资源路径
    private String postConent;//内容
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

    public String getPostCreatorId() {
        return postCreatorId;
    }

    public void setPostCreatorId(String postCreatorId) {
        this.postCreatorId = postCreatorId;
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

    public String getPostConent() {
        return postConent;
    }

    public void setPostConent(String postConent) {
        this.postConent = postConent;
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
}
