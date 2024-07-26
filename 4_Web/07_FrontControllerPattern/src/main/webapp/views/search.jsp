<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 검색 </h1>
	<form action="/search" method="get">
	<input type="hidden" name="command" value="search" >
		회원 ID 입력 : <input type="text" name="id"><br>
		<input type="submit" value="검색" >
	</form>
	<a href="/">돌아가기</a>
</body>
</html>