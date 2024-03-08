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
	
	<table id="nav">
		<tr>
			<td>${loginUser.name }님 반갑습니다</td>
			<td>레벨 : ${loginUser.lev }</td>
			<td onclick="location.href='logout.do'">로그아웃</td>
			<td>
				<c:choose>
					<c:when test="${loginUser.lev == 'A' }">
						<span onclick="location.href='update.do'">사원등록</span>
					</c:when>
					<c:otherwise>
						사원등록
					</c:otherwise>
				</c:choose>
			</td>
			
			<!-- 회원전용 페이지에서 마이페이지를 가려면 mypage.do로 get방식으로 요청을 보내야함
			여기서 loginUser세션으로 userid의 정보를 보내고 마이페이지에서는 이걸 가지고 다시 세션을 만들어서 jsp페이지에 전송-->
			<td onclick="location.href='mypage.do?id=${loginUser.id}'">마이페이지</td>
		</tr>
	</table>
	<h2>회원전용 페이지</h2>
	${loginUser }
</body>
</html>