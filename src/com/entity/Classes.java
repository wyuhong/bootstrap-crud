package com.entity;

import java.io.Serializable;

/**
 * 班级的实体类（PO VO）
 * @author dhc
 *
 */
public class Classes implements Serializable {

	private static final long serialVersionUID = -4965510625507370672L;
	
	private String classId;
	private String className;
	
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	

}
