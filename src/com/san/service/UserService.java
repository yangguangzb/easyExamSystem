package com.san.service;

import com.san.model.User;

public interface UserService {
	 /**
	  * 用户修改密码
	  * @param user
	  */
     public void updateUserByPassword(User user);
     
     /**
      * 登录
      * @param user
      * @return
      */
     public User login(User user);
     
     /**
      * 查看邮箱是否存在
      * @param e_mail
      * @return
      */
     public int isE_mail(String e_mail);
     
}
