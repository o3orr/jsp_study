/**
 * 
 */

// 유효성 체크
 function check() {
	 if(document.frm.id.value == ""){
		 alert("아이디를 입력해주세요!")
		 document.frm.id.focus();
		 return false;
	 } else if(document.frm.pass.value == ""){
		 alert("비밀번호를 입력해주세요!")
		 document.frm.pass.focus();
		 return false;
	 } else if(isNaN(document.frm.pass.value)){
		 alert("숫자만 입력해주세요!")
		 document.frm.pass.focus();
		 return false;
	 }else if(document.frm.id.value.length < 4){
		 alert("아이디를 4자리 이상 입력해주세요!")
		 document.frm.id.focus();
		 return false;
	 }else {
		 return true;
	 }
 }