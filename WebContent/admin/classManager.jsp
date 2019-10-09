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
			班级列表
		</div>
		<div id="add-div">
			<input type="button" id="add-button" value="添加" onclick="add()"/>
			<div id="form-div">
				<form action="${pageContext.request.contextPath }/admin/classManager" method="post">
					<input type="hidden" name="method" value="add" id="method">
					<input type="hidden" name="classid" id="classid"/>
					班级名称：<input type="text" name="classname" id="classname"/>
					<input type="submit" value="提交"/>
					<c:if test="${!empty errorMsg }">
						<span>${errorMsg }</span>
					</c:if>
				</form>
			</div>
		</div>
		<table cellspacing="0">
			<tr>
				<th>班级ID</th>
				<th>班级名称</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${classes}" var="c">
				<tr>
					<td>${c.classid }</td>
					<td>${c.classname }</td>
					<td>
						<a href="javascript:void(0)" onclick="edit('${c.classid }','${c.classname }')">编辑</a>
						<a href="${pageContext.request.contextPath }/admin/classManager?method=delete&classid=${c.classid}">删除</a>
					</td>
				</tr>
			</c:forEach>	
		</table>
		<script type="text/javascript">
		function edit(classid,classname){
			
			$('#classid').val(classid);
			$('#classname').val(classname);
			$('#method').val("edit");
			
			$('#form-div').css('display','block');
		}
		
		<c:if test="${!empty errorMsg}">
			$(function(){
				edit('${classid}','${classname}');
			})
			
			
		</c:if>
		
		</script>
	</body>
</html>
