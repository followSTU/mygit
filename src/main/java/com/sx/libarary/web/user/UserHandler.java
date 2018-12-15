package com.sx.libarary.web.user;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sx.libarary.entity.User;
import com.sx.libarary.service.UserService;
import com.sx.libarary.until.CodeUtil;
import com.sx.libarary.until.HttpServletRequestUtil;
import com.sx.libarary.until.Msg;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
public class UserHandler {
	@Autowired
	private UserService userService;
	@ResponseBody
	@RequestMapping(value="/adduser",method=RequestMethod.POST)
	public Msg doRegister(HttpServletRequest request){
		ObjectMapper mapper=new ObjectMapper();
		if(!CodeUtil.checkVerifyCode(request)){
			return Msg.fail().add("error1","验证码错误！！");
		}
		String userstr=HttpServletRequestUtil.getString(request, "userStr");
		try {
			User user=mapper.readValue(userstr, User.class);
			if(user==null){
				return Msg.fail().add("error2", "用户为空！！");
			}else{
				user.setUserRegTime(new Date());
				user.setUserStatus(0);
				Integer aInteger= userService.addUser(user);
				
				if(aInteger!=0){
					return Msg.success().add("success",true);
				}else{
					return Msg.fail().add("success",false);
				}
			}
		} catch (Exception e) {
			return Msg.fail();
		} 
	}
	@RequestMapping(value="/dologin",method=RequestMethod.POST)
	@ResponseBody
	public Msg doLogin(HttpServletRequest request){
		HttpSession session = request.getSession(true);
		ObjectMapper mapper=new ObjectMapper();
		if(!CodeUtil.checkVerifyCode(request)){
			return Msg.fail().add("error","验证码错误");
		}
		String userstr=HttpServletRequestUtil.getString(request, "userStr");
		try {
			User user=mapper.readValue(userstr, User.class);
			List<User> users=userService.getUserByParams(user);
			if(users.size()==1){
				User user1=users.get(0);
				if(user1.getUserStatus()!=1){
					return Msg.fail().add("error","请等待审核");
				}else{
					session.setAttribute("user", user1);
					return Msg.success().add("success", true);
				}
				
			}else{
				return Msg.fail().add("error", "用户名或者密码错误");
			}
		} catch (Exception e) {
			return null;
		}
	}
	@ResponseBody
	@RequestMapping(value="/shenghe",method=RequestMethod.POST)
	public Msg doShenHe(HttpServletRequest request){
		String userId=HttpServletRequestUtil.getString(request, "userId");
		String biaoshi=HttpServletRequestUtil.getString(request, "biaoshi");
		User user=userService.getUser(Integer.parseInt(userId));
		if(biaoshi.equals("1")){
			user.setUserStatus(1);
			userService.updateUser(user);
			return Msg.success().add("success", true);
		}else{
			user.setUserStatus(2);
			userService.updateUser(user);
			return Msg.success().add("success", true);
		}
	}
}
