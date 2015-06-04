<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<title>Login Demo v1-v5</title>
</head>
<body>
	<ul>
		<li><a href="v1/index.html">Login.V1 (HTML + JSP + Servlet + JDBC)</a></li>
		<li><a href="v2/index.html">Login.V2 (HTML + JSP + EL + Servlet + Listener + JDBC)</a></li>
		<li><a href="v3/index.html">Login.V3 (HTML + JSP + EL + Servlet + Listener + Hibernate + Ehcache + c3p0 + BeanValidation + Maven)</a></li>
		<li><a href="v4/index.html">Login.V4 (HTML + JSP + Velocity + Servlet + Listener + Hibernate + Ehcache + c3p0 + BeanValidation + Maven)</a></li>
		<li><a href="v5/index.html">Login.V5 (HTML + CSS + JS + Ajax + JSP + Velocity + Servlet + Listener + Hibernate + Ehcache + c3p0 + BeanValidation + Maven)</a></li>
	</ul>
</body>
</html>
