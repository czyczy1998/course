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
	<form action="${pageContext.request.contextPath }/admin/student" method="post">
		<input type="hidden" name="method" value="add" />
		学号：<input type="text" name="stunum" id="stunum" value="" /> <br />
		姓名：<input type="text"  name="stuname" id="stuname"/> <br />
		密码： <input type="password" name="password" id="password" value="" /> <br />
		班级： <select name="classid" id="classid">
			<c:forEach items="${classes }" var="c">
				<option value="${c.classid }">${c.classname }</option>
			</c:forEach>
		</select>
			<input type="submit" value="添加学生"/>
	</form>
</body>
</html>