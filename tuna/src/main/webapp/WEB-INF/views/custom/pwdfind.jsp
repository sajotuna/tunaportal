<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action = "pwdEmailfind" method = "post">
		<sec:csrfInput/>
		<input type = "email" name = "email" placeholder="email을 입력하세요...">
		<input type = "submit" value = "Send Mail">
	</form>
	
	<a href = "custom/login">Login</a>

</body>
</html>