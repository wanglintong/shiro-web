<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
	<fieldset style="width: 40%;margin: 0 auto">
		<legend>用户登录</legend>
		<form action="${pageContext.request.contextPath }/login.do" method="post">
			<p style="color:red">${error }</p>
			用户名：<input type="text" name="username" /><br /><br/>
			密&nbsp;&nbsp;码：<input type="password" name="password" /><br/><br/>
			<input type="submit" value="登录">
		</form>
	</fieldset>
</body>
</html>