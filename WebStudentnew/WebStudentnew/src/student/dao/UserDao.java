
  package student.dao;

  import java.util.List;

import mode.NoticeBean;
   
   /**
    * 
    * @author Administrator
    * 用户dao接口
    */
   public interface UserDao {
 
	 /**
	 * 查找学生的信息
	 * @param uesrname
	 * @return list 
	 */
	
	public List findStudentByName(String username) ;
	
	
	  /**
	    * 查找学生的成绩
	    * @param：username
	    * @return list
	    * 
	    */
	public List findGreadByName(String username);  
	 
	 /**查找所有通告 ���������û� 
	  * @param null
	  * @param List 
	  */
	public List findAllNotice();
   
	/**
	  *  
	  * 通告ID查找通告信息 ���������û� 
	  * @param id
	  * @return NoticeBean
	  */
	public NoticeBean findNoticeById(int id);
   
	/**
	  *查找所有课程 ���������û� 
	  * @param null
	  * @return List 
	  */
	public List findAllClass();
   }
