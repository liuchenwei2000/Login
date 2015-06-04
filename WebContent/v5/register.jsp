<%@ page language="java" pageEncoding="GBK"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">
		<title>注册</title> 
  <script type="text/javascript" src="validation.js"></script> 
  <link href="css/main.css" rel="stylesheet" type="text/css" /> 
 </head> 
 <body> 
  <form method="POST" action="register_v5.do" onsubmit="return validateForm()">
    &nbsp; 用户名： 
   <input type="text" id="user" name="user" onblur="validateUsername()" /> 
   <span id="error_user"> </span> 
   <p> &nbsp;&nbsp;&nbsp; 密码： <input type="password" id="password" name="password" onblur="validatePassword()" /> <span id="error_password"> </span> </p>
   <p> 电子邮箱： <input type="text" id="email" name="email" onblur="validateEmail()" /> <span id="error_email"> </span> </p>
   <p> 手机号码： <input type="text" id="mobile" name="mobile" onblur="validateMobile()" /> <span id="error_mobile"> </span> </p>
   <p> &nbsp;&nbsp; <a href="v5/login.jsp"> 已有账号登录 </a> &nbsp;&nbsp; <input type="Submit" value="提  交" name="register" id="register" />   </p>
  </form>
 </body>
</html>