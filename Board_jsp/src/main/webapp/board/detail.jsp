<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 상세보기</title>
</head>
<body>
        글번호: ${detail.no }<br>
        제목: ${detail.title } <br>
        내용: ${detail.content }<br>
        작성자: ${detail.name }<br>
        작성일: ${detail.date }<br>

        <button value="수정" onclick="location.href='update.do?no=${detail.no}'">수정</button>
        <button value="삭제" onclick="location.href='delete.do?no=${detail.no}'">삭제</button>
        <button value="리스트로" onclick="location.href='list.do'">리스트로</button>

   
</body>
</html>