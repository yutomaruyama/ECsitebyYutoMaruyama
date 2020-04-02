<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "header.html" %>
<%@ include file = "login-out.jsp" %>
<h1>購入確定</h1>
<table style = "border-collapse:separate;border-spacing:10px;">
<c:forEach var = "log" items = "${cartlog}">
	<tr>
	<td><img src  = "img/${log.product.id}.jpg" height = "96"></td>
	<td>${log.product.maker}/${log.product.name}/${log.product.color}</td>
	<td>${log.product.price}円</td>
	<td>消費税:${log.product.tax}円</td>
	<td>税込み:${log.product.pricetax}円</td>
	<td>${log.count}個</td>
	<td>小計:${log.subtotalPrice}円</td>
	</tr>
</c:forEach>
	<tr>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
	<td>合計</td>
	<td>${total.totalCount}個</td>
	<td>${total.totalPrice}円</td>
	</tr>
</table>
<hr>
<p>購入手続きが完了しました。</p>
<a href = "main.jsp"><button class="styled" type ="button">メイン画面へ戻る</button></a>

<%@ include file = "footer.html" %>