<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>글쓰기</h2>
	<form action="write.do" method="post" name="frm">
		<table>
			<tr>
				<td>번호</td>
				<td><input type="text" name="no" size="20"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="name" size="20"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" size="50"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content" rows="10" style="width:50%;"></textarea></td>
			</tr>
			<tr>	
				<td><input type="submit" value="전송"></td>
			</tr>
			<tr>
				<td colspan="2">${message}</td>
			</tr>
			
		</table>
	</form>
</body>
</html>