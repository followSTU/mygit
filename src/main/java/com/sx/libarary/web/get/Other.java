package com.sx.libarary.web.get;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sx.libarary.entity.Book;
import com.sx.libarary.entity.Bookcase;
import com.sx.libarary.entity.Brrow;
import com.sx.libarary.entity.Press;
import com.sx.libarary.entity.Type;
import com.sx.libarary.entity.User;
import com.sx.libarary.entity.UserType;
import com.sx.libarary.service.BookService;
import com.sx.libarary.service.BookcaseService;
import com.sx.libarary.service.BrrowService;
import com.sx.libarary.service.PressService;
import com.sx.libarary.service.TypeService;
import com.sx.libarary.service.UserService;
import com.sx.libarary.service.UserTypeService;
import com.sx.libarary.until.HttpServletRequestUtil;
import com.sx.libarary.until.Msg;
import com.sx.libarary.web.BaseService;

@Controller
public class Other{
	@Autowired
	private UserTypeService userTypeService;
	@Autowired
	private BookService BookService;
	@Autowired
	private BookcaseService BookcaseService;
	@Autowired
	private PressService pressService;
	@Autowired
	private TypeService typeService;
	@Autowired
	private BrrowService BrrowService;
	@Autowired
	private UserService UserService;
	//拿到不同的图书数据,0预约中的图书，1借阅中，2已归还 ,3拿到所有状态的图书
	@RequestMapping(value="/getbook0",method=RequestMethod.GET)
	@ResponseBody
	public Msg getBook0(){
		List<Brrow> brrows=BrrowService.getBrrowByStatus(0);
		for(Brrow brrow:brrows){
			User user=UserService.getUser(brrow.getBrrowBookUser());
			Book book=BookService.getBook(brrow.getBrrowBookId());
			brrow.setUser(user);
			brrow.setBook(book);
		}
		return Msg.success().add("books", brrows);
	}
	@RequestMapping(value="/getbook1",method=RequestMethod.GET)
	@ResponseBody
	public Msg getBook1(){
		List<Brrow> brrows=BrrowService.getBrrowByStatus(1);
		for(Brrow brrow:brrows){
			User user=UserService.getUser(brrow.getBrrowBookUser());
			Book book=BookService.getBook(brrow.getBrrowBookId());
			brrow.setUser(user);
			brrow.setBook(book);
		}
		return Msg.success().add("books", brrows);
	}
	@RequestMapping(value="/getbook2",method=RequestMethod.GET)
	@ResponseBody
	public Msg getBook2(){
		List<Brrow> brrows=BrrowService.getBrrowByStatus(2);
		for(Brrow brrow:brrows){
			User user=UserService.getUser(brrow.getBrrowBookUser());
			Book book=BookService.getBook(brrow.getBrrowBookId());
			brrow.setUser(user);
			brrow.setBook(book);
		}
		return Msg.success().add("books", brrows);
	}
	@RequestMapping(value="/getbook3",method=RequestMethod.GET)
	@ResponseBody
	public Msg getBook3(){
		List<Book> books=BookService.getBooks();
		System.out.println(books.size());
		for(Book book1:books){
			Bookcase bookcase=BookcaseService.getBookcase(book1.getBookcase().getBookcaseId());
			Type type=typeService.getType(book1.getType().getTypeId());
			Press press=pressService.getPress(book1.getPress().getPressId());
			book1.setBookcase(bookcase);
			book1.setPress(press);
			book1.setType(type);
		}
		return Msg.success().add("books", books);
	}
	
	@RequestMapping(value="/getbookbyparams",method=RequestMethod.POST)
	@ResponseBody
	public Msg getBook4(HttpServletRequest request){
		ObjectMapper mapper=new ObjectMapper();
		String bookParam=HttpServletRequestUtil.getString(request, "bookParam");
		try {
			Book book=mapper.readValue(bookParam, Book.class);
			List<Book> books=BookService.getBookByParams(book);
			for(Book book1:books){
				Integer bookStatus=book1.getBookStatus();
				Bookcase bookcase=BookcaseService.getBookcase(book1.getBookcase().getBookcaseId());
				Type type=typeService.getType(book1.getType().getTypeId());
				Press press=pressService.getPress(book1.getPress().getPressId());
				book1.setBookcase(bookcase);
				book1.setPress(press);
				book1.setType(type);
			}
			return Msg.success().add("books", books);
		} catch (Exception e) {
			return Msg.fail();
		}
	}
	
	@RequestMapping(value="/getbrrowbyparam",method=RequestMethod.POST)
	@ResponseBody
	public Msg getbrrowbyparam(HttpServletRequest request){
		ObjectMapper mapper=new ObjectMapper();
		String bookParam=HttpServletRequestUtil.getString(request, "bookParam");
		try {
			Book book=mapper.readValue(bookParam, Book.class);
			List<Brrow> brrows=BrrowService.getBrrowBookByParam(book);
			return Msg.success().add("books", brrows);
		} catch (Exception e) {
			return Msg.fail();
		}
	}
	
	@RequestMapping(value="/getbook5",method=RequestMethod.POST)
	@ResponseBody
	public Msg getBook5(){
		List<Brrow> brrows=BrrowService.getBrrowByStatus(2);
		for(Brrow brrow:brrows){
			User user=UserService.getUser(brrow.getBrrowBookUser());
			Book book=BookService.getBook(brrow.getBrrowBookId());
			brrow.setUser(user);
			brrow.setBook(book);
		}
		return Msg.success().add("books", brrows);
	}
	//拿到已归还的图书的12条数据
	@ResponseBody
	@RequestMapping(value="/getbook6",method=RequestMethod.GET)
	public Msg getBook6(){
		return null;
	}

}
