
    package adminservlet;
 
    import java.io.IOException;
    import java.util.ArrayList;
    import java.util.List;
    import javax.servlet.ServletException;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    import javax.servlet.http.HttpSession;
    import adminmanager.AdminManager;
    import forms.AdminPasswordForm;
  

 
    /**
     * 
     * @author Administrator
     * 完成对管理员密码的修改控制
     */
     public class UpdataAdminPasswordFinsh  extends HttpServlet{
	 
	
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		   doPost(req, resp);
	 }

	 protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 HttpSession session = req.getSession();
		 String password=(String)session.getAttribute("password");
		 System.out.println(password);
		 AdminPasswordForm adminpasswordForm=new AdminPasswordForm();
		 adminpasswordForm.setId(Integer.parseInt(req.getParameter("id")));
		 adminpasswordForm.setName(req.getParameter("name"));
		 adminpasswordForm.setOldPw(req.getParameter("oldPw"));
		 adminpasswordForm.setNewPw1(req.getParameter("newPw1"));
		 adminpasswordForm.setNewPw2(req.getParameter("newPw2"));
		 if(password.equals(adminpasswordForm.getOldPw())){
			 AdminManager adminManager=AdminManager.getInstance();
			 adminManager.updataAdminPasswordFinsh(adminpasswordForm);
			 req.getRequestDispatcher("/AdminInfo").forward(req, resp);
		  }
		 else req.getRequestDispatcher("/WEB-INF/adminjsp/adminpassworderror.jsp").forward(req, resp);
	 }
	
  }
