
  package coursedao;

  import java.sql.Connection;
  import java.sql.DriverManager;
  import java.sql.PreparedStatement;
  import java.sql.ResultSet;
  import java.sql.SQLException;
  import java.sql.Statement;
  import java.util.ArrayList;
  import java.util.List;
  import mode.ClassBean;
import util.DB;
   

  /**
   * 课程CourseDao实现
   */
  public class CourseDao4MySqlImpl implements CourseDao{
	Connection conn = null;
	Statement sta = null;
	ResultSet rs = null;
	String sql = null;
	PreparedStatement pstmt = null;
	List list = new ArrayList();
	
	 
	 
	 
  
     
	  
	 /**
	  *查找所有课程 ���������û� 
	  * @param null
	  * @return List 
	  */
	public List findAllCourse()
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
	
	/**
	  *根据id查找课程 ���������û� 
	  * @param id
	  * @return classBean 
	  */
	public ClassBean findAllCourseById(int id)
	{   sql="select * from class where id='"+id+"'" ;
	   ClassBean classBean=null;
	  try{
		conn = DB.getConn();
		sta = conn.createStatement();
		rs = sta.executeQuery(sql);
		
		 if(rs.next()){
			 classBean=new ClassBean();
			 classBean.setId(rs.getInt("id"));
			 classBean.setClassName(rs.getString("class"));
			 classBean.setTeacher(rs.getString("teacher"));
			 classBean.setScore(rs.getString("score"));
			 
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
	        return classBean;
	     } 
  
	 /**
	  * 更新课程信息
	  * @param classBean
	  * @return null 
	  */
	  public void updateCourse(ClassBean classBean)
	  {
		 sql="update class set class='"+classBean.getClassName()+"',teacher='"+classBean.getTeacher()+"',score='"+classBean.getScore()+"' where id="+classBean.getId();
	    try{                                                                                         
			conn = DB.getConn();
			sta = conn.createStatement();
			sta.executeUpdate(sql);
			
			 
	        }catch(Exception e){
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
		 * 删除课程信息
		 * @param id
		 * @return null 
		 */
		public void delCourse(int id) 
		{
			try {
				sql="delete from class where id = "+id;
				conn = DB.getConn();
				sta = conn.createStatement();
			 
				 sta.executeUpdate(sql);
			}  catch (Exception e) {
				e.printStackTrace();
			} finally {
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
		 * 添加课程信息
		 * @param classBean
		 * @return null 
		 */
		public void addCourse(ClassBean classBean)
		{
			sql="insert into class (class,teacher,score) values ('"+ classBean.getClassName()+"','"+
			classBean.getTeacher()+"','"+classBean.getScore()+"')";
			 try{                                                                                         
					conn = DB.getConn();
					sta = conn.createStatement();
					sta.executeUpdate(sql);
					
					 
			        }catch(Exception e){
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
	