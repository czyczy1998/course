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
				<li><a href="${pageContext.request.contextPath }/student/selection?method=getAll" target="content">选课管理</a></li>
				
			</ul>
		</div>
		<div id="right">
			<iframe id="iframe" name="content" src="${pageContext.request.contextPath }/student/selection?method=getAll" width="100%" height="700px"></iframe>
		</div>
	</body>
</html>
