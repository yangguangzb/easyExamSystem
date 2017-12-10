package com.san.service.Impl;

import com.san.dao.Impl.UserDaoImpl;
import com.san.dao.UserDao;
import com.san.model.User;
import com.san.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void updateUserByPassword(User user) {
        UserDao userDao =new UserDaoImpl();
        userDao.updateUserByPassword(user);
    }
}
