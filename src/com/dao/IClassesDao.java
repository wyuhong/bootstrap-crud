package com.dao;

import java.util.List;

import com.entity.Classes;

public interface IClassesDao {

	public List<Classes> queryAllClss();

	public Classes queryClsByClsId(String classId);
}
