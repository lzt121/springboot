package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.entity.User;
import com.example.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	@Autowired
    private UserDao userDao;
    @Override
    public boolean addUser(String username, String password){
        return userDao.insertUser(username, password)==1?true:false;
    }
    @Override
    public User addUserWithBackId(String loginname, String password){
    	User user = new User();
        user.setLoginName(loginname);
        user.setPassword(password);
        //该方法后，主键已经设置到user中了
        userDao.insertUserWithBackId(user);
        return user;
    }

	@Override
	public User selectUser(int id) {
		return userDao.selectUserById(id);
	}
	public int deleteByPrimaryKey(int id) {
		return userDao.deleteByPrimaryKey(id);
	}
	public int updateByPrimaryKey(User user) {
		return userDao.updateByPrimaryKey(user);
	}

}
