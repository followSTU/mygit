package com.sx.libarary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sx.libarary.dao.BookcaseDao;
import com.sx.libarary.entity.Bookcase;

@Service
public class BookcaseService {
	@Autowired
	private BookcaseDao bookcaseDao;
	public List<Bookcase> getBookcases(){
		return bookcaseDao.queryBookcases();
	}
	
	public Bookcase getBookcase(Integer id){
		return bookcaseDao.queryBookcase(id);
	}
	public int  addBookcase(Bookcase bookcase){
		return bookcaseDao.insertBookcase(bookcase);
	}
	
	public int updateBookcase(Bookcase bookcase){
		return bookcaseDao.updateBookcase(bookcase);
	}
	
	public int deleteBookcase(Bookcase bookcase){
		return bookcaseDao.deleteBookcase(bookcase);
	}
}
