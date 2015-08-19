package com.xp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xp.Bean.Book;
import com.xp.Bean.Cart;
import com.xp.service.bookService;
import com.xp.service.impl.bookServiceimpl;

public class BuyServlet extends HttpServlet {

	/**
	购买书籍处理
	 */
	private bookService s=new bookServiceimpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String bookId=request.getParameter("bookId");
		Book book=s.findBookById(bookId);
		//难点：加入购物车
		HttpSession session=request.getSession();
		Cart cart=(Cart)session.getAttribute("cart");
		if(cart==null){
			cart=new Cart();
			session.setAttribute("cart",cart);
		}
		//加入购物车,通过业务逻辑
		s.addBookCart(cart,book);
		out.write("【"+book.getName()+"】已经加入购物车。<a href='"+request.getContextPath()+"'>继续购物</a>");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
