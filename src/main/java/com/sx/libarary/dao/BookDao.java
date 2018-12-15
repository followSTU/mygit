package com.sx.libarary.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sx.libarary.entity.Book;

public interface BookDao {
	Book queryBook(Integer id);
	
	List<Book> queryBooks();
	
	List<Book> queryBooksByParams(@Param("book")Book book);
	
	
	int updateBook(Book book);
	
	int insertBook(Book book);
	
	int deleteBook(Book book);
	

}
