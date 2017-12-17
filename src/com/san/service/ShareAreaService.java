package com.san.service;

import com.san.model.PostComment;
import com.san.model.PostCreation;
import com.san.model.ShowPostCreation;

import java.util.List;

public interface ShareAreaService {
     ShowPostCreation listAllPostCreation(PostCreation postCreation, PostComment postComment);// 显示所有帖子
     List<ShowPostCreation> listAllPostCreation();//显示所有帖子
}
