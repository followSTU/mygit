package com.sx.libarary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sx.libarary.dao.UserDao;
import com.sx.libarary.entity.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	public User getUser(Integer id){
		return userDao.queryUser(id);
	}
	public int addUser(User user){
		return userDao.insertUser(user);
	}
	
	public List<User> getUserByParams(User user){
		return userDao.queryUserByParams(user);
	}
	public List<User> getUsers(){
		return userDao.queryUsers();
	}
	public int deleteUser(User user){
		return userDao.deleteUser(user);
	}
	public int updateUser(User user){
		return userDao.updateUser(user);
	}
}
