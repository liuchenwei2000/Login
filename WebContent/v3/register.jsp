<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">
		<title>
			注册
		</title>
	</head>
	<body>
		<form method="POST" action="register_v3.do">
			&nbsp;
			用户名：
			<input type="text" name="user">
			<p>
			&nbsp;&nbsp;&nbsp;
			密码：
			<input type="password" name="password">
			<p>
			电子邮箱：
			<input type="text" name="email">
			<p>
			手机号码：
			<input type="text" name="mobile">
			<p>
			&nbsp;&nbsp;
			<a href="v3/login.jsp">
				已有账号登录
			</a>
			&nbsp;&nbsp;
			<input type="Submit" value="提  交" name="register" id="register" />
		</form>
	</body>

</html>