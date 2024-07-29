<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:choose>
		<c:when test="${name != null}">
			<h1>회원가입에 성공하셨습니다 ${name} 님!!</h1>
		</c:when>
		<c:otherwise>
			<h1>동일한 아이디로 가입한 회원이 있어 가입할 수 없습니다.</h1>
		</c:otherwise>
	</c:choose>

	<a href="/">돌아가기</a>
</body>
</html>