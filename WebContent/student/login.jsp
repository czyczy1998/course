<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>学生选课登陆页面</title>
	<link href="http://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/htmleaf-demo.css">
	<link href="${pageContext.request.contextPath }/css/signin.css" rel="stylesheet">
</head>
<body>
	<div class="htmleaf-container">
		<div class="signin">
			<div class="signin-head"><img src="${pageContext.request.contextPath }/images/test/head_120.png" alt="" class="img-circle"></div>
			<form class="form-signin" role="form" action="${pageContext.request.contextPath }/student/login" method="post">
				<input name="stunum" type="text" class="form-control" placeholder="用户名" required autofocus />
				<input name="password" type="password" class="form-control" placeholder="密码" required />
				<button class="btn btn-lg btn-warning btn-block" type="submit">登录</button>
				<span>${message }</span>
				<label class="checkbox">
					<input type="checkbox" value="remember-me"> 记住我
				</label>
			</form>
		</div>
	</div>
	
</body>
</html>