<%@page import="com.kh.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.ArrayList" 
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="/">돌아가기</a>
	<h2>회원 조회</h2>
	<form action="search">
		검색할 회원 아이디를 입력해주세요
		<input type="text" name="id">
		<input type="submit" value="조회"> 
	</form>
	<h1>전체 리스트</h1>
	<table border="1">
		<tr>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		</tr>
		<%
		ArrayList<Member> list = (ArrayList<Member>) request.getAttribute("list");	
		for(Member m : list){
			%><tr>
			<td><%=m.getId()%></td>
			<td><%=m.getPwd()%></td>
			<td><%=m.getName()%></td>
			</tr>
				
		<%	
		}
		 %>
		<%-- 리스트로 for문 --%>
		
	</table>
</body>
</html>