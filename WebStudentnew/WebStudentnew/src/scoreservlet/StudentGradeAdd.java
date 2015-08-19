
  package scoreservlet;

  import javax.servlet.http.HttpServlet;
  import java.io.IOException;
  import java.util.List;
  import javax.servlet.ServletException;
  import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest;
  import javax.servlet.http.HttpServletResponse;
  import javax.servlet.http.HttpSession;

import scoremanager.ScoreManager;
  
  /**
   * 
   * @author Administrator
   * 完成添加学生成绩请求控制-转入添加成绩页面
   */
   public class StudentGradeAdd extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 
		
		    ScoreManager scoreMassage=ScoreManager.getInstance();
		    List list1 =scoreMassage.findAllStudentId();
		    List list2 =scoreMassage.findAllClassId();
			req.setAttribute("studentAllId",list1);
			req.setAttribute("classAllId",list2);
			req.getRequestDispatcher("/WEB-INF/scorejsp/StudentGradeAdd.jsp").forward(req, resp);
		 
		}
			
	   @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
  }
