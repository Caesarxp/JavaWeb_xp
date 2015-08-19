
  package student.servlet;

  import java.io.IOException;
  import java.util.List;
  import javax.servlet.ServletException;
  import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest;
  import javax.servlet.http.HttpServletResponse;
  import student.manager.StudentManager;
  
  /**
   * 
   * @author Administrator
   * 完成查找课程信息请求控制
   */
   public class FindClassInfo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 StudentManager studentManager=StudentManager.getInstance();
		 List aClass=studentManager.findAllClass(); 
		 req.setAttribute("aClass", aClass);
		 req.getRequestDispatcher("/studentjsp/SeeClassInfo.jsp").forward(req, resp);
	}

  }
