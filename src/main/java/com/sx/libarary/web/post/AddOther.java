package com.sx.libarary.web.post;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sx.libarary.entity.Bookcase;
import com.sx.libarary.entity.Press;
import com.sx.libarary.entity.Type;
import com.sx.libarary.until.HttpServletRequestUtil;
import com.sx.libarary.until.Msg;
import com.sx.libarary.web.BaseService;

@Controller
public class AddOther extends BaseService{
	@ResponseBody
	@RequestMapping(value="/addbookcase",method=RequestMethod.POST)
	public Msg addBookcase(HttpServletRequest request){
		ObjectMapper mapper=new ObjectMapper();
		String bookcaseStr=HttpServletRequestUtil.getString(request, "bookcaseStr");
		try {
			Bookcase bookcase=mapper.readValue(bookcaseStr, Bookcase.class);
			bookcaseService.addBookcase(bookcase);
			return Msg.success().add("success", true);
		} catch (Exception e) {
			return Msg.fail().add("success", false);
		}
	}
	@ResponseBody
	@RequestMapping(value="/addpress",method=RequestMethod.POST)
	public Msg addPress(HttpServletRequest request){
		ObjectMapper mapper=new ObjectMapper();
		String pressStr=HttpServletRequestUtil.getString(request, "pressStr");
		try {
			Press press=mapper.readValue(pressStr, Press.class);
			pressService.addPress(press);
			return Msg.success().add("success", true);
		} catch (Exception e) {
			return Msg.fail().add("success", false);
		}
	}
	@ResponseBody
	@RequestMapping(value="/addtype",method=RequestMethod.POST)
	public Msg addType(HttpServletRequest request){
		ObjectMapper mapper=new ObjectMapper();
		String typeStr=HttpServletRequestUtil.getString(request, "typeStr");
		try {
			Type type=mapper.readValue(typeStr, Type.class);
			typeService.addType(type);
			return Msg.success().add("success", true);
		} catch (Exception e) {
			return Msg.fail().add("success", false);
		}
	}
}
