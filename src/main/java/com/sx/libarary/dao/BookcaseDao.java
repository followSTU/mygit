package com.sx.libarary.dao;

import java.util.List;

import com.sx.libarary.entity.Bookcase;

public interface BookcaseDao {
	Bookcase queryBookcase(Integer id);
	
	List<Bookcase> queryBookcases();
	
	int updateBookcase(Bookcase bookcase);
	
	int deleteBookcase(Bookcase bookcase);
	
	int insertBookcase(Bookcase bookcase);
	

}
