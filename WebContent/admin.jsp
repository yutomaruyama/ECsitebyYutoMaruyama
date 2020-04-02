<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "header.html" %>
<%@ include file ="admin-header.jsp" %>

<main class="admin">
	<a href = "insert-in.jsp"><button class="styled" type="button">商品登録</button></a>
	<a href = "select-in.jsp"><button class="styled" type="button">商品情報変更</button></a>
	<a href = "delete-in.jsp"><button class="styled" type="button">商品削除</button></a>
</main>

<%@ include file = "footer.html" %>