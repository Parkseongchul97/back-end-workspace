let idSubmit = false;
let pwdSubmit = false;
id.addEventListener("input", function(e){
	console.log("아이디입력!");
	const regExp = /^[a-zA-z][0-9a-zA-Z]{9,13}$/ ;
	// 중복체크
	$.ajax({
		type : "post",
		url : "/check",
		data:{id : e.target.value},
		success: function(data){
			if(data){
				// 정보가 있을때 <- 중복 아이디
				idCheck.innerHTML = " 중복된 아이디입니다. 다시입력해주세요 ㅠㅠ ";
				idCheck.style.color = "red";
				idSubmit = false;
			}else{
				
				if(regExp.test(e.target.value)){
					idCheck.style.color = "green";
					idCheck.innerHTML = "OK!";
					idSubmit = true;
				}else if(e.target.value === ""){
					idCheck.innerHTML = "";
					idSubmit = false;
				}else{
					idCheck.innerHTML = "첫글자는 영어로, 영어 또는 숫자로만 10~14글자로 구성할수 있습니다.";
					idCheck.style.color = "red";
					idSubmit = false;
				}
				// 정보가 없을때 <- 중복 X 아이디
			}
		}
		
	})
	// 영어 숫자로 10~14글자 시작은 영어


});
password.addEventListener("input", function(e){
	const regExp = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@#$%^&+=!]).*$/;
	if(regExp.test(e.target.value)){
		pwdCheck.style.color = "green";
		pwdCheck.innerHTML = "OK!";
		pwdSubmit = true;
	}else if(e.target.value === ""){
		pwdCheck.innerHTML = "";
		pwdSubmit = false;
	}else{
		pwdCheck.style.color = "red";
		pwdCheck.innerHTML = "특수문자,대문자,소문자,숫자가 한개이상 무조건 포함되어야 합니다.";
		pwdSubmit = false;		
	}
	
});



function validate(){
	if(!idSubmit) id.focus();
	else if(!pwdSubmit) password.focus();
		return idSubmit && pwdSubmit;
}