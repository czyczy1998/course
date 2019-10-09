<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/admin/course" method="post">
		<input type="hidden" name="method" value="add" />
		课程名称：<input type="text" name="coursename" id="coursename" value="" /> <br />
		课程时长：<input type="text"  name="hour" id="hour"/> <br />
		课程分数： <input type="text" name="score" id="score" value="" /> <br />
		
			<input type="submit" value="添加课程"/>
	</form>
</body>
</html>