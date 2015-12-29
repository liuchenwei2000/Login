<%@ page isELIgnored="false" contentType="text/html; charset=gb2312"%>
<%@ taglib prefix="mine" uri="roller"%>
<html>
<head>
<%@ include file="header.html"%>
</head>
<body>
	Welcome you
	<%=request.getAttribute("username")%>
	!!!
	<p>
		You roll ${mine:roll()}
		<jsp:include page="footer.html" />
</body>
</html>
