
  package noticeservlet;

  import java.io.IOException;
  import javax.servlet.ServletException;
  import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import noticemanager.NoticeManager;
  /**
   * 
   * @author Administrator
   * 完成删除通告请求控制
   */
  public class NoticeDel extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 int id=Integer.parseInt(req.getParameter("userId"));
		 NoticeManager noticeManager=NoticeManager.getInstance();
		 noticeManager.noticeDel(id);
		 req.getRequestDispatcher("/NoticeInfo").forward(req, resp);
	}
	   
  }
