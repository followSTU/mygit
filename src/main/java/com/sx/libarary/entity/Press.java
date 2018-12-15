package com.sx.libarary.entity;

public class Press {
    private Integer pressId;

    private String pressName;
    private Integer code;
    

    public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

    public Integer getPressId() {
        return pressId;
    }

    public void setPressId(Integer pressId) {
        this.pressId = pressId;
    }

    public String getPressName() {
        return pressName;
    }

    public void setPressName(String pressName) {
        this.pressName = pressName == null ? null : pressName.trim();
    }
}