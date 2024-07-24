<%@page import="model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<%Member member = (Member)request.getAttribute("memberinfo"); %>
		<h2><%= member.getName() %>님의 회원 정보 </h2>
		<p>아이디 : <%= member.getId() %> </p> 
		<p>비밀번호 : <%= member.getPwd() %> </p>
		<a href="/">돌아가기</a>

</body>
</html>