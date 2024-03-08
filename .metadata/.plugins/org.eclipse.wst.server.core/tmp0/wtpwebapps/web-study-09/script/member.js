function loginCheck(){	
	
	if(document.frm.userid.value.length == 0){
		alert("아이디를 써주세요.");
		frm.userid.focus();
		return false;
	}

	if(document.frm.pwd.value == ""){
		alert("암호는 반드시 입력해야 합니다.");
		frm.pwd.focus();
		return false;
	}
	
	return true;
}


//아이디 중복체크 버튼누르면 호출되는 함수
function idCheck(){
	
	// 회원가입 화면에서 체크하는 거
	// 도큐먼트의 frm이라는 이름의 userid의 value가 없다면
	if(document.frm.userid.value == ""){
		alert("아이디 입력하여 주십시오.");
		document.frm.userid.focus();
		return false;
	}
	           //idCheck.do?userid=user
	           // 아이디가 채워져있으면 
	// idCheck.do로 get방식으로 이동 userid의 파라미터값을 
	// 채워져있는 id값으로 사용
	let url = "idCheck.do?userid=" + document.frm.userid.value;
	window.open(url, "_blank_1", "width=450, height=200");
}





function idok(){ // 중복확인하고 아이디를 사용할때 
	opener.frm.userid.value = document.frm.userid.value;
	opener.frm.reid.value = document.frm.userid.value;
	self.close();
	
}
	
	
	
	
function joinCheck() {
	
	// 이름 입력 확인
	if(document.frm.name.value.length == 0) {
		alert("이름을 써주세요");
		document.frm.name.focus();
		return false;
	}
	
	// 아이디 입력 확인
	if(document.frm.userid.value.length == 0) {
		alert("아이디를 써주세요");
		document.frm.userid.focus();
		return false;
	}
	
	// 아이디 글자개수 확인
	if(document.frm.userid.value.length < 4){
	    alert("아이디는 4글자 이상이어야 합니다");
	    document.frm.userid.focus();
	    return false;
    }
	
	if(document.frm.pwd.value == "") {
		alert("암호는 반드시 입력하여 주십시오");
		document.frm.pwd.focus();
		return false;
	}
	
	if(document.frm.pwd.value != document.frm.pwd_check.value) {
	    alert("암호가 일치하지 않습니다");
	    document.frm.pwd.focus();
	    return false;
	}
	
	if(document.frm.reid.value.length == 0) {
	    alert("아이디 중복체크를 하지 않았습니다");
	    document.frm.uesrid.focus();
	    return false;
	}
	
	return true;
}
