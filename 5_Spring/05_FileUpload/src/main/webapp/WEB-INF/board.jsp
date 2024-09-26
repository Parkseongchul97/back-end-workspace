<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
    crossorigin="anonymous" />
    
    <style>
	.container{
		display: flex;
		justify-content: center;
		align-items: center;
		flex-direction: column;
	}
	h2{
		text-align: center;
		font-size: 2rem;
		font-weight: bold;
	}
	img{
		width: 500px;
		height: 300px;
		
	}
	#img{
	display: flex;
	justify-content :center;
	flex-direction: column;	
	margin: 10px;
	}
	#btn{
	display: flex;
	justify-content: space-between;
	}
	a {
	margin: 20px;
	
}
</style>
</head>
<body>
	<div class = "container">
		<form action= "/reWrite" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label>Title</label>
				<input class="form-control" name="title" value="${bo.title}">
			</div>
			<div class="form-group">
				<label>Content</label>
				<textarea class="form-control" name="content" rows="20"  >${bo.content}</textarea>
			</div>
			<div class="form-group">
				<label>Add File</label>
				<input class="form-control" name="file" type="file" accept="image/*">
			</div>
			<input type="hidden" name="no" value="${bo.no}">
			<button type="submit" class="btn btn-outline-warning">수정</button>
			<a class="btn btn-outrline-danger" href="/${bo.no}/remove">삭제</a>
		</form>
		<div class="header">
		<h2>${bo.title}</h2>
		<fmt:formatDate value="${bo.formatDate}" pattern="yyyy-MM-dd HH:mm:ss" />
		
		<a href="/list">리스트로 돌아가기</a>
		</div>
		
		<div id="img">
		<c:choose>
		<c:when test="${bo.url == null}">
			
			<img src="http://192.168.10.51:8081/seongchul/%EA%B8%B0%EB%B3%B8%ED%94%84%EC%82%AC.jpg">
			</c:when>
		<c:otherwise>
			<img src="http://192.168.10.51:8081/seongchul/${bo.url}">
		</c:otherwise>
			</c:choose>
			${bo.content}
			
		</div>
		
		<div id="btn">
		<a href="/${bo.no}/reWrite" class="btn btn-outline-warning">게시글 수정</a> 
		<a href="/${bo.no}/remove" class="btn btn-outline-warning">게시글 삭제</a>
		</div>
	</div>
</body>
</html>