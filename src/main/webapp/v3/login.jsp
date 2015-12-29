<%@ page language="java" pageEncoding="GBK"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">
		<title>
			Welcome!
		</title>
	</head>
	<body>
		<form method="POST" action="login_v3.do">
			用户名：
			<input type="text" name="user">
			<p>
			&nbsp;&nbsp;密码：
			<input type="password" name="password">
			<p>
			&nbsp;&nbsp;
			<a href="v3/register.jsp">
				注册新用户
			</a>
			&nbsp;&nbsp;
			<input type="Submit" value="登  录" name="login" id="login" />
		</form>
	</body>

</html>