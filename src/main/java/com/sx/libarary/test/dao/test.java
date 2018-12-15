package com.sx.libarary.test.dao;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.sx.libarary.dao.BookDao;
import com.sx.libarary.dao.BookcaseDao;
import com.sx.libarary.dao.BrrowDao;
import com.sx.libarary.dao.PressDao;
import com.sx.libarary.dao.QuestionDao;
import com.sx.libarary.dao.RecommendDao;
import com.sx.libarary.dao.TypeDao;
import com.sx.libarary.dao.UserDao;
import com.sx.libarary.dao.UserTypeDao;
import com.sx.libarary.entity.Book;
import com.sx.libarary.entity.Bookcase;
import com.sx.libarary.entity.Brrow;
import com.sx.libarary.entity.Press;
import com.sx.libarary.entity.Question;
import com.sx.libarary.entity.Type;
import com.sx.libarary.entity.User;
import com.sx.libarary.entity.UserType;
import com.sx.libarary.service.BookService;
import com.sx.libarary.service.BrrowService;
import com.sx.libarary.service.TypeService;
import com.sx.libarary.test.BaseTest;

public class test extends BaseTest{
	
	@Autowired
	TypeDao typeDao;
	@Autowired
	BrrowDao BrrowDao;
	@Autowired
	BookcaseDao BookcaseDao;
	@Autowired
	PressDao PressDao;
	@Autowired
	UserDao UserDao;
	@Autowired
	UserTypeDao UserTypeDao;
	@Autowired
	BookDao BookDao;
	@Autowired
	RecommendDao RecommendDao;
	@Autowired
	QuestionDao QuestionDao;
	@Test
	public void testQ(){
//		Bookcase bookcase=new Bookcase();
//		bookcase.setBookcaseName("test12221锟斤拷锟�");
//		bookcase.setBookcaseX("1");
//		bookcase.setBookcaseY("3");
//		bookcase.setBookcaseId(3);
//		BookcaseDao.deleteBookcase(3);
////		BookcaseDao.updateBookcase(bookcase);
////		BookcaseDao.insertBookcase(bookcase);
	System.out.println(BookcaseDao.queryBookcase(1));
	}
	
	@Test
	public void testPress(){
		System.out.println(PressDao.queryPress(1));
//		Press press=new Press();
//		press.setPressName("testtest");
//		press.setPressId(1);
//		PressDao.insertPress(press);
//		PressDao.updatePress(press);
	}
	@Test
	public void testUser(){
//		User user=new User();
//		user.setUserEmail("fdsaf");
//		user.setUserName("test");
//		user.setUserPassword("test");
//		UserDao.insertUser(user);
//		System.out.println(UserDao.queryUsers());
	}
	@Test
	public void testUserQ(){
//		System.out.println(UserDao.queryUsers());
		User user=new User();
		user.setUserGender("0");
		user.setUserName("鍙戠殑鎾�");
		user.setUserEmail("423@qq.com");
		user.setUserRegTime(new Date());
		user.setUserXuehao("23123");
		user.setUserStatus(0);
		user.setUserTypeId(1);
		UserDao.insertUser(user);
	}
	@Test
	public void test(){
		Book book=new Book();
		book.setPressId(2);
		book.setTypeId(2);
		System.out.println(BookDao.queryBooksByParams(book));
	}
	
}
