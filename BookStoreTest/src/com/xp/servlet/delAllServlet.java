package com.xp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class delAllServlet extends HttpServlet {

	/**清空购物车
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		request.getSession().invalidate();销毁session
		request.getSession().removeAttribute("cart");
		//转发到显示购物车的页面
		request.getRequestDispatcher("/WEB-INF/pages/showCart.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
