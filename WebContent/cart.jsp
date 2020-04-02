<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "header.html" %>
<%@ include file = "login-out.jsp" %>

<h1>商品カート</h1>
<c:choose>
	<c:when test="${cart.size()>0}">
		<p>${cart.size()}種類の商品があります。</p>
		<hr>
	</c:when>
	<c:otherwise>
		<p>カートに商品がありません。</p>
	</c:otherwise>
</c:choose>

<table style = "border-collapse:separate;border-spacing:10px;">
<c:forEach var = "item" items="${cart}">
	<tr>
	<td><img src = "img/${item.product.id}.jpg" height = "96"></td>
	<td>${item.product.maker}/${item.product.name}/${item.product.color}</td>
	<td>${item.product.price}円</td>
	<td>（税込み${item.product.pricetax}円）</td>
	<td>${item.count}個</td>
	<td>小計:${item.subtotalPrice}円</td>
	<td><form action="CartCountChangeAction?id=${item.product.id}" method ="post">
	<p><input type ="text" name="count" class="count">個に</p>
	<input type="submit" value="変更" class="changesub">
	</form></td>
	<td><a href = "CartRemoveAction?id=${item.product.id}" class ="styled">カートから削除</a></td>
	</tr>
</c:forEach>
	<tr>
	<td></td>
	<td></td>
	<td></td>
	<td>合計</td>
	<td>${total.totalCount}個</td>
	<td>${total.totalPrice}円</td>
	</tr>
</table>
<a href = "PreviewAction"><button class="styled" type ="button">購入画面へ進む</button></a>
<%@ include file = "footer.html" %>