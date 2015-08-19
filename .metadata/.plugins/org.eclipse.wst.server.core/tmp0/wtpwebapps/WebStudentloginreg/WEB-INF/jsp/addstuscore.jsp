 <%@ page isELIgnored="false" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

	<!-- 	<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />	 -->
	<script>
	var ret = '${retMsg}';
	if(ret != "") {
	 if(ret == 0)
	 alert("添加失败");
	 if(ret == 1)
	 alert("已经存在此记录");
	 
	 if(ret == 2)
	 alert("添加成功");
	 
	 
	}
	
	</script>
        <script language="javascript">
  
        function check1(){
          var  f=document.formAdd;
		  var reg = /^(100|100.0|[1-9]{1,2}\.{0,1}(\d){0,1})$/;
		    if(f.grade.value > 100)
		    {
		     alert("输入的分数不合法");
		     f.grade.value = "";
		     return false;
		     }
		  
		  if(!reg.test(f.grade.value))
		   {
			  alert("输入的分数不合法，只保留一位小数");
			  f.grade.value = "";
			  return false;
		   }
	        document.formAdd.submit();
			}
           
       </script>
		<style type="text/css">
		body {
			 background:url(images/bg.gif);
			}
	</style>
        
	</head>

	<body leftmargin="2" topmargin="2" >
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="6" align='center'>&nbsp;管理员维护&nbsp;</td>
				</tr>
				<form action="<%=path %>/addstuscore" name="formAdd" method="post">
				<tr>
				<td>成绩录入</td>
				</tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr>
					 <td width="15%" bgcolor="#FFFFFF" align="left">  请选择学生名：</td>
				    <td width="15%" bgcolor="#FFFFFF" align="left">
				        <select type="text" name="userName" size ="1"   style="width:130px">
				        <c:forEach items = "${stucouInfo}" var = "stud" begin ="0" end ="0" >
				        <c:forEach items ="${stud}" var ="map">
				        <option value="${map.key }:${map.value}">${map.value}</option>
				        </c:forEach>
				        </c:forEach>
				        </select>
				       
				    </td>
				    <td width="15%" bgcolor="#FFFFFF" align="left">  请选择课程名：</td>
				     <td width="25%" bgcolor="#FFFFFF" align="left">
				         <select type="text" name="courseName" style="width:130px" >
				        <c:forEach items = "${stucouInfo}" var = "stud" begin ="1" end ="1" >
				        <c:forEach items ="${stud}" var ="map">
				        <option value="${map.key }:${map.value}">${map.value}</option>
				        </c:forEach>
				        </c:forEach>
				        </select>
				        
				    </td>
				    <td>请输入分数：</td>
				    <td> 
				    <input type="text" name="grade"/>
				    <input type="button" value="提交" onClick="check1()"/>&nbsp;
				    </td>
				</tr>
				</form>
			</table>
			
			
		
			<table width='98%'  border='0'>
			  
		    </table> 
		    
	</body>
</html>
