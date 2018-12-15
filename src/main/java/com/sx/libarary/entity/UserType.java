package com.sx.libarary.entity;

public class UserType {
    private Integer userTypeId;

    private Integer userType;

    private Integer userTypeNum;

    private Integer userTypeDay;
    private Integer code;
    

    public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

    public Integer getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Integer userTypeId) {
        this.userTypeId = userTypeId;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getUserTypeNum() {
        return userTypeNum;
    }

    public void setUserTypeNum(Integer userTypeNum) {
        this.userTypeNum = userTypeNum;
    }

    public Integer getUserTypeDay() {
        return userTypeDay;
    }

    public void setUserTypeDay(Integer userTypeDay) {
        this.userTypeDay = userTypeDay;
    }
}