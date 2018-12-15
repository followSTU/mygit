package com.sx.libarary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sx.libarary.entity.Book;
import com.sx.libarary.entity.Brrow;
import com.sx.libarary.dao.BrrowDao;

@Service
public class BrrowService {
	@Autowired
	private BrrowDao brrowDao;
	public List<Brrow> getBrrows(){
		return brrowDao.queryBrrows();
	}
	
	public List<Brrow> getBrrowBookByParam(Book book){
		return brrowDao.queryBrrowBookByParam(book);
	}
	
	public Brrow getBrrow(Integer id){
		return brrowDao.queryBrrow(id);
	}
	
	public List<Brrow> getBrrowByStatus(Integer status){
		return brrowDao.queryBrrowsByStatus(status);
	}
	
	public List<Brrow> getBrrowByUser(String userXuehao){
		return brrowDao.queryBrrowsByUser(userXuehao);
	}
	
	public int addBrrow(Brrow brrow){
		return brrowDao.insertBrrow(brrow);
	}
	
	public int updateBrrow(Brrow brrow){
		return brrowDao.updateBrrow(brrow);
	}
	
	public int deleteBrrow(Brrow brrow){
		return brrowDao.deleteBrrow(brrow);
	}
	
	public int queryBrrowBookCount(String userXuehao){
		return brrowDao.queryBrrowBookCount(userXuehao).size();
	}
}
