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
			ע��
		</title>
	</head>
	<body>
		<form method="POST" action="register_v1.do">
			&nbsp;
			�û�����
			<input type="text" name="user">
			<p>
			&nbsp;&nbsp;&nbsp;
			���룺
			<input type="password" name="password">
			<p>
			�������䣺
			<input type="text" name="email">
			<p>
			�ֻ����룺
			<input type="text" name="mobile">
			<p>
			&nbsp;&nbsp;
			<a href="v1/login.jsp">
				�����˺ŵ�¼
			</a>
			&nbsp;&nbsp;
			<input type="Submit" value="��  ��" name="register" id="register" />
		</form>
	</body>

</html>