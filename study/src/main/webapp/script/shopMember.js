/**
 * 
 */
// 아이디 유효성 검사 함수
function loginCheck() {
	//로그인 화면에서 체크하는 거
	//도큐먼트의 frm이라는 이름의 userid의 길이가 0이라면 -> 없다면
	if(document.frm.userid.value.length == 0) {
		alert("아이디를 입력해주세요"); //경고창 띄우고
		frm.userid.focus(); //frm 폼의 userid 입력하는 창을 가리킴
		return false; //false값 반환
	}
	
	//도큐먼트의 frm이라는 폼의 pwd의 value가 비어있다면
	if(document.frm.pwd.value == "") {
		alert("암호를 입력해주세요");
		frm.pwd.focus();
		return false;
	}
	
	// 유효성 검사가 통과되면 true 반환
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




function idok() { //중복확인하고 그 아이디를 회원가입창에다 다시 사용할떼
	//idCheck.jsp에 있던 아이디 join.jsp에 사용
	opener.frm.userid.value = document.frm.userid.value;
	
	//중복확인을 했는지 확인하기 위한 히든에도 똑같은 값을 집어넣음
	opener.frm.reid.value = document.frm.userid.value;
	self.close(); //사용하면 스스로 창닫기
	
}




