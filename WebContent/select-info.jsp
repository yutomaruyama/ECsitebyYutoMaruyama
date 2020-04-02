<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "header.html" %>
<%@ include file = "admin-header.jsp" %>

<h2>変更情報</h2>
<p class="alert">${alert.error}</p>
<p>変更内容を記載してください。</p>
<form action ="PreUpdateAction" method = "post">
	<p>商品名:${info.name}→<input type = "text" name = "name"></p>
	<p>価格（税込み）:${info.price}→<input type = "text" name = "price"></p>
	<p>メーカー:${info.maker}→<input type = "text" name = "maker"></p>
	<label for ="category1">カテゴリー1:${info.category1}→</label>
	<select id = "category1" name = "category1">
		<option>オーディオ</option>
		<option>楽器</option>
		<option>DAW</option>
		<option>CD</option>
	</select>
	<label for = "category2">カテゴリー2:${info.category2}→</label>
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
	<p>色:${info.color}→<input type = "text" name = "color"></p>
	<p>在庫:${info.stock}→<input type = "text" name = "stock"></p>
	<input type = "submit" value = "変更" class="styled">
</form>

<%@ include file = "footer.html" %>