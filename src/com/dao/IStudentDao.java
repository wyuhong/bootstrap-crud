package com.dao;

import java.util.List;

import com.entity.StudentPO;
import com.entity.StudentVO;

public interface IStudentDao {

	public List<StudentVO> selectAll();

	public void delStu(String id);

	public int addStu(StudentPO spo);

	public StudentPO queryStuByStuId(String stuId);

	public int updateStu(StudentPO spo);
}
