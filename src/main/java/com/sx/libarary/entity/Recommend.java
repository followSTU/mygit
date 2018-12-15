package com.sx.libarary.entity;

import java.util.Date;

public class Recommend {
    private Integer recommendId;

    private Integer recommendUserId;

    private String recommendBookName;

    private String recommendBookAuthor;

    private String recommendBookStatus;

    private Date recommendCreateTime;

    private User user;
    private Integer code;
    

    public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
    
    public Integer getRecommendId() {
        return recommendId;
    }

    public void setRecommendId(Integer recommendId) {
        this.recommendId = recommendId;
    }

    public Integer getRecommendUserId() {
        return recommendUserId;
    }

    public void setRecommendUserId(Integer recommendUserId) {
        this.recommendUserId = recommendUserId;
    }

    public String getRecommendBookName() {
        return recommendBookName;
    }

    public void setRecommendBookName(String recommendBookName) {
        this.recommendBookName = recommendBookName == null ? null : recommendBookName.trim();
    }

    public String getRecommendBookAuthor() {
        return recommendBookAuthor;
    }

    public void setRecommendBookAuthor(String recommendBookAuthor) {
        this.recommendBookAuthor = recommendBookAuthor == null ? null : recommendBookAuthor.trim();
    }

    public String getRecommendBookStatus() {
        return recommendBookStatus;
    }

    public void setRecommendBookStatus(String recommendBookStatus) {
        this.recommendBookStatus = recommendBookStatus == null ? null : recommendBookStatus.trim();
    }

    public Date getRecommendCreateTime() {
        return recommendCreateTime;
    }

    public void setRecommendCreateTime(Date recommendCreateTime) {
        this.recommendCreateTime = recommendCreateTime;
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Recommend [recommendId=" + recommendId + ", recommendUserId=" + recommendUserId + ", recommendBookName="
				+ recommendBookName + ", recommendBookAuthor=" + recommendBookAuthor + ", recommendBookStatus="
				+ recommendBookStatus + ", recommendCreateTime=" + recommendCreateTime + ", user=" + user + "]";
	}
    
}