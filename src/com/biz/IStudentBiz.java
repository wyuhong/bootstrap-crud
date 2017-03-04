package com.biz;

import java.util.List;

import com.entity.StudentPO;
import com.entity.StudentVO;

public interface IStudentBiz {
	
	public  List<StudentVO> showAllStus();

	public void delStus(String[] ids);

	public int addStu(StudentPO spo);

	public StudentPO queryStuByStuId(String stuId);

	public int updateStu(StudentPO spo);
}
