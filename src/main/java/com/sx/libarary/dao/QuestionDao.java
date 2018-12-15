package com.sx.libarary.dao;

import java.util.List;
import com.sx.libarary.entity.Question;

public interface QuestionDao {
	Question queryQuestion(Integer id);
	
	List<Question> queryQuestions();
	
	int updateQuestion(Question question);
	
	int deleteQuestion(Question question);
	
	int insertQuestion(Question question);
}
