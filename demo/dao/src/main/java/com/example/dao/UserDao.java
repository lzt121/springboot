package com.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.entity.User;
import com.example.mapper.UserMapper;

@Mapper
@Repository
public class UserDao {
	 	@Autowired
	    private UserMapper userMapper;
	    
	    public int insertUser(String loginName, String password){
	        return userMapper.insertUser(loginName, password);
	    }
	    
	    public int insertUserWithBackId(User user){    
	        return userMapper.insertUserWithBackId(user);
	    }
	    
	    public User selectUserById(int id){    
	        return userMapper.selectUserById(id);
	    }
	    public int deleteByPrimaryKey(int id){    
	    	return userMapper.deleteByPrimaryKey(id);
	    }
	    public int updateByPrimaryKey(User user){    
	    	return userMapper.updateByPrimaryKey(user);
	    }
}