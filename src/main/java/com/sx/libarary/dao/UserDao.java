package com.sx.libarary.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sx.libarary.entity.User;


public interface UserDao {

		User queryUser(int id);
		
		List<User> queryUsers();
		
		List<User> queryUserByParams(@Param("user")User user);
		
		int insertUser(User User);
		
		int deleteUser(User User);
		
		int updateUser(User User);
}
