<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>상품 정보 입력 폼</h2>
	<form method="post" action="additem.jsp">
		<table>
			<tr>
				<td>상품이름</td>
				<td><input type="text" name="name" size="20"></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text" name="price" size="8"></td>
			</tr>
			<tr>
				<td>상품설명</td>
				<td><input type="text" name="description" size="100"></td>
			</tr>
			<tr>
				<td><input type="submit" value="전송"></td>
				<td><input type="reset" value="취소"></td>
			</tr>
		</table>
	</form>
</body>
</html>