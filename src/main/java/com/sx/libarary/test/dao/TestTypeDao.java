package com.sx.libarary.test.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sx.libarary.dao.BookcaseDao;
import com.sx.libarary.dao.PressDao;
import com.sx.libarary.dao.TypeDao;
import com.sx.libarary.entity.Bookcase;
import com.sx.libarary.entity.Type;
import com.sx.libarary.test.BaseTest;

public class TestTypeDao extends BaseTest{
	@Autowired
	private TypeDao typeDao;
	@Autowired
	private PressDao pressDao;
	@Autowired
	private BookcaseDao bookcaseDao;
	@Test
	public void testTypeDao(){
//		System.out.println(typeDao.queryType(1).toString());
//		System.out.println(pressDao.queryPress(1).toString());
//		System.out.println(bookcaseDao.queryBookcase(1));
		System.out.println(typeDao.queryTypes());
	}
	@Test
	public void insert(){
		Type type=new Type();
		type.setTypeName("testtype");
		type.setTypeSecondName("sectest");
		typeDao.insertType(type);
	}
	@Test
	public void update(){
		Type type=new Type();
		type.setTypeId(3);
		type.setTypeName("testtypemod");
		type.setTypeSecondName("sectestmod");
		typeDao.updateType(type);
	}
	@Test
	public void delete(){
		
	}
}
