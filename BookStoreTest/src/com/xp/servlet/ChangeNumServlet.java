package com.xp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xp.Bean.Cart;
import com.xp.service.bookService;
import com.xp.service.impl.bookServiceimpl;

public class ChangeNumServlet extends HttpServlet {
//修改购物数量
	private bookService s=new bookServiceimpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			String bookId = request.getParameter("bookId");
			String newnum = request.getParameter("newnum");
			//找出购物车
			Cart cart = (Cart)request.getSession().getAttribute("cart");
			int num = Integer.parseInt(newnum);
			if(num<1){
				request.setAttribute("message","<script type='text/javascript'>alert('请输入正确的数量值');</script>" );
			}else{
			//修改数量
			s.changeCartItemNum(cart,bookId,num);
			}
		} catch (NumberFormatException e) {
			request.setAttribute("message","<script type='text/javascript'>alert('请输入正确的数字');</script>" );
		}
		//转发到显示购物车的页面
		request.getRequestDispatcher("/WEB-INF/pages/showCart.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
