 
  package noticedao;

  import java.sql.Connection;
  import java.sql.PreparedStatement;
  import java.sql.ResultSet;
  import java.sql.SQLException;
  import java.sql.Statement;
  import java.util.ArrayList;
  import java.util.List;
  import forms.NoticeForm;
  import mode.NoticeBean;
  import util.DB;

  /**
   * 
   * @author Administrator
   * 通告持久层实现
   */
  public class NoticeDaoImpl implements NoticeDao  {
	   String  sql=null;
	   Connection conn = null;
	   Statement sta = null;
	   ResultSet rs =null;
	   List list = new ArrayList();
	   PreparedStatement pstmt = null;
	   NoticeBean notice;
	  /**查找所有通告 ���������û� 
	  * @param null
	  * @param List 
	  */
	public List findAllNotice()
    {
		try{
             
			sql="select id,head,time from title";
 		    conn = DB.getConn();
 			sta = conn.createStatement();
 			rs = sta.executeQuery(sql);
 			
 			 while(rs.next()){
 			    NoticeBean notice=new NoticeBean();
 			    notice.setId(rs.getInt("id"));
 			    notice.setHead(rs.getString("head"));
 			    notice.setTime(rs.getString("time"));
 				list.add(notice);
 			   }
 	         }catch(Exception e){
			      e.printStackTrace();
		         }finally{
			       try {
				      if(rs != null) {
					    rs.close();
					    rs = null;
				        }
				      if(sta != null) {
					    sta.close();
					    sta= null;
				       }
				      if(conn != null) {
					    conn.close();
					    conn = null;
				      }
			       } catch (SQLException e) {
				      e.printStackTrace();
			       }
		      }
		        return list;
		     } 
  
	    /**
	     * 添加通告 ���������û� 
	     * @param noticeForm
	     * @return null 
	     */
	 public void addNotice(NoticeForm noticeForm)
	 {
	   sql="insert into title (head,text,time) values ('"+noticeForm.getTitle()+"','"+noticeForm.getText()+"','"+noticeForm.getDate()+"')";
	  
	   try {
	    conn = DB.getConn();
	    sta = conn.createStatement();
		sta.executeUpdate(sql);
	   } catch (SQLException e) {
		 
		e.printStackTrace();
	  }finally{
	       try {
			      if(rs != null) {
				    rs.close();
				    rs = null;
			        }
			      if(sta != null) {
				    sta.close();
				    sta= null;
			       }
			      if(conn != null) {
				    conn.close();
				    conn = null;
			      }
		       } catch (SQLException e) {
			      e.printStackTrace();
		       }
	      }
	       
	     } 
    
	 /**
	  *  
	  * 通过ID查找通告信息 ���������û� 
	  * @param id
	  * @return NoticeBean
	  */
	 public NoticeBean findNoticeById(int id)
	 {   
		 sql="select * from title where id='"+id+"'";
		 try {
			 conn = DB.getConn();
			 sta = conn.createStatement();
			 rs = sta.executeQuery(sql);
			 if(rs.next()){
			 notice=new NoticeBean();
			 notice.setId(rs.getInt("id"));
		     notice.setHead(rs.getString("head"));
		     notice.setText(rs.getString("text"));}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
		       try {
				      if(rs != null) {
					    rs.close();
					    rs = null;
				        }
				      if(sta != null) {
					    sta.close();
					    sta= null;
				       }
				      if(conn != null) {
					    conn.close();
					    conn = null;
				      }
			       } catch (SQLException e) {
				      e.printStackTrace();
			       }
		      }
		        return notice;
		     } 
    
	    /**
		 * 更新通告信息
		 * @param noticeForm
		 * @return null
		 */
		public void updateNotice(NoticeForm noticeForm)
		{
			sql="update title set head='"+noticeForm.getTitle()+"',text='"+noticeForm.getText()+"' where id="+noticeForm.getId();
			
			 try {
				 conn = DB.getConn();
				 sta = conn.createStatement();
				 sta.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
			       try {
					       
					      if(sta != null) {
						    sta.close();
						    sta= null;
					       }
					      if(conn != null) {
						    conn.close();
						    conn = null;
					      }
				       } catch (SQLException e) {
					      e.printStackTrace();
				       }
			      }
			       
			     } 
     
		/**
		 * 删除通告信息
		 * @param id
		 * @return null
		 */
		public void noticeDel(int id)
		{
			sql="delete from title where id = "+id;
			try {
				conn = DB.getConn();
				sta = conn.createStatement();
				sta.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
			       try {
				       
					      if(sta != null) {
						    sta.close();
						    sta= null;
					       }
					      if(conn != null) {
						    conn.close();
						    conn = null;
					      }
				       } catch (SQLException e) {
					      e.printStackTrace();
				       }
			      }
			       
			     } 
      }
