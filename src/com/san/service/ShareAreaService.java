package com.san.service;

import com.san.model.PostComment;
import com.san.model.PostCreation;
import com.san.model.ShowPostCreation;

public interface ShareAreaService {
     ShowPostCreation listAllPostCreation(PostCreation postCreation, PostComment postComment);// 显示所有帖子
}
