
  package courseservlet;

  import java.io.IOException;
  import java.util.List;
  import javax.servlet.ServletException;
  import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest;
  import javax.servlet.http.HttpServletResponse;
  import coursemanager.CourseManager;
 
  
  /**
   * 
   * @author Administrator
   * 完成查找所有课程信息请求控制
   */
   public class FindAllCourseInfo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 CourseManager courseManager=CourseManager.getInstance();
		 List AllCourse=courseManager.findAllCourse(); 
		 req.setAttribute("AllCourse", AllCourse);
		 req.getRequestDispatcher("/WEB-INF/coursejsp/SeecourseInfo.jsp").forward(req, resp);
	}

  }
