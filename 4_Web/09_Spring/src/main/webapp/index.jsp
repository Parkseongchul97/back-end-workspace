<%@page import="com.kh.model.vo.Member"%>
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
	<h1>회원 관리 기능</h1>
	
	<ul>
		<c:choose>
		<c:when test = "${longinMember == null}"> 
		<!-- 로그인 되어있지 않은 경우 -->
		<li><a href="/register">회원가입</a></li>
		<!--  회원가입 아이디,비번,이름 입력받아서 
			호출 : register
			RegisterServlet post로	
			초기화면으로
		 -->
		<li><a href="views/login.jsp">로그인</a></li>
		<!--  아이디 비번 입력받아
			호출 : login post
			LoginServlet: 세션 데이터 바인딩!
			초기화면으로	
		 --></c:when>
	 <c:otherwise>
		<h2>${longinMember.name}님, 환영합니다.!!</h2>
		<!--  로그인 되어 있는 경우  -->
		<li><a href="views/search.jsp">회원검색</a></li>
		<!--  검색할 아이디
			호출 /search 방식 get
			성공시 해당 정보 출력  views/search_ok.jsp
			실패시 실패했습니다 ㅠㅠ views/search_fail.jsp
			
			 -->
		<li><a href="/allMember.do">전체회원조회</a></li>
		<!--  전체 회원보기 : view/allMember.jsp에 리스트출력 -->
		<li><a href="/logout.do" >로그아웃</a></li>
		<!--  로그아웃후 초기화면으로 -->
		
		</c:otherwise>
		</c:choose>
	</ul>

</body>
</html>