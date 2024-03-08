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
	<form action="#" method="post" name="frm">
		
		<table id="nav">
		<tr>
			<td>${mVo.name }님 반갑습니다</td>
			<td>레벨 : ${mVo.lev }</td>
			<td onclick="location.href='logout.do'">로그아웃</td>
			<td>
				<c:choose>
					<c:when test="${mVo.lev == 'A' }">
						<span onclick="location.href='update.do'">사원등록</span>
					</c:when>
					<c:otherwise>
						사원등록
					</c:otherwise>
				</c:choose>
			</td>
			
			<!-- 회원전용 페이지에서 마이페이지를 가려면 mypage.do로 get방식으로 요청을 보내야함
			여기서 loginUser세션으로 userid의 정보를 보내고 마이페이지에서는 이걸 가지고 다시 세션을 만들어서 jsp페이지에 전송-->
			<td onclick="location.href='mypage.do?id=${mVo.id}'">마이페이지</td>
		</tr>
	</table>
		<table>
			<tr>
				<td colspan="2">마이페이지</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td>${mVo.id }</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>${mVo.pass }</td>
			</tr>
			<tr>
				<td>이름</td>
				 <td>${mVo.name }</td>
			</tr>
			<tr>
				<td>권한</td>
				<td><c:choose>
					<c:when test="${mVo.lev == 'A'}">
						운영자
					</c:when>
					<c:otherwise>일반회원</c:otherwise>
				</c:choose></td>
			</tr>
			<tr>
				<td>성별</td>
				<td><c:choose>
					<c:when test="${mVo.gender == '1'}">
						남자
					</c:when>
					<c:otherwise>여자</c:otherwise>
				</c:choose></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td>${mVo.phone }</td>
			</tr>
			<tr>
            <td colspan="2" align="center">
            <input type="submit" value="메인 페이지로 이동">
            </td>
         </tr>
		</table>
	
	</form>
</body>
</html>