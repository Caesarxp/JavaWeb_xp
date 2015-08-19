 
  package noticeservlet;

  import java.io.IOException;
  import javax.servlet.ServletException;
  import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest;
  import javax.servlet.http.HttpServletResponse;
  
  /**
   * 
   * @author Administrator
   * 转入添加通告页面控制
   */
   public class ForwardAddNotice extends HttpServlet {

	@Override
	  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 
		  doPost(req, resp);
	 }

	@Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		 
		 req.getRequestDispatcher("/WEB-INF/noticejsp/AddNotice.jsp").forward(req, resp);
	}

  }
