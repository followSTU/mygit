package com.sx.libarary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sx.libarary.dao.QuestionDao;
import com.sx.libarary.entity.Question;

@Service
public class QuestionService {
	@Autowired
	private QuestionDao questionDao;
	public List<Question> getQuestions(){
		return questionDao.queryQuestions();
	}
	
	public Question getQuestion(Integer id){
		return questionDao.queryQuestion(id);
	}
	public int addQuestion(Question question){
		return questionDao.insertQuestion(question);
	}
	
	public int updateQuestion(Question question){
		return questionDao.updateQuestion(question);
	}
	
	public int deleteQuestion(Question question){
		return questionDao.deleteQuestion(question);
	}
}
