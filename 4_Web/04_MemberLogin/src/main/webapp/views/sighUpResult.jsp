<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%String name = (String)request.getAttribute("name");
	if(name != null){
		%><h1>회원가입에 성공하셨습니다 <%=name%> 님!!</h1>
	<%} else  %><h1>동일한 아이디로 가입한 회원이 있어 가입할 수 없습니다.</h1> 
	<a href="/">돌아가기</a>
</body>
</html>