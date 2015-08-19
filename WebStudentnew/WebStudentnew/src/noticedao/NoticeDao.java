 
  
  package noticedao;

   
  import java.util.ArrayList;
  import java.util.List;
  import forms.NoticeForm;
  import mode.NoticeBean;
   
 

  /**
   * 
   * @author Administrator
   * 通告持久层接口
   */
  public interface NoticeDao {
	   
	   List list = new ArrayList();
	   
	  
	  /**查找所有通告 ���������û� 
	  * @param null
	  * @param List 
	  */
	public List findAllNotice();
   
	    /**
	     * 添加通告 ���������û� 
	     * @param noticeForm
	     * @return null 
	     */
	 public void addNotice(NoticeForm noticeForm);
	 
	 /**
	  *  
	  * 通过ID查找通告信息 ���������û� 
	  * @param id
	  * @return NoticeBean
	  */
	 public NoticeBean findNoticeById(int id);
	  
	    /**
		 * 更新通告信息
		 * @param noticeForm
		 * @return null
		 */
		public void updateNotice(NoticeForm noticeForm);
		 
		/**
		 * 删除通告信息
		 * @param id
		 * @return null
		 */
		public void noticeDel(int id);
		 
      }
