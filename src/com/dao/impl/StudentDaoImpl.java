package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.dao.IStudentDao;
import com.entity.StudentPO;
import com.entity.StudentVO;
import com.util.JdbcUtils;

public class StudentDaoImpl implements IStudentDao {

	@Override
	public List<StudentVO> selectAll() {
		List<StudentVO> list = new ArrayList<StudentVO>();
		try {
			List olist = JdbcUtils.query("select s.stuId,s.stuName,c.className  from student s inner join classes c on s.classId=c.classId");
			for (Object obj : olist) {
				StudentVO svo = JSON.parseObject(JSON.toJSONString(obj), StudentVO.class);
				list.add(svo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return list;
	}
	

	@Override
	public void delStu(String id) {
		try {
			JdbcUtils.update("delete from student where stuId=?", new Object[]{id});
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}


	@Override
	public int addStu(StudentPO spo) {
		int count = 0;
		try {
			count = JdbcUtils.update("insert into student values(?,?,?)", new Object[]{spo.getStuId(),spo.getStuName(),spo.getClassId()});
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return count;
	}


	@SuppressWarnings("rawtypes")
	@Override
	public StudentPO queryStuByStuId(String stuId) {
		StudentPO spo = null;
		try {
			List list = JdbcUtils.query("select * from student where stuId=?", new Object[]{stuId});
			spo = JSON.parseObject(JSON.toJSONString(list.get(0)), StudentPO.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return spo;
	}


	@Override
	public int updateStu(StudentPO spo) {
		int count = 0;
		try {
			count = JdbcUtils.update("update student set stuName=?,classId=? where stuId=?", new Object[]{spo.getStuName(),spo.getClassId(),spo.getStuId()});
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return count;
	}

}
