package com.sx.libarary.entity;

public class Book {
    private Integer bookId;

    private Integer typeId;

    private Integer pressId;

    private Integer bookcaseId;

    private String bookIsbm;

    private String bookName;

    private String bookAuthor;

    private Double bookPrice;

    private Integer bookStatus;

    private String bookImgAddr;
    
    private Integer code;
    
    private Type type;
    
    private Press press;
    
    public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	private Bookcase bookcase;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getPressId() {
        return pressId;
    }

    public void setPressId(Integer pressId) {
        this.pressId = pressId;
    }

    public Integer getBookcaseId() {
        return bookcaseId;
    }

    public void setBookcaseId(Integer bookcaseId) {
        this.bookcaseId = bookcaseId;
    }

    public String getBookIsbm() {
        return bookIsbm;
    }

    public void setBookIsbm(String bookIsbm) {
        this.bookIsbm = bookIsbm == null ? null : bookIsbm.trim();
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor == null ? null : bookAuthor.trim();
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Integer getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(Integer bookStatus) {
        this.bookStatus = bookStatus;
    }

    public String getBookImgAddr() {
        return bookImgAddr;
    }

    public void setBookImgAddr(String bookImgAddr) {
        this.bookImgAddr = bookImgAddr == null ? null : bookImgAddr.trim();
    }

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Press getPress() {
		return press;
	}

	public void setPress(Press press) {
		this.press = press;
	}

	public Bookcase getBookcase() {
		return bookcase;
	}

	public void setBookcase(Bookcase bookcase) {
		this.bookcase = bookcase;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", typeId=" + typeId + ", pressId=" + pressId + ", bookcaseId=" + bookcaseId
				+ ", bookIsbm=" + bookIsbm + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", bookPrice="
				+ bookPrice + ", bookStatus=" + bookStatus + ", bookImgAddr=" + bookImgAddr + ", type=" + type
				+ ", press=" + press + ", bookcase=" + bookcase + "]";
	}
    
}