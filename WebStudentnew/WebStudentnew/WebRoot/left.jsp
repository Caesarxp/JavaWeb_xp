<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>����Ա����</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<%=path %>/css/base.css" type="text/css" />
	<link rel="stylesheet" href="<%=path %>/css/dtree.css" type="text/css" />
	<style type="text/css">
	    div {
			padding:0px;
			margin:0px;
		}
		
		body {
		 scrollbar-base-color:#bae87c;
		 scrollbar-arrow-color:#FFFFFF;
		 scrollbar-shadow-color:#c1ea8b;
		 padding:0px;
		 margin:auto;
		 text-align:center;
		 background-color:#ffffff;
		 background:url(images/bg.gif);
		}
		
		.bitem {
		  background:url(images/side_snow.gif);
		  height:26px;
		  line-height:26px;
		  text-align:center;
		  cursor:pointer;
		  background-repeat: no-repeat;
		  margin-top:0px;
			
		}
		.title{
			margin-left:2px;
			background:url(images/menubg.gif);
			background-repeat:no-repeat;
			text-align:center;
			cursor:pointer;
			height:26px;
		  	line-height:26px;
	</style>
	<script language='javascript'>var curopenItem = '1';</script>
	<script language="javascript" type="text/javascript" src="js/menu.js"></script>
	<base target="main" />
  </head>
  <body target="main">
  	<div class='bitem'>
  	
  	<div class='title'><tr>ѧ����Ϣ</tr><br></div>
  		<tr><a href='<%=path %>/studentInfo' target='main'>ѧ����Ϣ����</a></tr><br>
  	</div>
  
  	<div class='bitem'>
  		<div class='title'><tr >ѧ���ɼ�</tr><br/></div>
  		<tr><a href='<%=path %>/StudentgradeInfo' target='main'>ѧ���ɼ�����</a></tr><br>
  		<tr><a href='<%=path %>/GradeAdd' target='main'>ѧ���ɼ�¼��</a></tr><br>

  	</div>
  	<div class='bitem'>
  		<div class='title'><tr >�γ�</tr><br/></div>
  		<tr><a href='<%=path %>/FindAllCourseInfo' target='main'>�γ̹���</a></tr><br>
  	    <tr><a href='<%=path %>/courseAdd' target='main'>�γ�¼��</a></tr><br>

  	</div>
  	
  	<div class='bitem'>
  		<div class='title'><tr >ͨ��</tr><br></div>
  		<tr><a href='<%=path %>/NoticeInfo' target='main'>ͨ����Ϣ����</a></tr><br>
  		<tr><a href='<%=path %>/ForwardAddNotice' target='main'>����ͨ��</a></tr>
  	</div>
  	<div class='bitem'>
  		<div class='title'><tr>����Ա�˺�</tr><br></div>
  		<tr><a href='<%=path %>/AdminInfo' target='main'>����Ա�˺Ź���</a></tr><br>
  		<tr><a href='<%=path %>/UpdataAdmin' target='main'>�޸�����</a></tr>
  	</div>
  </body>
</html>