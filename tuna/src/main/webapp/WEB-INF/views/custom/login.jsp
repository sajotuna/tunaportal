<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
</head>
<body>

<h1>로그인 페이지</h1>
${param.error}

<c:if test ="${!empty LoginFailMessage }">
	<script>
		alert(`${LoginFailMessage}`)
	</script>
</c:if>

<a href = "${pageContext.request.contextPath }/home">TUNA</a>

<form action="${pageContext.request.contextPath }/processLogin" method="post">
	<sec:csrfInput/>
  <dl>
    <dt>
      로그인 ID
    </dt>
    <dd>
      <input type="text" name="username">
    </dd>
    <dt>
      패스워드
    </dt>
    <dd>
      <input type="password" name="password">
    </dd>
  </dl>
  <button>로그인</button>
</form>
<a href = "pwdfind">비밀번호찾기</a>
</body>
</html>
