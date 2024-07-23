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
	<a href="/view">돌아가기</a>
	<% Member member = (Member)request.getAttribute("mem"); 
	if(member.getId() != null){%>
	<h1><%=member.getName() %>님의 회원 정보</h1>
	<ul>
	<li>아이디 : <%= member.getId() %></li>
	<li>비밀번호 : <%= member.getPwd() %></li>
	</ul><%}else {%> <h1>회원 정보가 없습니다!</h1> 
	<%} %>
</body>
</html>