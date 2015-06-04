<%@ page isELIgnored="false" contentType="text/html; charset=gb2312"%>
<%@ taglib prefix="mine" uri="roller"%>
<html>
<head>
<title>Error!</title>
<%@ include file="header.html"%>
</head>
<body bgcolor="red">

	<h1>
		<%=request.getAttribute("exceptionMsg")%>
		<jsp:include page="footer.html" />
	</h1>
</body>
</html>
