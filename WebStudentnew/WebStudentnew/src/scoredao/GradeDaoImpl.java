
  package scoredao;

   
  import java.util.ArrayList;
  import java.util.List;
  import forms.GradeFrom;
  import util.DB;
  import mode.ClassBean;
  import mode.GradeBean;
  import mode.StudentBean;
import java.sql.*;
 
  /**
   * 
   * @author Administrator
   * 成绩持久层实现
   */
   public class GradeDaoImpl implements GradeDao{
	   String  sql=null;
	   Connection conn = null;
	   Statement sta = null;
	   ResultSet rs =null;
	   List list = new ArrayList();
	   PreparedStatement pstmt = null;
	   public GradeDaoImpl()
       {}
	   
	   /**
	    * 查找所有学生的成绩
	    * @param：username
	    * @return list
	    * 
	    */
       public List findAllGread(String username)
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
     
       /**
          *查找所有学生id ���������û� 
		  * @param null
		  * @return List 
        */
		public List findAllStudentId()
       {
			sql="select id,name from register";
			conn = DB.getConn();
 			try {
				sta = conn.createStatement();
				rs = sta.executeQuery(sql);
				 while(rs.next()){
					 StudentBean studentBean=new StudentBean();
					 studentBean.setId(rs.getInt(1));
					 studentBean.setName(rs.getString(2));
	    			 list.add(studentBean);
	    			  }
 			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
          * 查找所有课程id ���������û� 
		  * @param null
		  * @return List 
        */
	    public List findAllClassId()
	    {   sql="select id,class from class";
	        conn = DB.getConn();
			try {
			sta = conn.createStatement();
			rs = sta.executeQuery(sql);
			while(rs.next()){
				 ClassBean classBean=new ClassBean();
				 classBean.setId(rs.getInt(1));
				 classBean.setClassName(rs.getString(2));
   			 list.add(classBean);
   			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
          * 插入学生成绩
		  * @param 封装成绩的表单bean
		  * @return null 
       */
	    public void addGrade(GradeFrom gradeFrom)
	    { 
	     sql="insert into grade(stu_id,class_id,grade1) values (?,?,?)";
	     
	    conn = DB.getConn();
	    
	    try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gradeFrom.getStudentId());
		    pstmt.setInt(2, gradeFrom.getClassId());
		    pstmt.setString(3, gradeFrom.getGrade());
		    pstmt.executeUpdate(); 
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}finally{
		       try {
				       
				      if(pstmt != null) {
				    	 pstmt.close();
				    	 pstmt= null;
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
          * 通过id查找成绩 ���������û� 
		  * @param 成绩标识
		  * @return GradeBean
         */
	    public GradeBean findGradeById(int id)
        {   
	    	GradeBean grade=null;
	    	                                                                                                                                        
	    	sql="select grade.id,register.name,class.class,grade.grade1 from grade,class,register where(grade.stu_id=register.id) and (grade.class_id=class.id)and grade.id='"+id+"'" ;
		    conn = DB.getConn();
		    try{
		      sta = conn.createStatement();
		      rs = sta.executeQuery(sql);
		      if(rs.next()){
			    grade=new GradeBean();
				grade.setId(rs.getInt(1));
				grade.setStu_name(rs.getString(2));
				grade.setClass_name(rs.getString(3));
				grade.setStu_grade(rs.getString(4));
			  }
           }catch(Exception e){
			      e.printStackTrace();
		         }finally{
			       try {
				      if(rs != null) {
					    rs.close();
					    rs = null;
				        }
				      if(pstmt!= null) {
				    	 pstmt.close();
				    	 pstmt= null;
				       }
				      if(conn != null) {
					     conn.close();
					     conn = null;
				      }
			       } catch (SQLException e) {
				      e.printStackTrace();
			       }
		         }
		        return grade;
		     } 
      
	    /**
         * 通过id更新学生成绩 ���������û� 
		  * @param 成绩标识、学生成绩
		  * @return null
        */
	    public void updateGrade(int id,String grade)
        {  try {
			sql="update grade set grade1='"+grade+"'where id="+id;
			conn = DB.getConn();
			sta = conn.createStatement();
			sta.executeUpdate(sql); 
        } catch (SQLException e) {
			 
			e.printStackTrace();
		}finally{
		       try {
				       
				      if(sta!= null) {
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
         * 通过id删除学生成绩 ���������û� 
		  * @param 成绩标识 
		  * @return null
        */
	     public void StudentGradeDel(int id)
        {  
	       sql="delete from grade where id = "+id;
           try {
			   conn = DB.getConn();
			   sta = conn.createStatement();
			   sta.executeUpdate(sql); 
			  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			       try {
					       
					      if(sta!= null) {
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