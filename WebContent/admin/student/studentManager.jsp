<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/common.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/admin-common.css"/>
		<script src="${pageContext.request.contextPath }/js/jquery.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath }/js/admin-student.js" type="text/javascript" charset="utf-8"></script>
		<style type="text/css">
			a{
				text-decoration:none;
			}
			#student-add{
				display:block;
				width:100px;
				height:40px;
				text-align:center;
				line-height:40px;
				font-size:18px;
				background:darkGreen;
				color: #fff;
				border-radius: 10px;
				
				margin-left:100px;
			}
			#add-div{
				margin:20px 0;
			}
		
		</style>
	</head>
	<body>
		<div id="class-title">
			学生列表
		</div>
		<div id="add-div">
			<a id="student-add" href="${pageContext.request.contextPath }/admin/student?method=showAdd">添加</a>		
		</div>
		<table cellspacing="0" id="table">
			<tr>
				<th>学号</th>
				<th>姓名</th>
				<th>密码</th>
				<th>班级</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${students }" var="s">
			<tr>
				<td>${s.stunum }</td>
				<td>${s.stuname }</td>
				<td>${s.password }</td>
				<td>${s.classname }</td>
				<td>
					<a href="${pageContext.request.contextPath }/admin/student?method=showEdit&stuid=${s.stuid}">编辑</a>
					<a href="${pageContext.request.contextPath }/admin/student?method=delete&stuid=${s.stuid}">删除</a>
				</td>
			</tr>
			</c:forEach>
			
			
		</table>
		
	</body>
</html>
