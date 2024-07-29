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
	
	<h1>**회원가입**</h1>
	<form action="/register.do" method="post">
	 ID : <input type="text" name="id" ><br>
	 PASSWORD : <input type="password" name="pwd" ><br>
	 NAME : <input type="text" name="name" ><br>
	 <input type="submit" value="제출">
	</form>
	<a href="/">돌아가기</a>
	
</body>
</html>