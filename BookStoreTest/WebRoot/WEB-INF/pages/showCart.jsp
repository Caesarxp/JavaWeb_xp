<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>购物车</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="text-align: center;">
     <br>
     <h1>你购买的东西如下：</h1>
     <!-- jstl与el表达式的运用，判断cart和items是否为空  -->
	     <c:if test="${empty sessionScope.cart.items}">
	     你还没有购买书籍
	     </c:if>
	    
	     <c:if test="${!empty sessionScope.cart.items}">
	     	<table border="1" width="88%">
	     		<tr>
	     			<th>序号</th>
	     			<th>书名</th>
	     			<th>单价</th>
	     			<th>数量</th>
	     			<th>小计</th>
	     			<th>操作</th>
	     		</tr>
	     		<c:forEach items="${sessionScope.cart.items}" var="me" varStatus="vs" >
	     			<tr bgcolor="${vs.index%2==0?'#628C8C':'#A655A0' }">
	     				<td>${vs.count}</td>
	     				<td>${me.value.book.name}</td>
	     				<td>${me.value.book.price}</td>
	     				<td>
	     					<input type="text" name="num" value="${me.value.num}" size="3" onchange="changeNum(this,'${me.key}',${me.value.num})"/>
	     				</td>
	     				<td>${me.value.price}</td>
	     				<td>
	     					【<a href="javascript:delone('${me.key}')">删除</a>】
	     				</td>
	     			</tr>
	     		</c:forEach>
	     		<tr>
	     			<td colspan="2">
	     				【<a href="javascript:delAll()">清空购物车</a>】
	     			</td>
	     			<td colspan="2" align="right">总计</td>
	     			<td colspan="2">${sessionScope.cart.price}</td>
	     		</tr>
	     	</table>
	     </c:if>
	      <a href="${pageContext.request.contextPath}">继续购物</a>
	      <script type="text/javascript">
	      	function changeNum(inputobj,bookId,oldnum){
	      		var newnum=inputobj.value;//新的数量
	      		var sure=window.confirm("确定要把"+newnum+"改了吗？");//返回值；点确定就返回
	      		if(sure){
	      			//alert("提交");
	      			window.location.href="${pageContext.request.contextPath}/servlet/ChangeNumServlet?bookId="+bookId+"&newnum="+newnum;
	      		}
	      		else{
	      			//alert("请返回");
	      			inputobj.value=oldnum;
	      		}
	      	}
	      	function delone(bookId){
	      		var sure=window.confirm("确定要删除吗？");
	      		if(sure){
					window.location.href="${pageContext.request.contextPath}/servlet/delOneServlet?bookId="+bookId;	      		
	      		}
	      	}
	      	function delAll(){
	      		var sure=window.confirm("你确定要清空");
	      		if(sure){
	      			window.location.href="${pageContext.request.contextPath}/servlet/delAllServlet";
	      		}
	      	}
	      	}
	      	
	      	
	      </script>
  </body>
</html>
