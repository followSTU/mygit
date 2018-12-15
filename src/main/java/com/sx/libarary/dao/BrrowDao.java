 package com.sx.libarary.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameters;

import com.sx.libarary.entity.Book;
import com.sx.libarary.entity.Brrow;


public interface BrrowDao {
	Brrow queryBrrow(int id);
	
	List<Brrow> queryBrrows();
	
	List<Brrow> queryBrrowBookByParam(@Param("book")Book book);
	
	List<Brrow> queryBrrowsByStatus(Integer status);
	
	List<Brrow> queryBrrowsByUser(String userXuehao);
	
	List<Brrow> queryBrrowBookCount(String userXuehao);
	
	int updateBrrow(Brrow brrow);
	
	int insertBrrow(Brrow brrow);
	
	int deleteBrrow(Brrow brrow);
}
