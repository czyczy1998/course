<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/common.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/admin-common.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/admin-course.css"/>
		<script src="${pageContext.request.contextPath }/js/jquery.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath }/js/admin-class.js" type="text/javascript" charset="utf-8"></script>
		
	</head>
	<body>
		<div id="class-title">
			课程列表
		</div>
		<div id="add-div">
			<a id="course-add" href="${pageContext.request.contextPath }/admin/course?method=showAdd">添加</a>		
		</div>
		<table cellspacing="0">
			<tr>
				<th>课程名称</th>
				<th>课程时长</th>
				<th>课程分数</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${courses }" var="c">
			<tr>
				<td>${c.coursename }</td>
				<td>${c.hour }</td>
				<td>${c.score }</td>
				<td>
					<a href="">编辑</a>
					<a href="">删除</a>
				</td>
			</tr>
			</c:forEach>
			
			
		</table>
		<div id="fenye">
			<div class="page">
				<c:if test="${pageNo > 1 }">
					<a href="${pageContext.request.contextPath }/admin/course?method=getAll&pageNo=${pageNo-1}"> &lt; </a>
				</c:if>
				<c:if test="${pageNo <= 1 }">
					&lt;
				</c:if>
			</div>
			<div class="page">
				${pageNo }
			</div>
			<div class="page">
			<c:if test="${pageNo < pageSum }">
				<a href="${pageContext.request.contextPath }/admin/course?method=getAll&pageNo=${pageNo+1}"> &gt; </a>
			</c:if>
			
			<c:if test="${pageNo >= pageSum }">
					&gt;
			</c:if>
			</div>
			<div class="page">
				${pageSum }
			</div>
			<div class="page">
				${totalRecord}
			</div>
		</div>
	</body>
</html>
