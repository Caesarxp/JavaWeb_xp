
  package courseservlet;

  import java.io.IOException;
  import java.util.List;
  import javax.servlet.ServletException;
  import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest;
  import javax.servlet.http.HttpServletResponse;
  import mode.ClassBean;
  import coursemanager.CourseManager;

  /**
   * 完成查找某一课程的请求控制
   * @author Administrator
   *
   */
   public class UpdataCourse extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(req.getParameter("id"));
		CourseManager courseManager=CourseManager.getInstance();
		ClassBean course=courseManager.findAllCourseById(id); 
		req.setAttribute("course", course);
		req.getRequestDispatcher("/WEB-INF/coursejsp/UpdateCourse.jsp").forward(req, resp);
	}

  }
