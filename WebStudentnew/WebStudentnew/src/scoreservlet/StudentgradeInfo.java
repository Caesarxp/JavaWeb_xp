
  package scoreservlet;

  import java.io.IOException;
  import java.util.List;
  import javax.servlet.ServletException;
  import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest;
  import javax.servlet.http.HttpServletResponse;
  import scoremanager.ScoreManager;

  
  /**
   * 
   * @author Administrator
   *  完成对显示所有学生成绩请求的控制
   */
   
  public class StudentgradeInfo extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
     doPost(req,resp);
       }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	  throws ServletException, IOException {
      String username = req.getParameter("username");
      ScoreManager scoreMassage=ScoreManager.getInstance();
      List list =scoreMassage.findAllScore(username);
      req.setAttribute("scoreList",list);
      req.getRequestDispatcher("/WEB-INF/scorejsp/showallstudentscore.jsp").forward(req, resp);
       }
  }