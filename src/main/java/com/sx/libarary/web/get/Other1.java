package com.sx.libarary.web.get;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sx.libarary.entity.Type;
import com.sx.libarary.entity.User;
import com.sx.libarary.entity.UserType;
import com.sx.libarary.service.UserService;
import com.sx.libarary.until.HttpServletRequestUtil;
import com.sx.libarary.until.Msg;
import com.sx.libarary.web.BaseService;

@Controller
public class Other1 extends BaseService{
	
	@RequestMapping(value="/getusers1",method=RequestMethod.GET)
	@ResponseBody
	public Msg getUsers1(){
		User user=new User();
		user.setUserStatus(0);
		List<User> users=userService.getUserByParams(user);
		return Msg.success().add("users", users);
	}
	
	@RequestMapping(value="/getusers2",method=RequestMethod.GET)
	@ResponseBody
	public Msg getUsers2(){
		List<User> users=userService.getUsers();
		return Msg.success().add("users", users);
	}
	@RequestMapping(value="/getusers3",method=RequestMethod.GET)
	@ResponseBody
	public Msg getUsers3(){
		User user=new User();
		user.setUserStatus(1);
		List<User> users=userService.getUserByParams(user);
		return Msg.success().add("users", users);
	}
	@RequestMapping(value="/getuser4",method=RequestMethod.POST)
	@ResponseBody
	public Msg getUserForJie(HttpServletRequest request){
		ObjectMapper mapper=new ObjectMapper();
		String userStr=HttpServletRequestUtil.getString(request, "userStr");
		User user=null;
		try {
			user=mapper.readValue(userStr, User.class);
		} catch (Exception e) {
			// TODO: handle exception
		}
		List<User> users=userService.getUserByParams(user);
		if(users.size()==1){
			User tempUser=users.get(0);
			System.out.println(tempUser.getUserType().getUserTypeId());
			UserType userType=userTypeService.getUserType(tempUser.getUserType().getUserTypeId());
			tempUser.setUserType(userType);
			int bookNum=brrowService.queryBrrowBookCount(tempUser.getUserXuehao());
			return Msg.success().add("user", tempUser).add("bookNum", bookNum);
		}else{
			return Msg.fail().add("user", "用户不存在！！");
		}
	}
}
