<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</head>
<body>
	<form action="update.do" method="post" name="frm">
		<table id="nav">
			<tr>
				<c:choose>
					<c:when test="${empty loginUser}">
							<td></td>
							<td></td>
							<td onclick="location.href='login.do'">로그인<td>
					</c:when>
					<c:otherwise>
							<td>${loginUser.name }님 반갑습니다</td>
							<td>레벨 : ${loginUser.lev }</td>
							<td onclick="location.href='logout.do'">로그아웃</td>
					</c:otherwise>
				</c:choose>
				<td>
					<span onclick="location.href='update.do'">사원등록</span>
				</td>
					<td onclick="location.href='mypage.do?id=${loginUser.id}'">마이페이지</td>
			</tr>
		</table>
	
		<table>
			<tr>
				<td colspan="2">사원등록</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" size="20"  id="id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="password" name="pass" size="20">
				</td>
			</tr>
			<tr>
				<td>이름</td>
				 <td><input type="text" name="name" size="20"></td>
			</tr>
			<tr>
				<td>권한</td>
				<td>
					<select name="lev">
						<option value="A">일반회원</option>
						<option value="B">운영자</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<select name="gender">
						<option value="1">남자</option>
						<option value="2">여자</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="phone" size="20"></td>
			</tr>
			<tr>
            <td colspan="2" align="center">
            <input type="submit" value="등록" onclick="return joinCheck()">
              <input type="reset" value="취소">
              <input type="button" value="메인 페이지로 이동">
            </td>
         </tr>
		</table>
	
	</form>
</body>
</html>