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
${param.number}
<%-- c: if 사용했을 경우 
	숫자가 1이면 안녕하세요~ 
	2면 처음뵙겟습니다
	그외는 모르는사람인대용
	--%>
	<c:if test="${param.number eq '1'}">
	<h5>안녕하세요~~</h5>
	</c:if>
		<c:if test="${param.number == '2'}">
	<h5>처음 뵙겠습니다!</h5>
	</c:if>
		<c:if test="${param.number ne '1' and param.number != '2' }">
	<h5>모르는 사람인데요....</h5>
	</c:if>
	<%--
		JSTL 키워드
		== : eq, != : ne, 
		< : lt, > : gt, 
		<= : le, >= : ge,
		&& : and, || : or,
		! : not, 
		empty - null 이거나 빈 문자열인 경우 true 아니면 false
		
	 --%>
	 
	 <c:choose>
		<c:when test="${param.number eq '1'}">
			<h5>안녕하세요~~</h5>
			</c:when>
		<c:when test="${param.number == '2'}">
			<h5>처음 뵙겠습니다!</h5>
			</c:when>
		<c:otherwise>
			<h5>모르는 사람인데요....</h5>
			</c:otherwise>
	 </c:choose>
	

	

</body>
</html>