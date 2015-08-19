  
    package student.servlet;

    import java.io.IOException;
    import java.util.List;
    import javax.servlet.ServletException;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    import javax.servlet.http.HttpSession;
    import student.manager.StudentManager;

    /**
     * 
     * @author Administrator
     * 完成查找学生成绩请求
     */
  
   public class FindStudentgradeInfo extends HttpServlet {

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
		 List grade=studentManager.findGreadByName(username);
		 req.setAttribute("grade",grade);
		 req.getRequestDispatcher("/studentjsp/SeegradeInfo.jsp").forward(req, resp);
	}

    }
