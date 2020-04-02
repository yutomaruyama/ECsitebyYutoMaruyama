<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "header.html" %>
<%@ include file = "admin-header.jsp" %>

<h1>登録完了</h1>
<p>登録が完了しました。</p>
<p>画像がある場合は、下記フォームよりアップロードしてください。</p>
<form action = "UploadAction" enctype = "multipart/form-data" method = "post">
	<input type = "file" name = "file">
	<input type = "submit" value = "アップロード">
</form>
<p><button type = "button" class="styled"><a href = admin.jsp>管理画面へ戻る</a></button></p>

<%@ include file = "footer.html" %>