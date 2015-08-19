package com.xp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xp.Bean.Book;
import com.xp.service.bookService;
import com.xp.service.impl.bookServiceimpl;

public class ShowAllBookServlet extends HttpServlet {

	private bookService s=new bookServiceimpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String,Book> books=s.findAllBooks();
		request.setAttribute("books", books);
		request.getRequestDispatcher("/WEB-INF/pages/listBook.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
