<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "header.html" %>
<h1>確認画面</h1>
<p>下記内容で登録してよろしいですか。</p>
<p>ユーザー名：${Info.username}</p>
<p>パスワード：${Info.password}</p>
<p>Eメールアドレス:${Info.mailaddress}</p>
<p><a href = "MemberAction" class="styled">登録を確定する</a></p>
<p><input type "button" onclick="window.history.back();" value ="キャンセル" class="styled"></p>

<%@ include file = "footer.html" %>