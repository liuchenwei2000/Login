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
			�û�����
			<input type="text" name="user">
			<p>
			&nbsp;&nbsp;���룺
			<input type="password" name="password">
			<p>
			&nbsp;&nbsp;
			<a href="v3/register.jsp">
				ע�����û�
			</a>
			&nbsp;&nbsp;
			<input type="Submit" value="��  ¼" name="login" id="login" />
		</form>
	</body>

</html>