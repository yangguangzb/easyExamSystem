package com.san.dao;
import java.sql.SQLException;
import com.san.model.User;
public interface UserDao {
	public User loginVerification(String userName,String password) throws SQLException;
	public void addIntegralNumber(User user,int IntegralNumber);//增加积分
    public void minusIntegralNumber(User user,int IntegralNumber);//减少积分
	public void updateUserByPassword(User user);//通过密码更新用户信息
    public User getUser(int userId);
    /**
     * 找回密码
     * @param e_mail
     * @param password
     * @return
     */
    public int backPassword(String e_mail,String password) throws SQLException;
    
    /**
     * 通过用户名查找用户
     * @param userName
     * @return
     */
    public User findUserByUserName(String userName);
    
    /**
     * 验证邮箱是否有效
     * @param e_mail
     * @return
     */
    public int isE_mail(String e_mail);
    
    /**
     * 添加用户
     * @param user
     * @return
     */
    public int save(String userName,String e_mail,String password);
	
}
