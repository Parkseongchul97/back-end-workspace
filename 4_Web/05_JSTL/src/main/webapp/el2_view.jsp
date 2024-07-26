<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>1) 기존 방식</h2>
	<%= request.getParameter("id") %><br><br>
	<%String[] hobbyList = request.getParameterValues("hobby");
	for(String h : hobbyList){%>
		<li><%= h %></li>	
	<%} %>
	
	<h2>2)EL</h2>
	<p>${param.id}</p>
	<!--  EL에 반복문 사용 불가!!!!!! -->
	${paramValues.hobby[0]} 
	${paramValues.hobby[1]} 
	${paramValues.hobby[2]} 
	
</body>
</html>