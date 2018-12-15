package com.sx.libarary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sx.libarary.dao.RecommendDao;
import com.sx.libarary.entity.Recommend;

@Service
public class RecommendService {
	@Autowired
	private RecommendDao recommendDao;
	public List<Recommend> getRecommends(){
		return recommendDao.queryRecommends();
	}
	
	public Recommend getRecommend(Integer id){
		return recommendDao.queryRecommend(id);
	}
	public int addRecommend(Recommend recommend){
		return recommendDao.insertRecommend(recommend);
	}
	
	public int updateRecommend(Recommend recommend){
		return recommendDao.updateRecommend(recommend);
	}
	
	public int deleteRecommend(Recommend recommend){
		return recommendDao.deleteRecommend(recommend);
	}
}
