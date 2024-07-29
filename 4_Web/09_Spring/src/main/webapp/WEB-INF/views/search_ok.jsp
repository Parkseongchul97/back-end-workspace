<%@page import="com.kh.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h2>${memberinfo.name}님의 회원 정보 </h2>
		<p>아이디 : ${memberinfo.id} </p> 
		<p>비밀번호 : ${memberinfo.pwd}</p>
		<a href="/">돌아가기</a>

</body>
</html>