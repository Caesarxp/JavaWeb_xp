
   package noticeservlet;

   import java.io.IOException;
   import java.text.SimpleDateFormat;
   import javax.servlet.ServletException;
   import javax.servlet.http.HttpServlet;
   import javax.servlet.http.HttpServletRequest;
   import javax.servlet.http.HttpServletResponse;

import noticemanager.NoticeManager;
   import forms.NoticeForm;
import java.util.Date;
   /**
    * 
    * @author Administrator
    * 完成添加通告请求控制
    */
   public class AddNotice extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 doGet(req, resp);
	}

	 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String date=null; 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		date=dateFormat.format(new Date());
		NoticeForm noticeForm=new NoticeForm();
		noticeForm.setTitle(req.getParameter("title"));
		noticeForm.setText(req.getParameter("text"));
		noticeForm.setDate(date);
		
		NoticeManager noticeManager=NoticeManager.getInstance();
		noticeManager.addNotice(noticeForm);
		req.getRequestDispatcher("/NoticeInfo").forward(req, resp);
	
	}

   }
