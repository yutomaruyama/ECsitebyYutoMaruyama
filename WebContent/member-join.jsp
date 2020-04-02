<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "header.html" %>

<h1>新規会員登録</h1>
<p>${Emsg.emsg}</p>
<form action = "JoinAction" method = "post">
<p>ユーザー名<input type = "text" name = "username"></p>
<p>パスワード<input type = "password" name = "password"></p>
<p>パスワード（確認用）<input type = "password" name = "check"></p>
<input type = "checkbox" name = "norobot"><p>確認のため、チェックしてください。（私はロボットではありません）</p>
<input type = "submit" value = "会員登録">
</form>

<%@ include file = "footer.html" %>