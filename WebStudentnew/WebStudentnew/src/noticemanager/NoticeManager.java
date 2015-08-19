                      
  package noticemanager;

  import java.util.List;
  import forms.NoticeForm;
  import mode.NoticeBean;
  import noticedao.NoticeDao;
  import noticedao.NoticeDaoImpl;
 
 

  /**
   * �û���tg通告处理业务类-单例模 式����
   * @author Administrator
   * 
   */

  public class NoticeManager {

  static private NoticeManager instance=null;
	  
	  private NoticeManager()
	  {}
		 
	  static public synchronized NoticeManager getInstance()
	  {
		 if(instance==null)
		 {
			 instance=new NoticeManager(); 
			 
		 }
	     return instance;
	  }
	  
	  /**
		  *查找所有通告 ���������û� 
		  * @param null
		  * @return List 
		  */
		public List findAllNotice()
	    {
		   NoticeDao dao =new NoticeDaoImpl();
	       List allNotice=dao.findAllNotice();
	       return allNotice;
	    }
		
		/**
		  * 添加通告 ���������û� 
		  * @param noticeForm
		  * @return null 
		  */
		public void addNotice(NoticeForm noticeForm)
		{
			NoticeDao dao =new NoticeDaoImpl();
			dao.addNotice(noticeForm);
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
		
		/**
		 * 更新通告信息
		 * @param noticeForm
		 * @return null
		 */
		
		public void updateNotice(NoticeForm noticeForm)
		{
			NoticeDao dao =new NoticeDaoImpl();
			dao.updateNotice(noticeForm);
			
		}
		
		/**
		 * 删除通告信息
		 * @param id
		 * @return null
		 */
		public void noticeDel(int id)
		{
		   NoticeDao dao =new NoticeDaoImpl();
		   dao.noticeDel(id);
		}
  }
