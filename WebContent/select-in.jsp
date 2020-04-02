<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "header.html" %>
<%@ include file = "admin-header.jsp" %>

<p>検索キーワードを入力してください。</p>
<form action = "ProductAction" method = "post">
	<p>商品名:<input type = "text" name = "keyword"></p>
	<p>価格:<input type = "text" name = "minprice">以上<input type = "text" name = "maxprice">以下</p>
	<p>メーカー/アーティスト:<input type = "text" name = "maker"></p>
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
	<p>色:<input type = "text" name = "color"></p>
	<input type = "submit" value = "検索" class="styled">
</form>
<hr>

<table style = "border-collapse:separate;border-spacing:10px;">
<c:forEach var = "product" items = "${list}">
	<tr>
	<td>商品${product.id}</td>
	<td><img src = "img/${product.id}.jpg" height="64"></td>
	<td>${product.name}</td>
	<td>${product.price}円</td>
	<td>${product.maker}</td>
	<td>${product.category1}</td>
	<td>${product.category2}</td>
	<td>${product.color}</td>
	<td>在庫:${product.stock}</td>
	<td><a href="SelectAction?id=${product.id}" class="styled">この商品を変更</a></td>
	</tr>
</c:forEach>
</table>

<%@ include file = "footer.html" %>