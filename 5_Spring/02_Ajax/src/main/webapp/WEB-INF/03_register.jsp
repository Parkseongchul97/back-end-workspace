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
	아이디 : <input type="text" id="id">
	<input type="button" value="중복체크" id="idCheck">
	<span id="idCheckView"></span>
	
	<!--  중복체크 버튼을 눌렀을 때 post 방식으로
		/check로 id 값 놈겨서 결과값은(boolean)을 받아서
		아이디가 있으면 ID 사용 불가 , 없으면 ID 사용 가능
		DB 스키마 member
	 -->
	 <script>
	 	$("#idCheck").click(()=>{
	 		const id = $("#id").val();
	 		console.log(id);
	 		$.ajax({
	 			type: "post", url: "/idCheck", data : "id="+ id,
	 			success: function(result) { // 리졀트가 불리언
	 				console.log(result);
	 				if(result){
					$("#idCheckView").text("ID 사용 가능").css("color" ,"green");
	 				}else
	 					$("#idCheckView").text("ID 사용 불가").css("color" ,"red")	;
				}
	 		})
	 	});
	 </script>
	 

</body>
</html>