<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "header.html" %>
<%@ include file = "login-out.jsp" %>

 	<main>
 		<div class = "localNavigation">
 			<h2>カテゴリから探す</h2>
 			<div class = "categorysearch">
 			<a href = "ProductAction?category1=audio">オーディオ</a><br>
 			<a href = "ProductAction?category2=portablespeaker">→ポータブルスピーカー</a><br>
 			<a href = "ProductAction?category2=earphone">→イヤホン</a><br>
 			<a href = "ProductAction?category2=portableplayer">→ポータブルプレーヤー</a><br>
 			<a href = "ProductAction?category2=headphone">→ヘッドホン</a><br>
 			<a href = "ProductAction?category1=instrument">楽器</a><br>
 			<a href = "ProductAction?category2=electricalguiter">→エレキギター</a><br>
 			<a href = "ProductAction?category2=electricalpiano">→電子ピアノ</a><br>
 			<a href = "ProductAction?category1=DAW">DAW</a><br>
 			<a href = "ProductAction?category2=DAWsoftwear">→DAWソフトウェア</a><br>
 			<a href = "ProductAction?category1=CD">CD</a><br>
 			</div>
 			<h2>メーカーから探す</h2>
 			<div class = "categorysearch">
 			<a href = "ProductAction?maker=Anker">Anker</a><br>
 			<a href = "ProductAction?maker=epiphone">epiphone</a><br>
 			<a href = "ProductAction?maker=JVC">JVC</a><br>
 			<a href = "ProductAction?maker=mansso">mansso</a><br>
 			<a href = "ProductAction?maker=Roland">Roland</a><br>
 			<a href = "ProductAction?maker=Sony">Sony</a><br>
 			<a href = "ProductAction?maker=Steinberg">Steinberg</a><br>
 			</div>
 			<h2>価格帯から探す</h2>
 			<div class = "categorysearch">
 			<a href = "ProductAction?maxprice=5000">～5000円</a><br>
 			<a href = "ProductAction?maxprice=10000&amp;minprice=5001">5001～10000円</a><br>
			<a href = "ProductAction?maxprice=15000&amp;minprice=10001">10001～15000円</a><br>
			<a href = "ProductAction?maxprice=20000&amp;minprice=15001">15001～20000円</a><br>
			<a href = "ProductAction?maxprice=25000&amp;minprice=20001">20001～25000円</a><br>
			<a href = "ProductAction?maxprice=30000&amp;minprice=25001">25001～30000円</a><br>
 			<a href = "ProductAction?minprice=30001">30001円～</a><br>
 			</div>
 		</div>
 		<div class = "contents">
 			<h2>音楽を</h2>
 			<div class = "content-area">
	 			<div class = "content">
	 				<a href = "ProductAction?category1=audio"><img id ="listen" src="" class = "slide"></a>
	 				<div class ="absolute"><h3>Listen</h3></div>
	 			</div>
	 			<div class = "content">
	 				<a href = "ProductAction?category1=instrument"><img id ="play" src="" class = "slide"></a>
	 				<div class ="absolute"><h3>Play</h3></div>
	 			</div>
	 			<div class = "content">
	 				<a href = "ProductAction?category1=DAW"><img id ="make" src="" class = "slide"></a>
	 				<div class ="absolute"><h3>Make</h3></div>
	 			</div>
	 			<div class = "content">
	 				<a href = "ProductAction?category1=CD"><img id ="choose" src="" class = "slide"></a>
	 				<div class ="absolute"><h3>Choose</h3></div>
	 			</div>
 			</div>
 		</div>
 	</main>
<%@ include file = "footer.html" %>