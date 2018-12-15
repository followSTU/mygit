package com.sx.libarary.test.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sx.libarary.dao.BookDao;
import com.sx.libarary.entity.Book;
import com.sx.libarary.entity.Bookcase;
import com.sx.libarary.entity.Press;
import com.sx.libarary.entity.Type;
import com.sx.libarary.test.BaseTest;

public class TestBookDao extends BaseTest{
	@Autowired
	private BookDao bookDao;
	@Test
	public void testQuery(){
//		List<Bookcase> list=new ArrayList<>();
//		list.add(bookDao.queryBooks().get(0).getBookcase());
//		list.add(bookDao.queryBooks().get(1).getBookcase());
//		System.out.println(list.get(0).getBookcaseId()+"dd"+list.get(1).getBookcaseId());
		System.out.println(bookDao.queryBooks());
	}
	@Test
	public void testInsert(){
		Type type=new Type();
		Bookcase bookcase=new Bookcase();
		Press press=new Press();
		type.setTypeId(1);bookcase.setBookcaseId(1);press.setPressId(1);
		Book book=new Book();
		book.setType(type);book.setPress(press);book.setBookcase(bookcase);
		book.setBookName("test2�鼮");
		book.setBookPrice(35.0);
		book.setBookId(3);
		bookDao.updateBook(book);
	}
	@Test
	public void testDelete(){
		
	}
}
