package com.xp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xp.Bean.Cart;
import com.xp.service.bookService;
import com.xp.service.impl.bookServiceimpl;

public class delOneServlet extends HttpServlet {

	/**删除购物车
	 */
	private bookService s=new bookServiceimpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bookId=request.getParameter("booId");
		HttpSession session=request.getSession();
		Cart cart=(Cart)session.getAttribute("cart");
		if(cart==null){
			cart=new Cart();
			session.setAttribute("cart", cart);
		}
		s.delOneCartItem(cart,bookId);
		//转发向购物页面
		request.getRequestDispatcher("/WEB-INF/pages/showCart.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
