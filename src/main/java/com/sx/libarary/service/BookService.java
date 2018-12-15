package com.sx.libarary.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.sx.libarary.dao.BookDao;
import com.sx.libarary.entity.Book;
import com.sx.libarary.until.BookImageUtil;
import com.sx.libarary.until.PathUntil;


@Service
public class BookService {
	@Autowired
	private BookDao bookDao;
	public List<Book> getBooks(){
		return bookDao.queryBooks();
	}
	
	public Book getBook(Integer id){
		return bookDao.queryBook(id);
	}
	@Transactional
	public void addBook(Book book,CommonsMultipartFile bookImg) {
		bookDao.insertBook(book);
		addBookImg(book,bookImg);
		bookDao.updateBook(book);
	}
	

	private void addBookImg(Book book, CommonsMultipartFile bookImg)  {
		String bookaddr1=PathUntil.getBookImage(book.getBookId());
		try {
			String bookaddr2 = BookImageUtil.generateThumbnail(bookImg, bookaddr1);
			book.setBookImgAddr(bookaddr2);

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	public List<Book> getBookByParams(Book book){
		return bookDao.queryBooksByParams(book);
	}
	public int updateBook(Book book){
		return bookDao.updateBook(book);
	}
	
	public int deleteBook(Book book){
		return bookDao.deleteBook(book);
	}
}
