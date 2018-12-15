package com.sx.libarary.dao;

import java.util.List;

import com.sx.libarary.entity.Type;

public interface TypeDao {
	
	Type queryType(int id);
	
	List<Type> queryTypes();
	
	int insertType(Type type);
	
	int deleteType(Type type);
	
	int updateType(Type type);
}
