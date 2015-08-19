
  package noticeservlet;

  import java.io.IOException;
  import javax.servlet.ServletException;
  import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest;
  import javax.servlet.http.HttpServletResponse;
  import mode.NoticeBean;
import noticemanager.NoticeManager;
  
  /**
   * 
   * @author Administrator
   *  完成通告更新处理-转入更新页面
   */
  public class UpdateNotice extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 int id=Integer.parseInt(req.getParameter("id"));
		 NoticeManager noticeManager=NoticeManager.getInstance();
		 NoticeBean noticeBean=noticeManager.findNoticeById(id);
		 req.setAttribute("noticeBean", noticeBean);
		 req.getRequestDispatcher("/WEB-INF/noticejsp/UpdateNotice.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

  }
