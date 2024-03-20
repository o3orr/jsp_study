<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>1:1 채팅</title>
    <script>
        var websocket;
        function connect() {
            websocket = new WebSocket("ws://" + location.hostname + ":8080/ChatApp/chat");
            websocket.onopen = function(event) {
                console.log("웹소켓 연결 성공");
            };
            websocket.onmessage = function(event) {
                var chatBox = document.getElementById("chatBox");
                chatBox.innerHTML += event.data + "<br>";
                chatBox.scrollTop = chatBox.scrollHeight;
            };
            websocket.onclose = function(event) {
                console.log("웹소켓 연결 종료");
            };
            websocket.onerror = function(event) {
                console.error("웹소켓 에러 발생");
            };
        }
        function sendMessage() {
            var message = document.getElementById("message").value;
            if (message.trim() != "") {
                websocket.send(message);
                document.getElementById("message").value = "";
            }
        }
        window.onload = function() {
            connect();
        };
    </script>
</head>
<body>
    <h1>1:1 채팅</h1>
    <div id="chatBox" style="height: 300px; overflow-y: scroll;"></div>
    <input type="text" id="message" placeholder="메시지 입력">
    <button onclick="sendMessage()">전송</button>
</body>
</html>
