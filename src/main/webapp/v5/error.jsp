<%@ page isELIgnored="false" contentType="text/html; charset=gb2312"%>
<%@ taglib prefix="mine" uri="roller"%>
<html>
<head>
<title>Error!</title>
</head>
<body bgcolor="red">
	<h1>
		<%=request.getAttribute("exceptionMsg")%>
	</h1>
</body>
</html>
