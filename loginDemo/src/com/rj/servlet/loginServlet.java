package com.rj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginServlet extends HttpServlet {

	/**
	实现登陆验证
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		doPost(request,response);
		
	}

	/**
	 
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//获取密码
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		//设置session
		HttpServletRequest req = (HttpServletRequest)request ;
		HttpSession session = req.getSession() ;
		if(name.equals("niujian")&&password.equals("12345")){
			out.write(name+"已经登陆");
		}
	}

}
