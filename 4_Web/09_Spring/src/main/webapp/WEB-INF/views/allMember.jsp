<%@page import="com.kh.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
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
	<h1>전체 회원 정보</h1>
	<a href="/">돌아가기</a>
	<ul>

	<c:forEach items="${memberList}" var="member" varStatus="status" >
	<%-- varStatus에 index -> 0부터, count : 1부터 시작  --%>
			<h2>${member.name}님의 회원 정보 </h2>
			<p>회원 번호 : ${status.count}</p> 
			<p>아이디 : ${member.id}</p> 
			<p>비밀번호 : ${member.pwd}</p><br>
	</c:forEach>
	</ul>
</body>
</html>