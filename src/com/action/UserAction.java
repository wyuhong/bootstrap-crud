package com.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.biz.IUserBiz;
import com.biz.impl.UserBizImpl;
import com.entity.UserInfo;

public class UserAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IUserBiz ubiz = new UserBizImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//固定部分
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		//分支部分
		String flag = request.getParameter("flag");
		
		if("login".equals(flag)){
			this.login(request,response);
		}else if("queryAll".equals(flag)){
			this.queryAll(request,response);
		}
	}
	/**
	 * 专门用于查询所有的方法
	 * @param request
	 * @param response
	 */
	private void queryAll(HttpServletRequest request, HttpServletResponse response) {
		
	}

	/**
	 * 专门用于登录的方法
	 * @param request
	 * @param response
	 */
	private void login(HttpServletRequest request, HttpServletResponse response) {
		try {
			UserInfo ui = new UserInfo(request.getParameter("userName"),request.getParameter("userPwd"));
			JSONObject jo = new JSONObject();
			PrintWriter out = response.getWriter();
			if(ubiz.login(ui)){
				//登录成功
				request.getSession().setAttribute("user", ui);
				jo.put("state", "success");
				jo.put("user", ui);
			}else{
				//登录失败
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

}
