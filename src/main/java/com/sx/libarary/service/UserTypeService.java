package com.sx.libarary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sx.libarary.dao.UserTypeDao;
import com.sx.libarary.entity.*;

@Service
public class UserTypeService {
	@Autowired
	private UserTypeDao userTypeDao;
	
	public List<UserType> getUserTypes(){
		return userTypeDao.queryUserTypes();
	}
	
	public UserType getUserType(Integer id){
		return userTypeDao.queryUserType(id);
	}
	
	public int updateUserType(UserType userType){
		return userTypeDao.updateUserType(userType);
	}
	public int deleteUserType(UserType userType){
		return userTypeDao.deleteUserType(userType);
	}
	
}
