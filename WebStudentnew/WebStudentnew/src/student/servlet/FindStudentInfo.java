  
  package student.servlet;

  import java.io.IOException;
  import java.util.List;
  import javax.servlet.ServletException;
  import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest;
  import javax.servlet.http.HttpServletResponse;
  import javax.servlet.http.HttpSession;
  import mode.StudentBean;
  import student.manager.StudentManager;
  
  /**
   * 
   * @author Administrator
   * 完成查找学生信息请求控制
   */
  public class FindStudentInfo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 HttpSession session=null;
		 String username =null;
		 session = req.getSession();
		 username=(String) session.getAttribute("name");
		 StudentManager studentManager=StudentManager.getInstance();
		 List student=studentManager.findStudentByName(username);
		 req.setAttribute("student", student);
		 req.getRequestDispatcher("/studentjsp/SeestudentInfo.jsp").forward(req, resp);
	}

   }
