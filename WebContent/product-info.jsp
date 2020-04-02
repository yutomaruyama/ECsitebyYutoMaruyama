<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "header.html" %>
<%@ include file = "login-out.jsp" %>

<h1>商品詳細ページ</h1>
	<p><img src = "img/${info.id}.jpg" class="infoimg"></p>
	<h2>商品名:${info.name}</h2>
	<p>価格:${info.price}円（税込み${info.pricetax}円）</p>
	<p>メーカー:${info.maker}</p>
	<p>商品の説明：${info.info}</p>
<form action = "CartAddAction?id=${info.id}" method = "post">
	<p>数:<input type = "text" name = "count" class="count"></p>
	<input type = "submit" value = "カートに追加" class="styled">
</form>


<%@ include file = "footer.html" %>