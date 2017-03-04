package com.biz.impl;

import java.util.List;

import com.biz.IClassesBiz;
import com.dao.IClassesDao;
import com.dao.impl.ClassesDaoImpl;
import com.entity.Classes;

public class ClassesBizImpl implements IClassesBiz {
	
	private IClassesDao cdao = new ClassesDaoImpl();

	@Override
	public List<Classes> queryAllClss() {
		List<Classes> clsList = null;
		try {
			clsList = cdao.queryAllClss();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return clsList;
	}

	@Override
	public Classes queryClsByClsId(String classId) {
		Classes cls = null;
		try {
			cls = cdao.queryClsByClsId(classId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return cls;
	}

}
