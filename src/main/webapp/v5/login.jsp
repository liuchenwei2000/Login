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
		<script type="text/javascript" src="validation.js">
		</script>
		<link href="css/main.css" rel="stylesheet" type="text/css" />
	</head>
<body>
	<form method="POST" action="login_v5.do" onsubmit="return validateNull4Form()">
		用户名： <input type="text" id="user" name="user"><span
			id="error_user"></span>
		<p>
			&nbsp;&nbsp;密码： <input type="password" id="password" name="password">
			<span id="error_password"></span>
		<p>
			&nbsp;&nbsp; <a href="v5/register.jsp"> 注册新用户 </a> &nbsp;&nbsp; <input
				type="Submit" value="登  录" name="login" id="login" />
	</form>
</body>

</html>