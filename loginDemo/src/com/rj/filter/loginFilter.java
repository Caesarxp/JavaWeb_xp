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
			System.out.println("** 过滤器初始化...") ;
		}
		public void doFilter(ServletRequest request,
	                     ServletResponse response,
	                     FilterChain chain)
	              throws IOException,
	                     ServletException
		{
			// Session属于HTTP范畴，所以ServletRequest对象需要先转换成HttpServletRequest对象
			HttpServletRequest req = (HttpServletRequest)request ;
			HttpSession session = req.getSession() ;
			// 如果session不为空，则可以浏览其他页面
			if(session.getAttribute("name")!=null)
			{
				chain.doFilter(request,response) ;
			}
			else
			{
				// 通过requestDispatcher跳转到登陆页
				request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response) ;
			    System.out.println("你没有登录");
			}
		}
		public void destroy()
		{
			System.out.println("** 过滤器销毁...") ;
		}
}
