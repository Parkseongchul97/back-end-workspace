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
	<jsp:include page="header.jsp"/>
	<c:forEach  var="i"  begin="1"  end="6" step="1">
	<!-- int i = 0; i <=5; i++과 같음  -->
		<h${i}>h${i} Tag</h${i}>
	<%-- EL문법은 거의다 들어감 --%>
	</c:forEach>

</body>
</html>