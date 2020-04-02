<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "header.html" %>
<%@ include file = "login-out.jsp" %>

<h2>検索結果</h2>
<h3 class="alert">${search.error}</h3>
<p class="result">検索条件：名前:${search.name},価格:${search.minPrice}以上${search.maxPrice}以下,メーカー:${search.maker},カテゴリー1:${search.category1},カテゴリー2:${search.category2},色:${search.color}</p>


<table style = "border-collapse:separate;border-spacing:10px;" class = "result">
<c:forEach var = "product" items = "${list}">
	<tr class="productresult">
	<td><img src = "img/${product.id}.jpg" height="80"></td>
	<td>${product.maker}/${product.name}/${product.color}</td>
	<td>価格:${product.price}円(税込み${product.pricetax}円)</td>
	<td>在庫:${product.stock}</td>
	<td><a href = "InfoAction?id=${product.id}">商品詳細</a>
	<form action = "CartAddAction?id=${product.id}" method = "post">
		<p>数:<input type ="text" name ="count" class="count"></p>
		<input type = "submit" value = "カートに追加" class="styled">
	</form>
	</tr>
</c:forEach>
</table>


<%@ include file = "footer.html" %>