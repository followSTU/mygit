package com.sx.libarary.dao;

import java.util.List;

import com.sx.libarary.entity.Press;

public interface PressDao {
	Press queryPress(Integer id);

	
	List<Press> queryPresss();
	 
	int updatePress(Press press);
	
	int insertPress(Press press);
	
	int deletePress(Press press);

}
