  
    package adminservlet;
 
    import java.io.IOException;
    import java.util.ArrayList;
    import java.util.List;
    import javax.servlet.ServletException;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    import javax.servlet.http.HttpSession;
    import mode.UseBean;
    import adminmanager.AdminManager;
 
    /**
     * 
     * @author Administrator
     * 完成对管理员密码修改的请求控制
     */
    public class UpdataAdminPassword  extends HttpServlet{
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 
		
		HttpSession session = req.getSession();
		String name=(String) session.getAttribute("name");
		AdminManager adminManager=AdminManager.getInstance();
		UseBean useBean=adminManager.findAdminPsaaword(name);
		req.setAttribute("useBeanadmin",useBean);
		req.getRequestDispatcher("/WEB-INF/adminjsp/UpdataAdminPassword.jsp").forward(req, resp);
			 
		 
			 
	}
	
  }
