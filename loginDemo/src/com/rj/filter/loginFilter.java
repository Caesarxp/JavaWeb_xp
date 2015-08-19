package com.rj.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class loginFilter implements Filter{
	public void init(FilterConfig filterConfig)
	          throws ServletException
		{
			System.out.println("** ��������ʼ��...") ;
		}
		public void doFilter(ServletRequest request,
	                     ServletResponse response,
	                     FilterChain chain)
	              throws IOException,
	                     ServletException
		{
			// Session����HTTP���룬����ServletRequest������Ҫ��ת����HttpServletRequest����
			HttpServletRequest req = (HttpServletRequest)request ;
			HttpSession session = req.getSession() ;
			// ���session��Ϊ�գ�������������ҳ��
			if(session.getAttribute("name")!=null)
			{
				chain.doFilter(request,response) ;
			}
			else
			{
				// ͨ��requestDispatcher��ת����½ҳ
				request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response) ;
			    System.out.println("��û�е�¼");
			}
		}
		public void destroy()
		{
			System.out.println("** ����������...") ;
		}
}
