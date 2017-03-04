package com.entity;

import java.io.Serializable;

public class StudentVO implements Serializable {

	private static final long serialVersionUID = 1287207805775810643L;
	
	private String stuId;
	private String stuName;
	private String className;
	
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	

}
