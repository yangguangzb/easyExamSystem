package com.san.dao;

import com.san.model.PostCreation;

import java.util.List;

public interface PostCreationDao {
    void insertPostCreation(PostCreation postCreation);// 插入创建的帖子
    List<PostCreation> listPostCreation(); // 列出所有的帖子
    PostCreation getPostCreation(String postCreationId);// 列出选择到的帖子
}
