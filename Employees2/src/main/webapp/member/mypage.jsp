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
<script type="text/javascript" src="script/employee.js"></script>
</head>
<body>
	<form action="mypage.do" method="post" name="frm">
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
				<td><input type="text" name="id" value="${mVo.id }" 
            	readonly="readonly" size="20"  id="id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="password" name="pass" size="20">
				</td>
			</tr>
			<tr>
				<td>이름</td>
				 <td><input type="text" name="name" value="${mVo.name }" size="20"></td>
			</tr>
			<tr>
				<td>권한</td>
				<td>
					<c:choose>
						<c:when test="${mVo.lev=='A' }">
							<select name="lev">
								<option value="B">일반회원</option>
								<option value="A" selected>운영자</option>
							</select>
						</c:when>
						<c:otherwise>
							<select name="lev">
								<option value="B" selected>일반회원</option>
								<option value="A">운영자</option>
							</select>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<c:choose>
						<c:when test="${mVo.gender=='1' }">
							<select name="gender">
								<option value="1"selected>남자</option>
								<option value="2" >여자</option>
							</select>
						</c:when>
						<c:otherwise>
							<select name="gender">
								<option value="1" >남자</option>
								<option value="2"selected>여자</option>
							</select>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="phone" value="${mVo.phone }" size="20"></td>
			</tr>
			<tr>
            <td colspan="2" align="center">
            <input type="submit" value="수정" onclick="return joinCheck()">
              <input type="reset" value="취소">
            </td>
         </tr>
		</table>
	
	</form>
</body>
</html>