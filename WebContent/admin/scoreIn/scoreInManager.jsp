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
		<script src="${pageContext.request.contextPath }/js/jquery.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath }/js/admin-class.js" type="text/javascript" charset="utf-8"></script>
		
	</head>
	<body>
		<div id="class-title">
		成绩录入
		</div>
			<div id="form-div">
				<form action="${pageContext.request.contextPath }/admin/scoreIn/scoreInManager" method="post">
				<input type="hidden" name="method" value="add" id="method">
					<input type="hidden" name="selid" id="selid"/>
				分数：<input type="text" name="grade" id="grade"/>
					<input type="submit" value="提交"/>
					<c:if test="${!empty errorMsg }">
						<span>${errorMsg }</span>
					</c:if>
				</form>
			</div>
			
		
		<table cellspacing="0" id="table">
			<tr>
			   <th>成绩编号</th>
				<th>班级</th>
				<th>学生学号</th>
				<th>学生名称</th>
				<th>学年</th>
				<th>学期</th>
				<th>课程</th>				
				<th>学分</th>
				<th>成绩</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${scorein }"  var="s">
			<tr>
			<td>${s.selid }</td>
				<td>${s.classname }</td>
				<td>${s.stunum }</td>
				<td>${s.stuname }</td>
				<td>${s.year}</td>
				<td>${s.term}</td>
				<td>${s.coursename}</td>
				<td>${s.score}</td>
				<td>${s.grade}</td>
				<td>
					<a href="javascript:void(0)" onclick="edit('${s.selid }','${s.grade }')">编辑</a>
				</td>
			</tr>
			</c:forEach>
			
		</table>
			<script type="text/javascript">
		function edit(selid,grade){
			
			$('#selid').val(selid);
			$('#grade').val(grade);
			$('#method').val("edit");
			
			$('#form-div').css('display','block');
		}
		
		<c:if test="${!empty errorMsg}">
			$(function(){
				edit('${selid}','${grade}');
			})
			
			
		</c:if>
		
		</script>
	</body>
</html>
