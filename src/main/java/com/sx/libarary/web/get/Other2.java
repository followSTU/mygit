package com.sx.libarary.web.get;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sx.libarary.entity.Bookcase;
import com.sx.libarary.entity.Press;
import com.sx.libarary.entity.Question;
import com.sx.libarary.entity.Recommend;
import com.sx.libarary.entity.Type;
import com.sx.libarary.entity.User;
import com.sx.libarary.service.BookService;
import com.sx.libarary.service.BookcaseService;
import com.sx.libarary.service.PressService;
import com.sx.libarary.service.QuestionService;
import com.sx.libarary.service.TypeService;
import com.sx.libarary.service.UserService;
import com.sx.libarary.until.Msg;
import com.sx.libarary.web.BaseService;

@Controller
public class Other2 extends BaseService{
	//1拿到所有类型的信息
	@RequestMapping(value="/getbookcase",method=RequestMethod.GET)
	@ResponseBody
	public Msg getBookcase(){
		List<Bookcase> bookcases=bookcaseService.getBookcases();
		return Msg.success().add("bookcases", bookcases);
	}
	
	@RequestMapping(value="/gettype",method=RequestMethod.GET)
	@ResponseBody
	public Msg getType(){
		List<Type> types=typeService.getTypes();
		return Msg.success().add("types", types);
	}
	@RequestMapping(value="/getpress",method=RequestMethod.GET)
	@ResponseBody
	public Msg getPress(){
		List<Press> presses=pressService.getPresss();
		return Msg.success().add("presses", presses);
	}
	
	@RequestMapping(value="/getrecommends",method=RequestMethod.GET)
	@ResponseBody
	public Msg getRecommends(){
		List<Recommend> recommends=recommendService.getRecommends();
		for(Recommend recommend:recommends){
			User user=userService.getUser(recommend.getRecommendUserId());
			recommend.setUser(user);
		}
		return Msg.success().add("recommends", recommends);
	}
	
	@RequestMapping(value="/getquestions",method=RequestMethod.GET)
	@ResponseBody
	public Msg getQuestions(){
		List<Question> questions=questionService.getQuestions();
		for(Question question:questions){
			User user=userService.getUser(question.getQuestionUserId());
			question.setUser(user);
		}
		return Msg.success().add("questions", questions);
	}
	
	@ResponseBody
	@RequestMapping(value="/deletequestion/{id}",method=RequestMethod.DELETE)
	public Msg deleteBookcase(@PathVariable("id")Integer id){
		Question question=questionService.getQuestion(id);
		question.setCode(1);
		questionService.deleteQuestion(question);
		return Msg.success().add("success", true);
	}
	
	//根据id拿到取得相应的实体
		@RequestMapping(value="/getbookcasebyid/{id}",method=RequestMethod.GET)
		@ResponseBody
		public Msg getBookcaseById(@PathVariable("id")Integer id){
			Bookcase bookcase=bookcaseService.getBookcase(id);
			return Msg.success().add("bookcase", bookcase);
		}
		
		@RequestMapping(value="/gettypebyid/{id}",method=RequestMethod.GET)
		@ResponseBody
		public Msg getTypeById(@PathVariable("id")Integer id){
			Type type=typeService.getType(id);
			return Msg.success().add("type", type);
		}
		@RequestMapping(value="/getpressbyid/{id}",method=RequestMethod.GET)
		@ResponseBody
		public Msg getPressById(@PathVariable("id")Integer id){
			Press press=pressService.getPress(id);
			return Msg.success().add("press", press);
		}
	
	
	
}
