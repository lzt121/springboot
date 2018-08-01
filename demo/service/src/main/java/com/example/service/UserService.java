package com.example.service;

import org.springframework.transaction.annotation.Transactional;

import com.example.entity.User;
@Transactional
public interface UserService {
	
	public boolean addUser(String username, String password);
	public User addUserWithBackId(String loginname, String password);
	public User selectUser(int id);
}
