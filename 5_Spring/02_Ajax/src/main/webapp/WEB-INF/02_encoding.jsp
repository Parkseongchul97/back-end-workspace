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
	<h2>Encoding 처리하기</h2>
	닉네임 : <input type="text" id="nick">
	<input type="button" value="닉네임 보내기" id="btn" >
	<div id="result"></div>
	<!--  get /encoding 닉네임 보내서 요청 받아서 result에 보여주기 ?-->
	<a href="/"></a>
		<!--  
		<script>
		let xhr;
		
		function startRequest() {
			const nickname = document.querySelector("#nick").value;
			xhr = new XMLHttpRequest();
			xhr.onreadystatechange = callback;
			// get 방식이기 때문에 ?키=값 으로보냄
			xhr.open("get","/encoding?nickname=" + encodeURI(encodeURIComponent(nickname) ));
			xhr.send(null); // post때 사용 get은 값 못받음!
		}
		
		function callback() {  // 응답에 해당하는 로직을 담는 메서드
			// alert(xhr.readyState); 4까지 떨어지면 정상
			if(xhr.readyState === 4){
					// 200이면 404 500 같은 에러 X 잘된거
				if(xhr.status === 200){
					const nick = xhr.responseText; // responseText <- 여기에 반환값이 들어감!!(컨트롤러에)
					console.log(nick);
					document.querySelector("#result").innerText = decodeURI(decodeURIComponent(nick)) ;
				}	
			}
		}
		-->
		</script>
		<!--  jQuery -->
		<script>
			$("#btn").click((e)=>{
				const nickname = $("#nick").val();
				$.ajax({
					// 요청
					type: "get",
					url: "/encoding",
					data: "nickname=" + encodeURIComponent(nickname),
					// 응답
					success: function(result){
						$("#result").text(result);
					} // 다음 다음 넘어갈때 , 가다가 ; 마무리!!
					
					
				});
				
			});
		</script>
	

</body>
</html>