package com.biz.impl;

import java.util.ArrayList;
import java.util.List;

import com.biz.IStudentBiz;
import com.dao.IStudentDao;
import com.dao.impl.StudentDaoImpl;
import com.entity.StudentPO;
import com.entity.StudentVO;

public class StudentBizImpl implements IStudentBiz {

	private IStudentDao sdao = new StudentDaoImpl();
	
	@Override
	public List<StudentVO> showAllStus() {
		List<StudentVO> list = new ArrayList<StudentVO>();
		try {
			list = sdao.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return list;
	}

	@Override
	public void delStus(String[] ids) {
		try {
			for (String id : ids) {
				sdao.delStu(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public int addStu(StudentPO spo) {
		int count = 0;
		try {
			count = sdao.addStu(spo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return count;
	}

	@Override
	public StudentPO queryStuByStuId(String stuId) {
		StudentPO spo = null;
		try {
			spo = sdao.queryStuByStuId(stuId);
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
			count = sdao.updateStu(spo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return count;
	}

}
