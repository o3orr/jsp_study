<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="RadioServlet">
		성별 : <input type="radio" id="gender" name="gender" value="남자" checked> 남자
				<input type="radio" id="gender" name="gender" value="여자">여자 <br><br>
		메일 정보 수신 여부 :
				<input type="radio" id="chk_mail" name="chk_mail" value="yes" checked> 수신
				<input type="radio" id="chk_mail" name="chk_mail" value="vo"> 거부<br><br>
		취미 :
		<input type="checkbox" name="item" value="독서">독서
		<input type="checkbox" name="item" value="운동">운동
		<input type="checkbox" name="item" value="개발">개발
		<input type="checkbox" name="item" value="요리">요리
		<input type="checkbox" name="item" value="산책">산책
		
		<br><br>간단한 가입 인사를 적어주세요^o^<br>
		<textarea id="content" name="content" rows="3" cols="35"></textarea><br>
		<input type="submit" value="전송">
	
	</form>

</body>
</html>