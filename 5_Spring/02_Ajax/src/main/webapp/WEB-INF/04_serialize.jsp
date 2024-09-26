<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	<h1>회원가입</h1>
	
	<form id="frm">
		아이디 : <input type="text" id="id" name="id"><br>
		비밀번호 : <input type="password" id="password" name="password"><br>
		이름 : <input type="text" id="name" name="name"><br>
		<input type="button" value="가입" id="btn">
	</form>
	
	<div id="result"></div>
	<script>
	$("#btn").click(()=>{
		const idVal = $("#id").val()
		const pwdVal = $("#password").val()
		const nameVal = $("#name").val()
		console.log(idVal);
		console.log(pwdVal);
		console.log(nameVal);
		$.ajax({
			type: "post",
			url : "/serial",
			data : {id : idVal, 
					password : pwdVal, 
					name : nameVal},
					/*$("#frm").serialize() 
						이걸로도 보낼수있음
					*/
			success: function(result){
				console.log($("#frm").serialize());
				console.log(result.id == idVal);
				if(result.id == idVal){
					console.log(result)
					$("#result").text("아이디 : " + result.id + " 비밀번호 : " +
										result.password + " 이름 : " + result.name);
					
				}else{
					$("#result").text("중복 ID 입니다 생성할 수 없습니다.");
				}
			},
			error: function() {
				alert("서버 에러!");
			}
		})
	});
	</script>
</body>
</html>