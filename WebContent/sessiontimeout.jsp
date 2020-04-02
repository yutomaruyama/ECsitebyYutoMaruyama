<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "header.html" %>
<%@ include file = "login-out.jsp" %>
<main>
	<p>セッションがタイムアウトしました。お手数ですがログイン画面からやり直し下さい。</p><br>
	<p><button class="styled" type ="button"><a href="index.jsp">トップへ戻る</a></button></p>
</main>
<%@ include file = "footer.html" %>