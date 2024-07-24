<%@page import="model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전체 회원 정보</h1>
	<ul>
	<%
	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("memberList");
	if(list != null){
	for(Member m : list){%>
		<h2><%= m.getName() %>님의 회원 정보 </h2>
		<p>아이디 : <%= m.getId() %> </p> 
		<p>비밀번호 : <%= m.getPwd() %> </p><br>
		
	<%}} %>
	</ul>
</body>
</html>