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
	�����鼮����
	 */
	private bookService s=new bookServiceimpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String bookId=request.getParameter("bookId");
		Book book=s.findBookById(bookId);
		//�ѵ㣺���빺�ﳵ
		HttpSession session=request.getSession();
		Cart cart=(Cart)session.getAttribute("cart");
		if(cart==null){
			cart=new Cart();
			session.setAttribute("cart",cart);
		}
		//���빺�ﳵ,ͨ��ҵ���߼�
		s.addBookCart(cart,book);
		out.write("��"+book.getName()+"���Ѿ����빺�ﳵ��<a href='"+request.getContextPath()+"'>��������</a>");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
