package com.sx.libarary.entity;

public class Type {
    private Integer typeId;

    private String typeName;

    private String typeSecondName;
    private Integer code;
    

    public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getTypeSecondName() {
        return typeSecondName;
    }

    public void setTypeSecondName(String typeSecondName) {
        this.typeSecondName = typeSecondName == null ? null : typeSecondName.trim();
    }

	@Override
	public String toString() {
		return "Type [typeId=" + typeId + ", typeName=" + typeName + ", typeSecondName=" + typeSecondName + "]";
	}
    
    
}