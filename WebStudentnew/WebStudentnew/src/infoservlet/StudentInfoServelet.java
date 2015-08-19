
  package infoservlet;

  import infodao.*;
import infomanager.UserManager;

  import java.io.IOException;
  import java.io.PrintWriter;
  import java.sql.Connection;
  import java.sql.DriverManager;
  import java.sql.ResultSet;
  import java.sql.Statement;
  import java.util.ArrayList;
  import java.util.List;
  import javax.servlet.ServletException;
  import javax.servlet.http.Cookie;
  import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest;
  import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



  /**
   * 
   * @author Administrator
   *完成对显示所有现实信息请求的控制
   */
  
  public class StudentInfoServelet  extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("username");
		UserManager userManager=UserManager.getInstance();
		List list =userManager.findAllUse(username);
		req.setAttribute("user", list);
		
		req.getRequestDispatcher("/WEB-INF/infojsp/studentInfo.jsp").forward(req, resp);
		
	}
	
  }

