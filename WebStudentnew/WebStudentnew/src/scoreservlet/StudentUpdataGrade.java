
  package scoreservlet;

  import java.io.IOException;
  import javax.servlet.ServletException;
  import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest;
  import javax.servlet.http.HttpServletResponse;
  import mode.GradeBean;
import scoremanager.ScoreManager;
 
  /**
   * 
   * @author Administrator
   *  完成更新学生成绩请求控制-查找指定成绩
   */
  public class StudentUpdataGrade extends HttpServlet{
	
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int id=0;
		id=Integer.parseInt(req.getParameter("id"));
		ScoreManager scoreMassage=ScoreManager.getInstance();
		GradeBean grade=scoreMassage.findGradeById(id);
		req.setAttribute("grade",grade);
		req.getRequestDispatcher("/WEB-INF/scorejsp/updateGrade.jsp").forward(req, resp);
		
		 
	}	
  }		
		
	
