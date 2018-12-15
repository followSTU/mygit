package com.sx.libarary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sx.libarary.dao.PressDao;
import com.sx.libarary.entity.Press;

@Service
public class PressService {
	@Autowired
	private PressDao pressDao;
	public List<Press> getPresss(){
		return pressDao.queryPresss();
	}
	
	public Press getPress(Integer id){
		return pressDao.queryPress(id);
	}
	public int addPress(Press press){
		return pressDao.insertPress(press);
	}
	
	public int updatePress(Press press){
		return pressDao.updatePress(press);
	}
	
	public int deletePress(Press press){
		return pressDao.deletePress(press);
	}
}
