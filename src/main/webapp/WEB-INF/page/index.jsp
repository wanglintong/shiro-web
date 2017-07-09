<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	<h1>shiro-web</h1>
	<shiro:guest>  
		欢迎游客访问，<a href="${pageContext.request.contextPath}/loginPage.do">登录</a>
	</shiro:guest>
	<shiro:user>  
		欢迎[<shiro:principal property="username" />]登录，<a href="${pageContext.request.contextPath}/logout">退出</a>
	</shiro:user>
	
	<div>普通内容</div>
	
	<shiro:hasRole name="admin">
		管理员才能看到的内容
	</shiro:hasRole>
</body>
</html>