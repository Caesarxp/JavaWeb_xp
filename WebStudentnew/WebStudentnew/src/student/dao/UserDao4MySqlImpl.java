
  package student.dao;

  import java.sql.Connection;
  import java.sql.DriverManager;
  import java.sql.PreparedStatement;
  import java.sql.ResultSet;
  import java.sql.SQLException;
  import java.sql.Statement;
  import java.util.ArrayList;
  import java.util.List;

import mode.ClassBean;
  import mode.GradeBean;
  import mode.NoticeBean;
  import mode.StudentBean;
import util.DB;
   

  /**
   * 用户MySqlDao实现
   */
  public class UserDao4MySqlImpl implements UserDao{
	Connection conn = null;
	Statement sta = null;
	ResultSet rs = null;
	String sql = null;
	PreparedStatement pstmt = null;
	List list = new ArrayList();
	
	 
	/**
	 * 查找所有学生信息���������û�
	 * @param username
	 * @return list 
	 */
	
	public List findStudentByName(String username) {
		 
		if(username==null) 
			sql="select * from register";
		 else 
			sql="select * from register where name like '%" +username+"%'";
		 
		try{
		conn = DB.getConn();
		sta = conn.createStatement();
		rs = sta.executeQuery(sql);
		while(rs.next()){
		    StudentBean bean = new StudentBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setPassword(rs.getString(3));
			bean.setSex(rs.getString(4));
			bean.setEmail(rs.getString(5));
			list.add(bean);
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
	    * 查找学生的成绩
	    * @param：username
	    * @return list
	    * 
	    */
    public List findGreadByName(String username)
    { 
 	  
 	   
            /**
             * 学生表register 课程表class 成绩表grade，通过等值连接完成关联查询
             */
 	   if(username==null)  
 	   sql="select grade.id,register.name,class.class,class.teacher,class.score,grade.grade1 from grade,class,register where  (grade.stu_id=register.id) and (grade.class_id=class.id)";
 	   else
 	   sql="select grade.id,register.name,class.class,class.teacher,class.score,grade.grade1 from grade,class,register where  (grade.stu_id=register.id) and (grade.class_id=class.id)and register.name like '%" +username+"%'"; 
 	   try{
 		    conn = DB.getConn();
 			sta = conn.createStatement();
 			rs = sta.executeQuery(sql);
 			
 			 while(rs.next()){
 			    GradeBean grade=new GradeBean();
 				grade.setId(rs.getInt(1));
 				grade.setStu_name(rs.getString(2));
 				grade.setClass_name(rs.getString(3));
 				grade.setClass_teacher(rs.getString(4));
 				grade.setClass_score(rs.getString(5));
 				grade.setStu_grade(rs.getString(6));
 				list.add(grade);
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
	  *  
	  * 通过ID查找通告信息 ���������û� 
	  * @param id
	  * @return NoticeBean
	  */
	 public NoticeBean findNoticeById(int id)
	 {    NoticeBean notice=null;
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
	  *查找所有课程 ���������û� 
	  * @param null
	  * @return List 
	  */
	public List findAllClass()
    {
		sql="select * from class";
		try{
		conn = DB.getConn();
		sta = conn.createStatement();
		rs = sta.executeQuery(sql);
		
		 while(rs.next()){
			 ClassBean classBean=new ClassBean();
			 classBean.setId(rs.getInt("id"));
			 classBean.setClassName(rs.getString("class"));
			 classBean.setTeacher(rs.getString("teacher"));
			 classBean.setScore(rs.getString("score"));
			 list.add(classBean);
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
    }
	