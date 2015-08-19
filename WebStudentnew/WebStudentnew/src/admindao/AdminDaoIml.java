 
   package admindao;

   import java.sql.Connection;
   import java.sql.PreparedStatement;
   import java.sql.ResultSet;
   import java.sql.SQLException;
   import java.sql.Statement;
   import java.util.ArrayList;
   import java.util.List;
   import forms.AdminPasswordForm;
   import mode.UseBean;
   import util.DB;
  
  
  /**
   * 
   * @author Administrator
   * 管理员持久层实现
   */

   public class AdminDaoIml implements AdminDao {
	  String  sql=null;
	   Connection conn = null;
	   Statement sta = null;
	   ResultSet rs =null;
	   List list = new ArrayList();
	   PreparedStatement pstmt = null;
	   public AdminDaoIml()
       {}
	  
	  /**
		  *查找所有管理员信息 ���������û� 
		  * @param null
		  * @return List 
		  */
	  public List findAllAdmin()
    {   sql="select * from user";
       try{
        conn = DB.getConn();
	    sta = conn.createStatement();
	    rs = sta.executeQuery(sql);
	
	    while(rs.next()){
	    UseBean useBean=new UseBean();
	    useBean.setId(rs.getInt(3));
	    useBean.setPassword(rs.getString(2));
	    useBean.setUseName(rs.getString(1));
		 
		list.add(useBean);
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
		  *取得管理员信息 ���������û� 
		  * @param 管理员姓名
		  * @return UseBean 
		  */
	  public UseBean findAdminPsaaword (String adminName)
		{
		  sql="select * from user where usename='"+adminName+"'";
		  UseBean useBean=null;
		    try {
		    	conn = DB.getConn();
		    	sta = conn.createStatement();
		    	rs = sta.executeQuery(sql);
		    	if(rs.next()){
		    	    useBean=new UseBean();
		    	    useBean.setId(rs.getInt(3));
		    	    useBean.setPassword(rs.getString(2));
		    	    useBean.setUseName(rs.getString(1));
		    	     } 
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
			        return useBean;
			    } 
   
	     /**
		  *修改管理员密码 ���������û� 
		  * @param adminpasswordForm
		  * @return null 
		  */
	   public void updataAdminPasswordFinsh(AdminPasswordForm adminpasswordForm)
       {   int id=adminpasswordForm.getId();
           String newPassword=adminpasswordForm.getNewPw2();
       try {
           
            sql="update user set password='"+newPassword+"' where id="+id;
		    conn = DB.getConn();  
			sta = conn.createStatement();
			sta.executeUpdate(sql); 
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
		      
		    } 
      }
