
  package courseservlet;

  import java.io.IOException;
  import javax.servlet.ServletException;
  import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mode.ClassBean;
import coursemanager.CourseManager;
  
  /**
   * 完成添加课程信息请求控制
   * @author Administrator
   *
   */
  public class AddCourseFinsh extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ClassBean classBean=new ClassBean();
		 //int id=Integer.parseInt(req.getParameter("id"));
		 //classBean.setId(id);
		 classBean.setClassName(req.getParameter("className"));
		 classBean.setTeacher(req.getParameter("teacher"));
		 classBean.setScore(req.getParameter("score"));
	
		 CourseManager courseManager=CourseManager.getInstance();
		 courseManager.addCourse(classBean); 
		 
		req.getRequestDispatcher("/FindAllCourseInfo").forward(req, resp);
		 
	}

  }
