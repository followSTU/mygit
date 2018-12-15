package com.sx.libarary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sx.libarary.dao.TypeDao;
import com.sx.libarary.entity.Type;

@Service
public class TypeService {
	@Autowired
	private TypeDao typeDao;
	public List<Type> getTypes(){
		return typeDao.queryTypes();
	}
	
	public Type getType(Integer id){
		return typeDao.queryType(id);
	}
	public int addType(Type type){
		return typeDao.insertType(type);
	}
	
	public int updateType(Type type){
		return typeDao.updateType(type);
	}
	
	public int deleteType(Type type){
		return typeDao.deleteType(type);
	}
}
