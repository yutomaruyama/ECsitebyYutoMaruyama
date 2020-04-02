<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "header.html" %>
<%@ include file = "login-out.jsp" %>

<h2>商品検索</h2>
<p>検索キーワードを入力してください。</p>
<form action = "ProductAction" method = "post">
	<p>商品名:<input type = "text" name = "keyword"></p>
	<p>価格:<input type = "text" name = "minprice">以上<input type = "text" name = "maxprice">以下</p>
	<p>メーカー:<input type = "text" name = "maker"></p>
	<label for ="category1">カテゴリー1:</label>
	<select id = "category1" name = "category1">
		<option></option>
		<option>オーディオ</option>
		<option>楽器</option>
		<option>DAW</option>
		<option>CD</option>
	</select>
	<label for = "category2">カテゴリー2:</label>
	<select id = "category2" name = "category2">
		<option></option>
		<option>ポータブルスピーカー</option>
		<option>エレキギター</option>
		<option>イヤホン</option>
		<option>ポータブルプレーヤー</option>
		<option>電子ピアノ</option>
		<option>ヘッドホン</option>
		<option>DAWソフトウェア</option>
		<option>CD</option>
	</select>
	<label for = "color">色:</label>
	<select id = "color" name = "color">
		<option></option>
		<option>black</option>
		<option>brown</option>
		<option>red</option>
		<option>white</option>
		<option>orange</option>
		<option>blue</option>
	</select><br>
	<p><input type = "submit" value = "検索" class="styled"></p>
</form>
<hr>

<%@ include file = "footer.html" %>