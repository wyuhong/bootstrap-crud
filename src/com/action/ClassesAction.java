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
import com.biz.IClassesBiz;
import com.biz.impl.ClassesBizImpl;
import com.entity.Classes;

public class ClassesAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IClassesBiz cbiz = new ClassesBizImpl();
	
	private List<Classes> clsList = new ArrayList<Classes>();
	

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

		if ("queryAllJson".equals(flag)) {
			this.queryAllJson(request, response);
		}
	}
	/**
	 * 查询所有班级信息的方法
	 * @param request
	 * @param response
	 */
	private void queryAllJson(HttpServletRequest request, HttpServletResponse response) {
		try {
			clsList = cbiz.queryAllClss();
			request.setAttribute("clsList", clsList);
			PrintWriter out = response.getWriter();
			out.print(JSON.toJSONString(clsList));
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
	}

}
