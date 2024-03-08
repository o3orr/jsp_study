<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

td {
	align : center;
	width : 200px;
	height: 50px;
	cursor:pointer;
}

#nav td:hover {
    background-color: salmon;
}

table, tr, td {
	border: 1px solid black;
	margin : auto;
	text-align :center;

}


</style>
<script type="text/javascript" src="script/employee.js"></script>
</head>
<body>
	<form action="login.do" method="post" name="frm">
		<table id="nav">
			<tr>
				<c:choose>
					<c:when test="${empty loginUser}">
							<td></td>
							<td></td>
							<td onclick="location.href='login.do'">로그인</td>
							<td>
								사원등록
							</td>
							<td>
								마이페이지
							</td>
					</c:when>
					<c:otherwise>
							<td>${loginUser.name }님 반갑습니다</td>
							<td>레벨 : ${loginUser.lev }</td>
							<td onclick="location.href='logout.do'">로그아웃</td>
							<td>
								<span onclick="location.href='update.do'">사원등록</span>
							</td>
								<td onclick="location.href='mypage.do?id=${loginUser.id}'">마이페이지</td>
					</c:otherwise>
				</c:choose>
				
			</tr>
		</table>
		
		
		<table>
			<tr>
				<td colspan="2" align="center">로그인</td>
			</tr>			
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"value="${id}"></td>
			</tr>			
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pass"></td>
			</tr>		
			<tr>
				<td>레벨</td>
				<td>
					<select name="lev">
						<option value="B">일반회원</option>
						<option value="A">운영자</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" align=center>
					<input type="submit" value="로그인" onclick="return loginCheck()">
					<input type="reset" value="취소">
				</td>
			</tr>
		<tr>
            <td colspan="2">${message}</td>
         </tr>
		</table>
	
	</form>
</body>
</html>