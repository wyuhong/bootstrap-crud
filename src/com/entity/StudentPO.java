package com.entity;

import java.io.Serializable;

public class StudentPO implements Serializable {

	private static final long serialVersionUID = -8044345513296538056L;
	
	private String stuId;
	private String stuName;
	private String classId;
	
	public StudentPO() {}
	
	public StudentPO(String stuId, String stuName, String classId) {
		this.stuId = stuId;
		this.stuName = stuName;
		this.classId = classId;
	}

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
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	
	

}
