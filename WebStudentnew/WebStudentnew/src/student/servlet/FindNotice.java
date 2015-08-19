
  package student.servlet;

  import java.io.IOException;
  import javax.servlet.ServletException;
  import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest;
  import javax.servlet.http.HttpServletResponse;
  import student.manager.StudentManager;
  import mode.NoticeBean;
 
  
  /**
   * 
   * @author Administrator
   *  完成显示详细通告信息页面
   */
  public class FindNotice extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 int id=Integer.parseInt(req.getParameter("id"));
		 StudentManager studentManager=StudentManager.getInstance();
		 NoticeBean noticeBean=studentManager.findNoticeById(id);
		 req.setAttribute("noticeBean", noticeBean);
		 req.getRequestDispatcher("/studentjsp/FindNotice.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

  }
