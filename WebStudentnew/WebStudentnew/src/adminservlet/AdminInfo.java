  
   package adminservlet;

   import infomanager.UserManager;

import java.io.IOException;
   import java.util.ArrayList;
   import java.util.List;
   import javax.servlet.ServletException;
   import javax.servlet.http.HttpServlet;
   import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adminmanager.AdminManager;
  

    /**
     * 
     * @author Administrator
     * 完成显示所有管理员信息的控制
     */
    public class AdminInfo  extends HttpServlet{
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 AdminManager adminManager=AdminManager.getInstance();
		 List list =adminManager.findAllAdmin(); 
	     req.setAttribute("showalladmin",list);
		
		req.getRequestDispatcher("/WEB-INF/adminjsp/showalladmin.jsp").forward(req, resp);
		
	 
	 }

    }  