<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>计算器</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <form name="calcu" action="action/cal.do" method="post">
    <input type="text" name="value1" />
    <select name="flag">
    	<option value="+" >+</option>
    	<option value="-"  selected>-</option>
    	<option value="*">*</option>
    	<option value="/">/</option>
    </select>
    <input type="text" name="value2"/>
    <input type="submit" name="button" value="=" >
    </form>
    
    

  </body>
 
</html>
