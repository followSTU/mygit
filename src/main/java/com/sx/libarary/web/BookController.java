package com.sx.libarary.web;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sx.libarary.entity.Book;
import com.sx.libarary.entity.Bookcase;
import com.sx.libarary.entity.Press;
import com.sx.libarary.entity.Type;
import com.sx.libarary.service.BookService;
import com.sx.libarary.service.BookcaseService;
import com.sx.libarary.service.PressService;
import com.sx.libarary.service.TypeService;
import com.sx.libarary.until.BookImageUtil;
import com.sx.libarary.until.CodeUtil;
import com.sx.libarary.until.HttpServletRequestUtil;
import com.sx.libarary.until.Msg;
import com.sx.libarary.until.PathUntil;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

@Controller
public class BookController extends BaseService{
	@ResponseBody
	@RequestMapping(value="/getBooks",method=RequestMethod.GET)
	public Msg getbooks(){
		List<Book> books=bookService.getBooks();
		for(Book book:books){
			Type type=typeService.getType(book.getType().getTypeId());
			Press press=pressService.getPress(book.getPress().getPressId());
			Bookcase bookcase=bookcaseService.getBookcase(book.getBookcase().getBookcaseId());
			book.setPress(press);
			book.setType(type);
			book.setBookcase(bookcase);
		}
		return Msg.success().add("books", books);
	}
	@RequestMapping(value="/addbook",method=RequestMethod.POST)
	@ResponseBody
	public Msg addBook(HttpServletRequest request){
		if(!CodeUtil.checkVerifyCode(request)){
			 return Msg.fail();
		}
		ObjectMapper mapper=new ObjectMapper();
		Book book=null;
		try {
			String bookStr=HttpServletRequestUtil.getString(request, "bookStr");
			book=mapper.readValue(bookStr, Book.class);
			book.setBookStatus(2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MultipartHttpServletRequest multipartRequest = null;
		CommonsMultipartFile bookImg = null;
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		if (multipartResolver.isMultipart(request)) {
			multipartRequest = (MultipartHttpServletRequest) request;
			bookImg = (CommonsMultipartFile) multipartRequest
					.getFile("bookImg");
		}
		bookService.addBook(book, bookImg);
		return Msg.success().add("success",true);
//		book.setBookId(19);
//		String waterPath="H:/photo/water.png";
//		String dest="H:/photo/upload/01.jpg";
//		try {
//			Thumbnails.of(bookImg.getInputStream()).size(400, 400)
//			.watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File(waterPath)),0.5f)
//			.outputQuality(0.8f).toFile(dest);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
}
