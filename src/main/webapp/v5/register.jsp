<%@ page language="java" pageEncoding="GBK"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">
		<title>ע��</title> 
  <script type="text/javascript" src="validation.js"></script> 
  <link href="css/main.css" rel="stylesheet" type="text/css" /> 
 </head> 
 <body> 
  <form method="POST" action="register_v5.do" onsubmit="return validateForm()">
    &nbsp; �û����� 
   <input type="text" id="user" name="user" onblur="validateUsername()" /> 
   <span id="error_user"> </span> 
   <p> &nbsp;&nbsp;&nbsp; ���룺 <input type="password" id="password" name="password" onblur="validatePassword()" /> <span id="error_password"> </span> </p>
   <p> �������䣺 <input type="text" id="email" name="email" onblur="validateEmail()" /> <span id="error_email"> </span> </p>
   <p> �ֻ����룺 <input type="text" id="mobile" name="mobile" onblur="validateMobile()" /> <span id="error_mobile"> </span> </p>
   <p> &nbsp;&nbsp; <a href="v5/login.jsp"> �����˺ŵ�¼ </a> &nbsp;&nbsp; <input type="Submit" value="��  ��" name="register" id="register" />   </p>
  </form>
 </body>
</html>