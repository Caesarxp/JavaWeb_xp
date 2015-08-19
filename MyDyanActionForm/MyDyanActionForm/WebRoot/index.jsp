<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>登录页面</title>
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
    <center>
    <html:form action="login.do" method="post" >
	
	<!--<bean:message key="login.username" />-->
	用户名:
	<html:text property="username"/>
   	<html:errors property="username"/><br/>
   	
 
 	<!--<bean:message key="login.userpass"/>-->
 	密&nbsp;&nbsp;&nbsp;码:
	<html:password property="userpass"/>
    <html:errors property="userpass"/><br/>
   
    <html:submit value="提交"></html:submit>
  </html:form>
    </center>
  </body>
</html>
