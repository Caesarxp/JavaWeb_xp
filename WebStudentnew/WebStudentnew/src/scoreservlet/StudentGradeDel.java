
  package scoreservlet;

  import javax.servlet.http.HttpServlet;
  import java.io.IOException;
  import javax.servlet.ServletException;
  import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest;
  import javax.servlet.http.HttpServletResponse;

import scoremanager.ScoreManager;
  
  /**
  * 
  * @author Administrator
  * 完成删除指定学生的请求控制
  */

   public class StudentGradeDel extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 
		    int id=Integer.parseInt(req.getParameter("Id"));
		    ScoreManager scoreMassage=ScoreManager.getInstance();
		    scoreMassage.StudentGradeDel(id);
		    req.getRequestDispatcher("/StudentgradeInfo").forward(req, resp);
		 		
	}
			
		
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doPost(req, resp);
	}
	
 }
