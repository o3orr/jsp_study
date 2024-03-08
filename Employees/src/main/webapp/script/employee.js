/**
 * 
 */
function loginCheck(){	
	
	if(document.frm.id.value.length == 0){
		alert("아이디를 써주세요.");
		frm.id.focus();
		return false;
	}

	if(document.frm.pass.value == ""){
		alert("암호는 반드시 입력해야 합니다.");
		frm.pass.focus();
		return false;
	}
	
	return true;
}

	
function joinCheck() {
	
	// 이름 입력 확인
	if(document.frm.name.value.length == 0) {
		alert("이름을 써주세요");
		document.frm.name.focus();
		return false;
	}
	
	// 아이디 입력 확인
	if(document.frm.id.value.length == 0) {
		alert("아이디를 써주세요");
		document.frm.id.focus();
		return false;
	}
	
	// 아이디 글자개수 확인
	if(document.frm.id.value.length < 4){
	    alert("아이디는 4글자 이상이어야 합니다");
	    document.frm.id.focus();
	    return false;
    }
	
	if(document.frm.pass.value == "") {
		alert("암호는 반드시 입력하여 주십시오");
		document.frm.pass.focus();
		return false;
	}
	
	
	return true;
}
