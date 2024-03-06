<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<!-- <body>가 뜰 때 itemAdd()함수를 호출해준다 -->
<body onload="itemAdd();">

<form action="listTest" method="post" name="myForm">

<table border="0" style="font-size: 10pt;" align="center">

<tr align="center"> <!-- 표 내부의 행 -->
	<td width="150">전체리스트</td>	 <!-- 행 내부에 일반셀 -->
	<td width="70">&nbsp;</td>	
	<td width="150">받는사람</td>	
</tr>

<tr align="center">

	<!-- 전체리스트 박스 -->
	<td width="150">
	<select name="leftItem" multiple="multiple" size="7" class="itemList">
		<!-- <option value="배수지">배수지</option> -->
	</select>
	</td>
	
	<!-- 왼쪽 오른쪽 버튼 -->
	<td width="70">
		<input type="button" class="itemBtn" value="&gt;" onclick="itemMove('right');"/><br>
		<input type="button" class="itemBtn" value="&lt;" onclick="itemMove('left');"/><br>
	</td>
	
	<!-- 받는 사람 박스 -->
	<td width="150">
	<select name="rightItem" multiple="multiple" size="7" class="itemList">
	
	</select>
	</td>
</tr>
<tr>
	<td colspan="3" align="center">
	<br>메세지<br>
	<textarea rows="5" cols="42" name="msg"></textarea>
	</td>
</tr>

<tr>
	<td colspan="3" align="center">
		<input type="button" class="btn" value="쪽지보내기"/><br>
	</td>
</tr>
	

</table>

</form>

</body>
</html>