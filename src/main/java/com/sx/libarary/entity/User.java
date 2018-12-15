package com.sx.libarary.entity;

import java.util.Date;

public class User {
    private Integer userId;

    private Integer userTypeId;

    private String userName;

    private String userPassword;

    private String userEmail;

    private String userGender;

    private Integer userStatus;

    private Date userRegTime;

    private String userXuehao;
    
    private UserType userType;
    
    private Integer code;
    

    public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

    @Override
	public String toString() {
		return "User [userId=" + userId + ", userTypeId=" + userTypeId + ", userName=" + userName + ", userPassword="
				+ userPassword + ", userEmail=" + userEmail + ", userGender=" + userGender + ", userStatus="
				+ userStatus + ", userRegTime=" + userRegTime + ", userXuehao=" + userXuehao + ", userType=" + userType
				+ "]";
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Integer userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender == null ? null : userGender.trim();
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Date getUserRegTime() {
        return userRegTime;
    }

    public void setUserRegTime(Date userRegTime) {
        this.userRegTime = userRegTime;
    }

    public String getUserXuehao() {
        return userXuehao;
    }

    public void setUserXuehao(String userXuehao) {
        this.userXuehao = userXuehao == null ? null : userXuehao.trim();
    }
}