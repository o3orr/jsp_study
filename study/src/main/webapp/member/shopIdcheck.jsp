<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/shopMember.js"></script>
</head>
<body>
	<h2>아이디 중복 체크</h2>
	<form action="idCheck.do" method="get" name="frm">
		아이디 <input type="text" name="userid" value=${userid }>
			<input type="submit" value="중복 체크">
			
		<br>
		<c:if test="${result == 1 }">
			<script type="text/javascript">
				// opner객체는 자기 자신을 연 기존 창의 window 객체를 참조
				opener.document.frm.userid.value="";
			</script>
			<div sytle="color:crimson">${userid }는 이미 사용 중인 아이디입니다</div>
		</c:if>
		
		<c:if test="${result == -1 }">
			<div style="color:red">${userid }는 사용 가능한 아이디입니다</div>
			<!-- 사용 가능한 아이디면 사용 버튼 눌러서 아이디를 원래 회원가입 아이디 입력창에다가 사용 -->
			<!-- idok함수는 원래 회원가입 창에다가 넣어주는 자바스크립트 함수 -->
			<input type="button" value="사용" class="cancel" onclick="idok()">  
		</c:if>
			
	
	</form>
</body>
</html>