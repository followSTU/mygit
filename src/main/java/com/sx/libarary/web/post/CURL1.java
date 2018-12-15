package com.sx.libarary.web.post;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sx.libarary.entity.Book;
import com.sx.libarary.entity.Bookcase;
import com.sx.libarary.entity.Press;
import com.sx.libarary.entity.Type;
import com.sx.libarary.entity.User;
import com.sx.libarary.service.BookService;
import com.sx.libarary.service.BookcaseService;
import com.sx.libarary.service.PressService;
import com.sx.libarary.service.TypeService;
import com.sx.libarary.until.HttpServletRequestUtil;
import com.sx.libarary.until.Msg;
import com.sx.libarary.web.BaseService;

@Controller
public class CURL1 extends BaseService{
	@ResponseBody
	@RequestMapping(value="/deletepress/{id}",method=RequestMethod.DELETE)
	public Msg deletePress(@PathVariable("id")Integer id){
		Press press=pressService.getPress(id);
		press.setCode(1);
		pressService.deletePress(press);
		return Msg.success().add("success", true);
	}
	@ResponseBody
	@RequestMapping(value="/deletebookcase/{id}",method=RequestMethod.DELETE)
	public Msg deleteBookcase(@PathVariable("id")Integer id){
		Bookcase bookcase=bookcaseService.getBookcase(id);
		bookcase.setCode(1);
		bookcaseService.deleteBookcase(bookcase);
		return Msg.success().add("success", true);
	}
	@ResponseBody
	@RequestMapping(value="/deletebook/{id}",method=RequestMethod.DELETE)
	public Msg deleteBook(@PathVariable("id")Integer id){
		Book book=bookService.getBook(id);
		book.setCode(1);
		bookService.deleteBook(book);
		return Msg.success().add("success", true);
	}
	@ResponseBody
	@RequestMapping(value="/deletetype/{id}",method=RequestMethod.DELETE)
	public Msg deleteType(@PathVariable("id")Integer id){
		Type type=typeService.getType(id);
		type.setCode(1);
		typeService.deleteType(type);
		return Msg.success().add("success", true);
	}
	
	//做更新
	@ResponseBody
	@RequestMapping(value="/updatepress",method=RequestMethod.POST)
	public Msg updatePress(HttpServletRequest request){
		ObjectMapper mapper=new ObjectMapper();
		String pressStr=HttpServletRequestUtil.getString(request, "pressStr");
		try {
			Press press=mapper.readValue(pressStr, Press.class);
			pressService.updatePress(press);
			return Msg.success().add("success", true);
		} catch (Exception e) {
			return null;
		}
		
	}
	@ResponseBody
	@RequestMapping(value="/deleteuser/{id}",method=RequestMethod.DELETE)
	public Msg deleteUser(@PathVariable("id")Integer id){
		User user=userService.getUser(id);
		user.setCode(1);
		userService.deleteUser(user);
		return Msg.success().add("success", true);
	}
	
	
}
