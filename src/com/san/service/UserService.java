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
     
     /**
      * 用户找回密码
      * @param e_mail
      * @param password
      * @return
      */
     public int backPassword(String e_mail,String password);
     
     /**
      * 通过用户名查找用户
      * @param userName
      * @return
      */
     public User findUserByUserName(String userName);
     
     /**
      * 添加用户
      * @param user
      * @return
      */
     public int addUser(String userName,String e_mail,String password);
     
     //修改用户积分
     public int updateIntegralNumber(int userId,int integralNumber);
}
