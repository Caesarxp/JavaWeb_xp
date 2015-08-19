  
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
    * 完成查看通告信息请求控制
    */
   public class FindStudentTitleInfo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 StudentManager studentManager=StudentManager.getInstance();
		 List notice=studentManager.findAllNotice(); 
		 req.setAttribute("notice", notice);
		 req.getRequestDispatcher("/studentjsp/SeenoticeInfo.jsp").forward(req, resp);
	}

   }
