<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "header.html" %>
<%@ include file = "admin-header.jsp" %>

<h2>商品登録画面</h2>
<p class="alert">${alert.error}</p>
<p>登録商品情報</p>
<form action = "PreInsertAction" method = "post">
	<p>商品名:<input type = "text" name = "name"></p>
	<p>価格（税抜き）:<input type = "text" name = "price"></p>
	<p>メーカー/アーティスト:<input type = "text" name = "maker"></p>
	<label for ="category1">カテゴリー1:</label>
	<select id = "category1" name = "category1">
		<option>オーディオ</option>
		<option>楽器</option>
		<option>DAW</option>
		<option>CD</option>
	</select>
	<label for = "category2">カテゴリー2:</label>
	<select id = "category2" name = "category2">
		<option>ポータブルスピーカー</option>
		<option>エレキギター</option>
		<option>イヤホン</option>
		<option>ポータブルプレーヤー</option>
		<option>電子ピアノ</option>
		<option>ヘッドホン</option>
		<option>DAWソフトウェア</option>
		<option>CD</option>
	</select>
	<p>色:<input type = "text" name = "color"></p>
	<p>在庫:<input type = "text" name = "stock"></p>
	<p>情報(255字まで):<input type = "text" name = "info"></p>
	<input type = "submit" value = "登録" class="styled">
</form>

<%@ include file = "footer.html" %>