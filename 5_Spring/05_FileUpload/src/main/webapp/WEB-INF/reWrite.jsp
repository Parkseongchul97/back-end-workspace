<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</head>
<body>
	<div class = "container">
		<h1>게시글 수정</h1>
		<form action="/reWrite" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label>Title</label>
				<input class="form-control" name="title" value="${reBo.title}">
			</div>
			<div class="form-group">
				<label>Content</label>
				<textarea class="form-control"  name="content" rows="20" >${reBo.content}</textarea>
			</div>
			<div class="form-group">
				<label>Add File</label>
				<input class="form-control" name="file" type="file" accept="image/*">
			</div>
			<input type="hidden" value="${reBo.no}" name="no">
			<button type="submit" class="btn btn-outline-warning">수정</button>
		</form>
	</div>

</body>
</html>