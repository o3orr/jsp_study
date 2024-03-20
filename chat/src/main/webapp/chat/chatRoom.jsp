<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>채팅</title>
    <meta http-equiv="refresh" content="2"> <!-- 2초마다 페이지를 리로드 -->
</head>
<body>
    <h1>채팅</h1>
    <div id="chatBox">
        <c:forEach items="${messagesList}" var="message">
            <p>${message.sender_id} : ${message.message_content}</p>
        </c:forEach>
        <form action="ChatServlet" method="post">
        	<input type="hidden" name="command" value="chat_post">
        	<input type="hidden" name="message_id" value="${message.message_id}">
        	<input type="hidden" name="conversation_id" value="${message.conversation_id}">
        	<input type="hidden" name="sender_id" value="${loginUser.id}">
        	<input type="hidden" name="receiver_id" value="${message.receiver_id}">
        	<input type="hidden" name="creation_date" id="creation_date">
        	<input type="text" name="message_content" id="message_content" value="메시지를 입력하세요"> 
        	<input type="submit" value="전송">
        </form>
    </div>
    <script>
        // 이전 입력 값을 로컬 스토리지에서 가져와서 입력창에 설정하고 포커스를 설정합니다.
        window.onload = function() {
            var savedMessage = localStorage.getItem("savedMessage");
            var savedDate = localStorage.getItem("savedDate");
            
            if (savedMessage) {
                document.getElementById("message_content").value = savedMessage;
            }
            
            if (savedDate) {
                document.getElementById("creation_date").value = savedDate;
            }
            
            // 입력창에 포커스를 설정합니다.
            document.getElementById("message_content").focus();
        };
        
        // 입력한 메시지를 로컬 스토리지에 저장합니다.
        document.getElementById("message_content").addEventListener("input", function() {
            localStorage.setItem("savedMessage", this.value);
        });
        
        // 현재 시간을 표시하는 함수
        function displayCurrentTime() {
            var now = new Date();
            var hours = now.getHours();
            var minutes = now.getMinutes();
            var seconds = now.getSeconds();
            var currentTime = hours + ":" + minutes + ":" + seconds;
            
            // 현재 시간을 표시할 input 요소에 적용
            document.getElementById("creation_date").value = currentTime;
            
            // 현재 시간을 로컬 스토리지에 저장
            localStorage.setItem("savedDate", currentTime);
        }
        
        // 매 초마다 현재 시간을 업데이트
        setInterval(displayCurrentTime, 1000);
        
        // 페이지 로드시 초기에도 현재 시간을 표시
        displayCurrentTime();
    </script>
</body>
</html>
