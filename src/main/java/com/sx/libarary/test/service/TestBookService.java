package com.sx.libarary.test.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.sx.libarary.entity.Book;
import com.sx.libarary.entity.Bookcase;
import com.sx.libarary.entity.Press;
import com.sx.libarary.entity.Type;
import com.sx.libarary.service.BookService;
import com.sx.libarary.service.BookcaseService;
import com.sx.libarary.test.BaseTest;

public class TestBookService extends BaseTest{
	@Autowired
	private BookService BookService; 
	@Autowired
	private BookcaseService BookcaseService;
	@Test
	public void testAddbook(){
		Book book=new Book();
		Type type=new Type();
		Bookcase bookcase=new Bookcase();
		Press press=new Press();
		type.setTypeId(2);bookcase.setBookcaseId(1);press.setPressId(2);
		book.setBookName("有图片的图书");
		book.setBookAuthor("徐宇宁");

	}
	@Test
	public void test(){
//		Integer aInteger=BookcaseService.deleteBookcase(4);
		System.out.println(BookService.getBooks());
	}
}
