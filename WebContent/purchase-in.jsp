<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "header.html" %>
<%@ include file = "login-out.jsp" %>

<p class="alert">${alert.error}</p>
<p>${cart.size()}種類の商品があります。</p>
<hr>

<table style = "border-collapse:separate;border-spacing:10px;">
<c:forEach var = "item" items = "${cart}">
	<tr>
	<td><img src  = "img/${item.product.id}.jpg" height = "96"></td>
	<td>${item.product.maker}/${item.product.name}/${item.product.color}</td>
	<td>${item.product.price}円</td>
	<td>消費税:${item.product.tax}円</td>
	<td>税込み:${item.product.pricetax}円</td>
	<td>${item.count}個</td>
	<td>小計:${item.subtotalPrice}円</td>
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

<form action = "PrePurchaseAction" method = "post" onsubmit = "return checkText()" name = "customerinfo">
	<p>お名前<input type = "text" name = "name"></p>
	<p>ご住所<input type = "text" name = "address"></p>
	<p><input type = "submit" value = "購入" class="styled"></p>
</form>

<%@ include file = "footer.html" %>