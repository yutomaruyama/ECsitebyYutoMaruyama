<%@ page contentType = "text/html; charset = UTF-8" pageEncoding="UTF-8" %>
<%@ include file = "header.html" %>

<header>
	<h1 class="headline">ログアウト確認</h1>
</header>

<p>ログアウトしますか？</p>
<p><button class="styled" type ="button"><a href="LogoutAction">ログアウト</a></button></p>
<p><input type "button" onclick="window.history.back();" value ="キャンセル" class="styled"></p>

<%@ include file = "footer.html" %>