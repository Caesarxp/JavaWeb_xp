<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>书单</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="text-align:center"><br/>
  <h1>我的藏书</h1>
  <table border="1" width="80%">
	<tr>
		<th>序号</th>
		<th>ISBN</th>
		<th>书名</th>
		<th>作者</th>
		<th>价格</th>
		<th>描述</th>
	</tr>
	<c:forEach items="${books}" var="me" varStatus="vs">
		<tr bgcolor="${vs.index%2==0?'#628C8C':'#A655A0' }">
			<td>${vs.count}</td>
			<td>${me.value.ISBN}</td>
			<td>${me.value.name}</td>
			<td>${me.value.author}</td>
			<td>${me.value.price}</td>
			<td>${me.value.description}</td>
			<td>[<a href="${pageContext.request.contextPath}/servlet/BuyServlet?bookId=${me.key}">购买</a>]</td>
		</tr>
		<!-- jsp的页面属性，java中的？后面的语法运用 -->
	 </c:forEach>
  </table>
  	<a href="${pageContext.request.contextPath}/servlet/ShowCartServlet">查看我的购物车</a>
  </body>
</html>
