<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>	
<html>
<head>
	<title>Home</title>
</head>
<body>
	<sec:authorize access="isAuthenticated()">
		<form method = "post" action = "${pageContext.request.contextPath }/logout">
			<sec:csrfInput/>
			<button>로그아웃</button>
		</form>
		
		<a href = "${pageContext.request.contextPath }/mypage">마이페이지</a>
		
	</sec:authorize>
	<sec:authorize access="isAnonymous()">
		<a href = "custom/login">로그인</a>
	</sec:authorize>
	
	<a href = "coursesreg">수강신청</a>
	
	<h1>톱 페이지입니다.</h1>
	<ul>
		<li><a href="user/user.jsp">일반 사용자용 페이지로</a></li>
		<li><a href="admin/admin.jsp">관리자 전용 페이지로</a></li>
	</ul>
</body>
</html>
