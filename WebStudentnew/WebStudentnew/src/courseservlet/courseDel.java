
   package courseservlet;

   import java.io.IOException;
   import javax.servlet.ServletException;
   import javax.servlet.http.HttpServlet;
   import javax.servlet.http.HttpServletRequest;
   import javax.servlet.http.HttpServletResponse;
   import coursemanager.CourseManager;
  
   /**
    * 完成删除课程请求的控制
    * @author Administrator
    *
    */
   public class courseDel extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 int id=Integer.parseInt(req.getParameter("courseId"));
		 CourseManager courseManager=CourseManager.getInstance();
		 courseManager.delCourse(id); 
		 
		req.getRequestDispatcher("/FindAllCourseInfo").forward(req, resp);
	}

   }
