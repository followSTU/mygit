package com.sx.libarary.entity;

import java.util.Date;

public class Brrow {
    private Integer brrowId;

    private Integer brrowBookId;

    private Integer brrowBookUser;

    private String brrowBookStatus;

    private Date brrowBookJieshu;

    private Date brrowBookHuanshu;
    
    private User user;
    
    private Book book;
    private Integer code;
    

    public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

    public Integer getBrrowId() {
        return brrowId;
    }

    public void setBrrowId(Integer brrowId) {
        this.brrowId = brrowId;
    }

    public Integer getBrrowBookId() {
        return brrowBookId;
    }

    public void setBrrowBookId(Integer brrowBookId) {
        this.brrowBookId = brrowBookId;
    }

    public Integer getBrrowBookUser() {
        return brrowBookUser;
    }

    public void setBrrowBookUser(Integer brrowBookUser) {
        this.brrowBookUser = brrowBookUser;
    }

    public String getBrrowBookStatus() {
        return brrowBookStatus;
    }

    public void setBrrowBookStatus(String brrowBookStatus) {
        this.brrowBookStatus = brrowBookStatus == null ? null : brrowBookStatus.trim();
    }

    public Date getBrrowBookJieshu() {
        return brrowBookJieshu;
    }

    public void setBrrowBookJieshu(Date brrowBookJieshu) {
        this.brrowBookJieshu = brrowBookJieshu;
    }

    public Date getBrrowBookHuanshu() {
        return brrowBookHuanshu;
    }

    public void setBrrowBookHuanshu(Date brrowBookHuanshu) {
        this.brrowBookHuanshu = brrowBookHuanshu;
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Brrow [brrowId=" + brrowId + ", brrowBookId=" + brrowBookId + ", brrowBookUser=" + brrowBookUser
				+ ", brrowBookStatus=" + brrowBookStatus + ", brrowBookJieshu=" + brrowBookJieshu
				+ ", brrowBookHuanshu=" + brrowBookHuanshu + ", user=" + user + ", book=" + book + "]";
	}
    
}