<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>学生选课管理</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/student-selection.css"/>
		<script src="${pageContext.request.contextPath }/js/jquery.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath }/js/student-selection.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
		<div id="container">
			<div id="left-list">
				<div id="selected-title">
					已选课程列表
				</div>
				<form id="form1" action="${pageContext.request.contextPath }/student/selection" method="post">
					<div id="btn-div">
						<input id="cancel-selection" type="submit" value="取消选择">
					</div>									
					<input type="hidden" name="method" value="cancelSelect"/>
					<div id="selected-list">
						<table>
							<tr>
								<td>
									<input type="checkbox" id="sa" value="" />全选
								</td>
								<td>课程名称</td>
								<td>学时</td>
								<td>学分</td>
								<td>学年</td>
								<td>学期</td>
							</tr>
							<c:forEach items="${selected }" var="svo">
							<tr>
								<td><input type="checkbox" name="selid"  value="${svo.selid }" /></td>
								<td>${svo.coursename }</td>
								<td>${svo.hour }</td>
								<td>${svo.score }</td>
								<td>${svo.year }</td>
								<td>${svo.strterm }</td>
							</tr>
							</c:forEach>
						</table>
					</div>
				</form>
			</div>
			
			<div id="right-list">
				<div id="selected-title">
					未选择课程列表
				</div>
				<form id="form1" action="${pageContext.request.contextPath }/student/selection" method="post">
					<input type="hidden" name="method" value="selectCourse"/>	
					<div id="btn-div">
						学年： <input type="text" name="year" id="year" value="" />
						学期：
						<select name="term">
							<option value="1">上学期</option>
							<option value="2">下学期</option>
						</select>
						<input type="submit" id="select-course"  value="选择课程" />
					</div>
								
					<div id="selected-list">
						<table>
							<tr>
								<td>
									<input type="checkbox" id="selectall" value="" />全选
								</td>
								<td>课程名称</td>
								<td>学时</td>
								<td>学分</td>
							</tr>
							<c:forEach items="${unSelected }" var="c">
							<tr>
								<td><input type="checkbox" name="courseid" value="${c.courseid }" /></td>
								<td>${c.coursename }</td>
								<td>${c.hour }</td>
								<td>${c.score }</td>
							</tr>
							</c:forEach>
						</table>
					</div>
					<input type="submit" value=""/>
				</form>
			</div>
						</div>
	</body>
</html>
