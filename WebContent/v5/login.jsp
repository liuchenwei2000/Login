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
		�û����� <input type="text" id="user" name="user"><span
			id="error_user"></span>
		<p>
			&nbsp;&nbsp;���룺 <input type="password" id="password" name="password">
			<span id="error_password"></span>
		<p>
			&nbsp;&nbsp; <a href="v5/register.jsp"> ע�����û� </a> &nbsp;&nbsp; <input
				type="Submit" value="��  ¼" name="login" id="login" />
	</form>
</body>

</html>