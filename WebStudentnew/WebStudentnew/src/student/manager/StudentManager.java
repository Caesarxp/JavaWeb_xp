
   package student.manager;

   import java.util.ArrayList;
   import java.util.List;
   import noticedao.NoticeDao;
   import noticedao.NoticeDaoImpl;
   import mode.NoticeBean;
   import student.dao.UserDao;
   import student.dao.UserDao4MySqlImpl;


    public class StudentManager {
	  /**
	   * �û���tgg管理员账号管理业务类-单例模式����
	   * @author Administrator
	   * 
	   */

	  static private StudentManager instance=null;
		  
		  private StudentManager()
		  {}
			 
		  static public synchronized StudentManager getInstance()
		  {
			 if(instance==null)
			 {
				 instance=new StudentManager(); 
				 
			 }
		     return instance;
		  }
		  
		  /**
			  *查找所有学生信息 ���������û� 
			  * @param 学生名字
			  * @param List 
			  */
			public List findStudentByName(String username)
		    { 
			  UserDao dao=new UserDao4MySqlImpl();
		      List allStudent=dao.findStudentByName(username);
		      return allStudent;
		    }
			
			/**
			  *查找所有成绩信息 ���������û� 
			  * @param 学生名字
			  * @param List 
			  */
			public List findGreadByName(String username)
		    {
			  UserDao dao=new UserDao4MySqlImpl();
		      List allGread=dao.findGreadByName(username);
		      return allGread;
		    }
			
			
			/**
			  *查找所有通告 ���������û� 
			  * @param null
			  * @return List 
			  */
			public List findAllNotice()
		    {
			   UserDao dao=new UserDao4MySqlImpl();
		       List allNotice=dao.findAllNotice();
		       return allNotice;
		    }
   
			/**
			  *查找所有课程 ���������û� 
			  * @param null
			  * @return List 
			  */
			public List findAllClass()
		    {
			   UserDao dao=new UserDao4MySqlImpl();
		       List allClass=dao.findAllClass();
		       return allClass;
		    }
			/**
			  *  
			  * 通告ID查找通告信息 ���������û� 
			  * @param id
			  * @return NoticeBean
			  */
			public NoticeBean findNoticeById(int id)
			{ 
				NoticeDao dao =new NoticeDaoImpl();
				NoticeBean noticeBean=dao.findNoticeById(id);
			    return noticeBean;
			}
    }	 
