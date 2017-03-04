package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.biz.IClassesBiz;
import com.biz.IStudentBiz;
import com.biz.impl.ClassesBizImpl;
import com.biz.impl.StudentBizImpl;
import com.entity.Classes;
import com.entity.StudentPO;
import com.entity.StudentVO;

public class StudentAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IStudentBiz sbiz = new StudentBizImpl();
	private IClassesBiz cbiz = new ClassesBizImpl();
	
	//备用属性
	private List<StudentVO> stuList = new ArrayList<StudentVO>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 固定部分
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		// 分支部分
		String flag = request.getParameter("flag");

		if ("queryAll".equals(flag)) {
			this.queryAll(request, response);
		}else if("queryAllJson".equals(flag)){
			this.queryAllJson(request,response);
		}else if("delStus".equals(flag)){
			this.delStus(request,response);
		}else if("addStu".equals(flag)){
			this.addStu(request,response);
		}else if("queryStuByStuIdJson".equals(flag)){
			this.queryStuByStuIdJson(request,response);
		}else if("updateStu".equals(flag)){
			this.updateStu(request,response);
		}
	}
	/**
	 * 更新学生信息的方法
	 * @param request
	 * @param response
	 */
	private void updateStu(HttpServletRequest request, HttpServletResponse response) {
		try {
			StudentPO spo = new StudentPO(request.getParameter("stuId"),request.getParameter("stuName"),request.getParameter("classId"));
			int count = sbiz.updateStu(spo);
			JSONObject jo = new JSONObject();
			PrintWriter out = response.getWriter();
			if(count > 0){
				jo.put("state", "success");
			}else{
				jo.put("state", "fail");
			}
			out.print(jo);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
	}

	/**
	 * 根据学生编号查询学生的具体信息
	 * @param request
	 * @param response
	 */
	private void queryStuByStuIdJson(HttpServletRequest request, HttpServletResponse response) {
		try {
			String stuId = request.getParameter("stuId");
			//在这里要返回哪些内容
			//1 按照学生编号查询该学生信息
			StudentPO spo = sbiz.queryStuByStuId(stuId);
			//2 所在班级的信息
			Classes cls = cbiz.queryClsByClsId(spo.getClassId());
			//3 所有班级的信息
			List<Classes> clsList = cbiz.queryAllClss();
			//把 123 全部整合到一个完整的JSON中，抛回给前台
			JSONObject jo = new JSONObject();
			jo.put("spo",spo);
			jo.put("cls", cls);
			jo.put("clsList", clsList);
			PrintWriter out = response.getWriter();
			out.print(jo);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	/**
	 * 添加学生方法
	 * @param request
	 * @param response
	 */
	private void addStu(HttpServletRequest request, HttpServletResponse response) {
		try {
			StudentPO spo = new StudentPO(request.getParameter("stuId"),request.getParameter("stuName"),request.getParameter("classId"));
			int count = sbiz.addStu(spo);
			JSONObject jo = new JSONObject();
			PrintWriter out = response.getWriter();
			if(count > 0){
				jo.put("state", "success");
			}else{
				jo.put("state", "fail");
			}
			out.print(jo);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	/**
	 * 批量删除学生的方法
	 * @param request
	 * @param response
	 */
	private void delStus(HttpServletRequest request, HttpServletResponse response) {
		try {
			String[] ids = request.getParameterValues("a[]");
			sbiz.delStus(ids);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	/**
	 * 查询出所有学生并且产生JSON的方法
	 * @param request
	 * @param response
	 */
	private void queryAllJson(HttpServletRequest request, HttpServletResponse response) {
		try {
			stuList = sbiz.showAllStus();
			request.setAttribute("stuList", stuList);
			PrintWriter out = response.getWriter();
			out.print(JSON.toJSONString(stuList));
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	/**
	 * 跳转页面（这里的转发和重定向没有区别，都是跳转到welcome.jsp页面后，重新加载了queryAllJson方法）
	 * @param request
	 * @param response
	 */
	private void queryAll(HttpServletRequest request, HttpServletResponse response) {
		try {
//			stuList = sbiz.showAllStus();
//			request.setAttribute("stuList", stuList);
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
	}

}
