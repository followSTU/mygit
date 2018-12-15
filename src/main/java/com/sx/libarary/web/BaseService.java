package com.sx.libarary.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.sx.libarary.service.BookService;
import com.sx.libarary.service.BookcaseService;
import com.sx.libarary.service.BrrowService;
import com.sx.libarary.service.PressService;
import com.sx.libarary.service.QuestionService;
import com.sx.libarary.service.RecommendService;
import com.sx.libarary.service.TypeService;
import com.sx.libarary.service.UserService;
import com.sx.libarary.service.UserTypeService;

@ContextConfiguration({"classpath:spring/spring-service.xml"})
public class BaseService {
	@Autowired
	public BookcaseService bookcaseService;
	@Autowired
	public PressService pressService;
	@Autowired
	public TypeService typeService;
	@Autowired
	public RecommendService recommendService;
	@Autowired
	public UserService userService;
	@Autowired
	public BookService bookService;
	@Autowired
	public UserTypeService userTypeService;
	@Autowired
	public BrrowService brrowService;
	@Autowired
	public QuestionService questionService;
}
