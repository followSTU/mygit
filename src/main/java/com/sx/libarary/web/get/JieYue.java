package com.sx.libarary.web.get;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sx.libarary.entity.Book;
import com.sx.libarary.entity.Brrow;
import com.sx.libarary.entity.User;
import com.sx.libarary.until.HttpServletRequestUtil;
import com.sx.libarary.until.Msg;
import com.sx.libarary.web.BaseService;

@Controller
public class JieYue extends BaseService{
	@RequestMapping(value="/getBrrowByXuehao/{userXuehao}",method=RequestMethod.POST)
	@ResponseBody
	public Msg getBrrow(@PathVariable("userXuehao") String userXuehao){
		List<Brrow> brrows = brrowService.getBrrowByUser(userXuehao);
		int bookNum=brrowService.queryBrrowBookCount(userXuehao);
		if(brrows.size()!=0){
			return Msg.success().add("brrows", brrows);
		}else{
			return Msg.success().add("error", "用户为空！");
		}
	}
	@ResponseBody
	@RequestMapping(value="/jieshu",method=RequestMethod.POST)
	public Msg addJieShu(HttpServletRequest request){
		ObjectMapper mapper=new ObjectMapper();
		String brrowStr=HttpServletRequestUtil.getString(request, "brrowStr");
		String days=HttpServletRequestUtil.getString(request, "days");
		try {
			//更新借阅表里的状态
			Brrow brrow=mapper.readValue(brrowStr, Brrow.class);
			Date now=new Date();
			Calendar calendar=Calendar.getInstance();
			brrow.setBrrowBookJieshu(now);
			calendar.setTime(now);
			calendar.add(Calendar.DATE, Integer.parseInt(days));
			brrow.setBrrowBookHuanshu(calendar.getTime());
			brrow.setBrrowBookStatus("1");
			brrowService.addBrrow(brrow);
			//更新图书表里的状态
			Book book=bookService.getBook(brrow.getBrrowBookId());
			book.setBookStatus(1);
			System.out.println(book);
			bookService.updateBook(book);
			return Msg.success().add("success", true);
		} catch (Exception e) {
			return Msg.fail().add("success", false);
		}
	}
	@ResponseBody
	@RequestMapping(value="/xujie/{brrowId}",method=RequestMethod.POST)
	public Msg xuJIe(@PathVariable("brrowId")Integer brrowId){
		Date now=new Date();
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(now);
		calendar.add(Calendar.DATE, 30);
		Brrow brrow=brrowService.getBrrow(brrowId);
		brrow.setBrrowBookHuanshu(calendar.getTime());
		brrowService.updateBrrow(brrow);
		return Msg.success().add("success", true);
	}
	
	@ResponseBody
	@RequestMapping(value="/huanshu",method=RequestMethod.POST)
	public Msg huanShu(HttpServletRequest request){
		String bookId=HttpServletRequestUtil.getString(request, "bookId");
		String brrowId=HttpServletRequestUtil.getString(request, "brrowId");
		Book book=bookService.getBook(Integer.parseInt(bookId));
		book.setBookStatus(2);
		Brrow brrow=brrowService.getBrrow(Integer.parseInt(brrowId));
		brrow.setBrrowBookStatus("2");
		brrow.setBrrowBookHuanshu(new Date());
		bookService.updateBook(book);
		brrowService.updateBrrow(brrow);
		return Msg.success().add("success", true);
		
	}
}
