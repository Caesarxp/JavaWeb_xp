
  package noticeservlet;

  import java.io.IOException;
  import java.util.ArrayList;
  import java.util.List;
  import javax.servlet.ServletException;
  import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest;
  import javax.servlet.http.HttpServletResponse;

import noticemanager.NoticeManager;

 
   /**
    * 
    * @author Administrator
    * 完成查看所有通告请求的控制
    */

   public class NoticeInfo  extends HttpServlet{
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 
		   NoticeManager noticeManager=NoticeManager.getInstance();
	       List list =noticeManager.findAllNotice();
	       req.setAttribute("noticeList",list);
		
		   req.getRequestDispatcher("/WEB-INF/noticejsp/FindAllNotice.jsp").forward(req, resp);

			
		}

    }