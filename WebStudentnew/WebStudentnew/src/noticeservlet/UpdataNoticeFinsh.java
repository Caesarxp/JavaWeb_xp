
  package noticeservlet;
   /**
    * 完成消息的更新请求控制
    */
  import java.io.IOException;
  import javax.servlet.ServletException;
  import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest;
  import javax.servlet.http.HttpServletResponse;

import noticemanager.NoticeManager;
import forms.NoticeForm;

  public class UpdataNoticeFinsh extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NoticeForm noticeForm=new NoticeForm();
		noticeForm.setId(Integer.parseInt(req.getParameter("id")));
		noticeForm.setTitle(req.getParameter("title"));
		noticeForm.setText(req.getParameter("text"));
		
		NoticeManager noticeManager=NoticeManager.getInstance();
		noticeManager.updateNotice(noticeForm);
		
		req.getRequestDispatcher("/NoticeInfo").forward(req, resp);
	
	}

  }
