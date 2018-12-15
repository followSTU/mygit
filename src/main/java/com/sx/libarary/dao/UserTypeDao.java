package com.sx.libarary.dao;

import java.util.List;

import com.sx.libarary.entity.Type;
import com.sx.libarary.entity.UserType;

public interface UserTypeDao {
	
	UserType queryUserType(int id);
	
	List<UserType> queryUserTypes();
	
	int updateUserType(UserType userType);
	
	int deleteUserType(UserType userType);
	
	int insertUserType(Type type);
}
