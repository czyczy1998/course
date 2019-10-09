<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/admin_index.css"/>
	</head>
	<body>
		<div id="header">
			
		</div>
		<div id="left">
			<ul id="nav">
				<li><a href="${pageContext.request.contextPath }/admin/classManager?method=getAll" target="content">班级管理</a></li>
				<li><a href="${pageContext.request.contextPath }/admin/student?method=getAll" target="content">学生管理</a></li>
				<li><a href="${pageContext.request.contextPath }/admin/course?method=getAll&pageNo=1" target="content">课程管理</a></li>
				<li><a href="${pageContext.request.contextPath }/admin/scoreIn/scoreInManager?method=getAll" target="content">成绩录入</a></li>
			</ul>
		</div>
		<div id="right">
			<iframe id="iframe" name="content" src="${pageContext.request.contextPath }/admin/course?method=getAll&pageNo=1" width="100%" height="700px"></iframe>
		</div>
	</body>
</html>
