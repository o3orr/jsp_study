<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 상세보기</title>
</head>
<body>
        글번호: ${updatedetail.no }<br>
        제목: ${updatedetail.title } <br>
        내용: ${updatedetail.content }<br>
        작성자: ${updatedetail.name }<br>
        작성일: ${updatedetail.date }<br>

        <button value="수정" onclick="location.href='update.do?no=${updatedetail.no}'">수정</button>
        <button value="삭제" onclick="location.href='delete.do?no=${updatedetail.no}'">삭제</button>
        <button value="리스트로" onclick="location.href='list.do'">리스트로</button>

   
</body>
</html>