<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/admin/student" method="post">
		<input type="hidden" name="method" id="method" value="edit" />
		<input type="hidden" name="stuid" id="stuid" value="${student.stuid }" />
		学号：<input type="text" name="stunum" id="stunum" value="${student.stunum }" /> <br />
		姓名：<input type="text"  name="stuname" id="stuname" value="${student.stuname }"/> <br />
		密码： <input type="password" name="password" id="password" value="${student.password }" /> <br />
		班级： <select name="classid" id="classid">
			<c:forEach items="${classes }" var="c">
				<c:if test="${student.classid == c.classid}">
					<option value="${c.classid }" selected>${c.classname }</option>
				</c:if>
				<c:if test="${student.classid != c.classid}">
					<option value="${c.classid }">${c.classname }</option>
				</c:if>
			</c:forEach>
		</select>
			<input type="submit" value="更新学生"/>
	</form>
</body>
</html>