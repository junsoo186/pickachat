<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="layout/header.jsp" />

<div class="main-content">
    <!-- 왼쪽 사이드바: 채널 리스트 등 -->
    <div class="sidebar">
        <ul>
            <li>일반 채널</li>
            <li>공지사항</li>
            <li>게임</li>
            <!-- 추가 채널 -->
        </ul>
    </div>
    <!-- 오른쪽 채팅 영역 -->
    <div class="chat-area">
        <div class="chat-messages">
            <!-- 실시간 채팅 메시지 영역 (자바스크립트로 동적 업데이트 예정) -->
        </div>
        <div class="chat-input">
            <input type="text" id="chatMessage" placeholder="메시지를 입력하세요...">
            <button type="button" id="sendButton">전송</button>
        </div>
    </div>
</div>

<jsp:include page="layout/footer.jsp" />
