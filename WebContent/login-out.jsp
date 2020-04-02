<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "header.html" %>
	 <header>
	 <h1 class = "headline"><a href = "main.jsp">Dear ${user.username}, Welcome to "JOY TO THE MUSIC"!</a></h1>
	 <ul class = "nav-list">
	 	<li class="nav-list-item"><a href = "logout-in.jsp" class="styled">ログアウト</a></li>
	 	<li class="nav-list-item"><a href = "product.jsp" class="styled">商品検索</a></li>
	 	<li class="nav-list-item"><a href = "cart.jsp" class="styled">カートを見る</a></li>
	 	<li class="nav-list-item"><a href = "PreviewAction" class="styled">購入</a></li>
	 </ul>
 	</header>
