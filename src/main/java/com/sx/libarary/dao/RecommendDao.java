 package com.sx.libarary.dao;

import java.util.List;

import com.sx.libarary.entity.Recommend;

public interface RecommendDao {
	Recommend queryRecommend(Integer id);
	
	List<Recommend> queryRecommends();
	
	int updateRecommend(Recommend recommend);
	
	int deleteRecommend(Recommend recommend);
	
	int insertRecommend(Recommend recommend);
}
