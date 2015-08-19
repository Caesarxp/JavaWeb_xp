package com.chat.dao;


import java.sql.*; 


	public class userDao 
	{ 
	String dbDriver="com.mysql.jdbc.Driver";
	String dbUrl="jdbc:mysql:///chatData"; 
	String theUser="root"; 
	String thePw="123456"; 
	Connection conn=null; 

	 
	public userDao() 
	{ 
	try{ 
	Class.forName(dbDriver); 
	conn = DriverManager.getConnection(dbUrl,theUser,thePw); 
	 
	}catch(Exception e){ 
	e.printStackTrace(); 
	} 
	} 

	/**
		 * 添加用户
		 * @param  用户名，密码
		 * @return boolean类型
		 */
	public boolean addUser(String userName,String passWord)
	{ 
	PreparedStatement pstmt = null;
	String sql = "insert into user_table(name, password)"
					+ "values( ?,?)";
	 try 
	{
	 pstmt = conn.prepareStatement(sql);
	 pstmt.setString(1, userName);
	 pstmt.setString(2, passWord);
	 pstmt.executeUpdate(); 	
	 return true; 
	}
	catch (SQLException e) 
	 { 
	 e.printStackTrace(); 
	 return false; 
	 }
	finally {
	try
	{
	pstmt.close(); 
	 
	}
	catch (Exception e)
	{e.printStackTrace();
	  }
	 }
	}
	
	
	/**
		 * 根据用户用户名查询用户
		 * @param  用户userName
		 * @return boolean类型
		 */
	public String findUserByName(String userName) 
	{
		
	 PreparedStatement pstmt = null;
	 ResultSet rs=null;
	 String sql="select * from user_table where name=?";
	try 
	{ 
	 pstmt = conn.prepareStatement(sql);
	 pstmt.setString(1, userName);
	 rs=pstmt.executeQuery(); 
	if (rs.next()==true) 
	{ 
		String password=rs.getString("password");

	return rs.getString("password");
	} 
	} 
	catch (SQLException e) 
	{ 
	e.printStackTrace(); 
	} 
	finally {
	try
	{
	rs.close();
	pstmt.close(); 
	}
	catch (Exception e)
	{e.printStackTrace();
	}
	}
	return ""; 
	} 
	public void close() 
	{ 
	try 
	{ 
	conn.close(); 

	} 
	catch (Exception e) 
	{ 
	e.printStackTrace(); 
	} 
	}
	
}
	 

