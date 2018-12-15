package com.sx.libarary.entity;

public class Bookcase {
    private Integer bookcaseId;

    private String bookcaseName;

    private String bookcaseX;

    private String bookcaseY;
    private Integer code;
    

    public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Integer getBookcaseId() {
        return bookcaseId;
    }

    public void setBookcaseId(Integer bookcaseId) {
        this.bookcaseId = bookcaseId;
    }

    public String getBookcaseName() {
        return bookcaseName;
    }

    public void setBookcaseName(String bookcaseName) {
        this.bookcaseName = bookcaseName == null ? null : bookcaseName.trim();
    }

    public String getBookcaseX() {
        return bookcaseX;
    }

    public void setBookcaseX(String bookcaseX) {
        this.bookcaseX = bookcaseX == null ? null : bookcaseX.trim();
    }

    public String getBookcaseY() {
        return bookcaseY;
    }

    public void setBookcaseY(String bookcaseY) {
        this.bookcaseY = bookcaseY == null ? null : bookcaseY.trim();
    }
}