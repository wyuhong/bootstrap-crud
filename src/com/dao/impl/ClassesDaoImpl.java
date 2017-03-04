package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.dao.IClassesDao;
import com.entity.Classes;
import com.util.JdbcUtils;

public class ClassesDaoImpl implements IClassesDao {

	@SuppressWarnings("rawtypes")
	@Override
	public List<Classes> queryAllClss() {
		List<Classes> clsList = new ArrayList<Classes>();
		try {
			List list = JdbcUtils.query("select * from classes");
			for (Object ob : list) {
				clsList.add(JSON.parseObject(JSON.toJSONString(ob), Classes.class));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return clsList;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Classes queryClsByClsId(String classId) {
		Classes cls = null;
		try {
			List list = JdbcUtils.query("select * from classes where classId=?", new Object[]{classId});
			cls = JSON.parseObject(JSON.toJSONString(list.get(0)), Classes.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return cls;
	}

}
