
   package courseservlet;

   import java.io.IOException;
   import javax.servlet.ServletException;
   import javax.servlet.http.HttpServlet;
   import javax.servlet.http.HttpServletRequest;
   import javax.servlet.http.HttpServletResponse;
  
   /**
    * 转入到录入页面的控制
    * @author Administrator
    *
    */
   public class courseAdd extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 req.getRequestDispatcher("/WEB-INF/coursejsp/addcourse.jsp").forward(req, resp);
	}

   }
