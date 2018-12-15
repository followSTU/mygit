package com.sx.libarary.web.post;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sx.libarary.entity.Question;
import com.sx.libarary.entity.Recommend;
import com.sx.libarary.entity.User;
import com.sx.libarary.until.HttpServletRequestUtil;
import com.sx.libarary.until.Msg;
import com.sx.libarary.web.BaseService;

@Controller
public class ShenHe extends BaseService{
	@ResponseBody
	@RequestMapping(value="/questionshenhe",method=RequestMethod.POST)
	public Msg questionShenHe(HttpServletRequest request ){
		String questionId=HttpServletRequestUtil.getString(request, "questionId");
		String biaoshi=HttpServletRequestUtil.getString(request, "biaoshi");
		Question question=questionService.getQuestion(Integer.parseInt(questionId));
		if(biaoshi.equals("1")){
			question.setQuestionStatus("1");
			questionService.updateQuestion(question);
			return Msg.success().add("success", true);
		}else{
			question.setQuestionStatus("2");
			questionService.updateQuestion(question);
			return Msg.success().add("success", true);
		
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/recommendshenhe",method=RequestMethod.POST)
	public Msg recommendShenHe(HttpServletRequest request ){
		String recommendId=HttpServletRequestUtil.getString(request, "recommendId");
		String biaoshi=HttpServletRequestUtil.getString(request, "biaoshi");
		Recommend recommend=recommendService.getRecommend(Integer.parseInt(recommendId));
		if(biaoshi.equals("1")){
			recommend.setRecommendBookStatus("1");
			recommendService.updateRecommend(recommend);
			return Msg.success().add("success", true);
		}else{
			recommend.setRecommendBookStatus("2");
			recommendService.updateRecommend(recommend);
			return Msg.success().add("success", true);
		
		}
	}
}
