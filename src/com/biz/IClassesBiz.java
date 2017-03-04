package com.biz;

import java.util.List;

import com.entity.Classes;

public interface IClassesBiz {
	
	public List<Classes> queryAllClss();

	public Classes queryClsByClsId(String classId);
}
