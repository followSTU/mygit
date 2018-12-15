package com.sx.libarary.entity;

import java.util.Date;

public class Question {
    private Integer questionId;

    private Integer questionUserId;

    private String questtionDesc;

    private String questionJibie;

    private Date questionCreateTime;

    private String questionStatus;
    
    private User user;
    private Integer code;
    

    public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getQuestionUserId() {
        return questionUserId;
    }

    public void setQuestionUserId(Integer questionUserId) {
        this.questionUserId = questionUserId;
    }

    public String getQuesttionDesc() {
        return questtionDesc;
    }

    public void setQuesttionDesc(String questtionDesc) {
        this.questtionDesc = questtionDesc == null ? null : questtionDesc.trim();
    }

    public String getQuestionJibie() {
        return questionJibie;
    }

    public void setQuestionJibie(String questionJibie) {
        this.questionJibie = questionJibie == null ? null : questionJibie.trim();
    }

    public Date getQuestionCreateTime() {
        return questionCreateTime;
    }

    public void setQuestionCreateTime(Date questionCreateTime) {
        this.questionCreateTime = questionCreateTime;
    }

    public String getQuestionStatus() {
        return questionStatus;
    }

    public void setQuestionStatus(String questionStatus) {
        this.questionStatus = questionStatus == null ? null : questionStatus.trim();
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionUserId=" + questionUserId + ", questtionDesc="
				+ questtionDesc + ", questionJibie=" + questionJibie + ", questionCreateTime=" + questionCreateTime
				+ ", questionStatus=" + questionStatus + ", user=" + user + "]";
	}
    
}