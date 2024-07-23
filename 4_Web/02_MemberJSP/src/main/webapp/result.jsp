<%-- 
	JSP Element
	1) 지시어 %@ 내용 % : 컨테이너에게 알려줄 내용 지정 
	2) 스클릿틀릿 % 내용 % : 자바코드는 이 안에 지정
	3) 출력문 %= 내용 % : 출력하는 내용 지정
	
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- JSP 주석 : 화면에 안보임 --%>
<!--  HTML 주석 : 화면에 보임(소스코드 같은곳에서) -->
	<a href="/">돌아가기</a>
	 <% String name = (String)request.getAttribute("name");
	
	 boolean check = (boolean)(request.getAttribute("check")) ;
	 
	 	if(check){ %>
	 		<h1>회원가입 완료되었습니다..!</h1>
	 		 <h2><%=name %>님, 환영합니다</h2>
	 	<% }else{ %>
	 		<h1>회원가입에 실패하였습니다 ㅠㅠ</h1>
	 		 <h2><%=name %>님, 회원가입 실패 ㅠㅠ</h2>
	 	<% }%>
	
	<%-- 
	자바코드랑 자바코드 아닌것 구분 잘해야함!!! 
	위에 내용따라 잘지정해야댐!
		
	--%>
	
	
	
	

</body>
</html>