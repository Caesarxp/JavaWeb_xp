
  package infodao;

  import java.sql.Connection;
  import java.sql.DriverManager;
  import java.sql.PreparedStatement;
  import java.sql.ResultSet;
  import java.sql.SQLException;
  import java.sql.Statement;
  import java.util.ArrayList;
  import java.util.List;
  import mode.StudentBean;
  import util.DB;
  import forms.LoginForm;
import forms.RegisterFrom;

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
	 * 用户登录
	 * @param 用户名，密码，身份
	 * @return boolean 
	 */
	public boolean con(String name,String password,int shenfen){
		System.out.print(name+password+shenfen);
		try{
			if(shenfen==1){
			sql="select * from user where usename='"+name+"' and password='"+password+"'";}
			if(shenfen==0){
			sql="select * from register where name='"+name+"' and password='"+password+"'";}
			
			conn = DB.getConn();
			sta = conn.createStatement();
			rs = sta.executeQuery(sql);
			 
			if(rs.next()){
				System.out.print(rs.getString(1)+" "+rs.getString(2));
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;	
		}finally{
			DB.closeRs(rs);
			DB.closeStmt(sta);
			DB.closeConn(conn);
		}
		return false;
	}

	/**
	 * 用户注册
	 * @param RegisterFrom
	 * @return boolean 
	 */
	public boolean registerByName(RegisterFrom regf)
	{
		    sql = "select * from register where name=?"; 
		 
		  
		try  {
			 
			conn = DB.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, regf.getName());
			rs = pstmt.executeQuery();
			if (!rs.next()) {
				sql="insert into register (name,password,sex,email) values ('"+ regf.getName()+"','"+
				regf.getPassword()+"','"+regf.getRadio()+"','"+regf.getEmail()+"')";
				pstmt.executeUpdate(sql);
				return true;
			    }
			 
		}
		catch (Exception e) {
		   e.printStackTrace();  
		} finally {
			DB.closeRs(rs);
			DB.closeStmt(sta);
			DB.closeConn(conn);
		}
		 return false;
	}

	/**
	 * 查找所有用户���������û�
	 * @param null
	 * @return list 
	 */
	
	public List findAllUser(String username) {
		 
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
	 * 删除指定用户
	 * @param String id
	 * @return int rs
	 */
	public int delUserById(String id)
	{
		String sql=null;
		int rs = 0;
		Connection conn = null;
		Statement sta = null;
		 

		try {
			sql="delete from register where id = "+id;
			conn = DB.getConn();
			sta = conn.createStatement();
		 
			rs=sta.executeUpdate(sql);
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
		return rs;
	}
 
	/**
	 *根据id查找指定用户
	 * @param String id
	 * @return StudentBean
	 */
	public StudentBean findUserById(String id)
	{StudentBean bean=null;
		try{
			
		sql="select * from register where id='"+id+"'";
		 
	 	conn = DB.getConn();
		sta = conn.createStatement();
		rs = sta.executeQuery(sql);
		if (rs.next()){
			//System.out.println(rs.getInt(1)+rs.getString(2)+rs.getString(3)+rs.getString(4)+rs.getString(5));
		    bean = new StudentBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setPassword(rs.getString(3));
			bean.setSex(rs.getString(4));
			bean.setEmail(rs.getString(5));
		 
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
		return bean;
		}
	
	/**
	 *根据对用户的数据进行编辑
	 * @param RegisterFrom,String id
	 * @return boolean
	 */
	public boolean modifyUser(StudentBean regf,String id)
	{
		String name=regf.getName();
		String password=regf.getPassword();
		String sex=regf.getSex();
		String email=regf.getEmail();
		System.out.print(name+password+sex+email);
		sql="update register set name='"+name+"',password='"+password+"',sex='"+sex+"',email='"+email+"' where id="+id;
		 
		  
		try  {
			conn = DB.getConn();
			sta = conn.createStatement();
			sta.executeUpdate(sql);
			return true; 
		}
		catch (Exception e) {
		   e.printStackTrace();  
		} finally {
	
			DB.closeStmt(sta);
			DB.closeConn(conn);
		}
		 return false;
	}
	
  }
	