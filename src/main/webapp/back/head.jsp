<%@page import="com.sx.libarary.entity.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>头部</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/public.js"></script>
	<style type="text/css">
		body{background-image: url(img/3.jpg);
			background-repeat: no-repeat;
			background-attachment: fixed;
			background-size:100% ,100px;
			width: 100%;
			height: 100px;}
	</style>
</head>

<body>
 <%
       User user=(User)session.getAttribute("user");		
  %>

	<!-- 头部 -->
	<div class="head">
		<div class="headL">

		</div>
		<div class="headR">
			<span style="color:#FFF">欢迎：<%= user.getUserName() %></span> <a href="Exit.jsp" rel="external" target="top">【退出】</a>
		</div>
	</div>
</body>
</html>