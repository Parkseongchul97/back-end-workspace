<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
<div class="container">
	<h1>로그인</h1>
  	
  	<form id="loginfrm" > 		
  <div class="mb-3">
    <label for="id" class="form-label">아이디</label>
    <input type="text" class="form-control" id="id" name="username" >
    <div id="idCheck" class="form-text">로그인 확인문구</div>
  </div>
  <div class="mb-3">
    <label for="password" class="form-label">비밀번호</label>
    <input type="password" class="form-control" id="password" name="password">
    <div id="pwdCheck" class="form-text">비밀번호 확인문구</div>
  </div>

  <button type="submit" id="login" class="btn btn-dark">로그인</button>
</form>
<a href="/signup">아직 회원이 아니시라면 ? 회원가입</a>
  	
</div>
	
<script>
	$("#login").click((e) =>{
		e.preventDefault(); // 기존 이벤트 제거(폼태그 보내는 submit)
		$.ajax({
			url: "/login",
			type: 'post',
			data: $("#loginfrm").serialize(),
			success: function(data) {
				console.log(data); // 토큰 값 확인!
				// 토큰 값 - > localStorage에 저장
				if(data === ""){
					alert("로그인 실패!");
					location.href = "/login";
				}
				localStorage.setItem("token", data);
				location.href = "/";
			}		
			
		});	
		
	});
</script>
</body>
</html>