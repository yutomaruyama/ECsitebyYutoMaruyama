<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "header.html" %>
<%@ include file = "admin-header.jsp" %>
<h2>削除対象商品</h2>
<table>
	<thead>
		<tr>
			<th>項目</th>
			<th>登録情報</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>ID</td>
			<td>${check.id}</td>
		</tr>
		<tr>
			<td>商品名</td>
			<td>${check.name}</td>
		</tr>
		<tr>
			<td>価格</td>
			<td>${check.price}</td>
		</tr>
		<tr>
			<td>メーカー</td>
			<td>${check.maker}</td>
		</tr>
		<tr>
			<td>カテゴリー１</td>
			<td>${check.category1}</td>
		</tr>
		<tr>
			<td>カテゴリー２</td>
			<td>${check.category2}</td>
		</tr>
		<tr>
			<td>色</td>
			<td>${check.color}</td>
		</tr>
		<tr>
			<td>在庫</td>
			<td>${check.stock}</td>
		</tr>
	</tbody>
</table>
<p>上記の商品を削除してよいですか？</p>
<form action = "DeleteAction" method = "post">
	<input type = "submit" value = "はい" class="styled">
</form>
<p><input type "button" onclick="window.history.back();" value ="キャンセル" class="styled"></p>

<%@ include file = "footer.html" %>