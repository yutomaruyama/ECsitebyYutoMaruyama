<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "header.html" %>

 <main>
	 <div class = "introduction">
		<p class="alert">${Emsg.emsg}</p>
	 	<p id = "introduction1">We wanna support you to enjoy your music life!</p>
	 	<p id = "introduction2">Welcome to Our Shopping Site!</p>
	 	<p id = "introduction3"> Please scroll! ↓</p>
	 </div>
 </main>
 <div class="login-page">
 	<div class="form">
 		<form class="register-form" action = "JoinAction" method = "post">
 			<input type ="text" placeholder="name" name = "username"/>
 			<input type ="password" placeholder="password" name = "password"/>
 			<input type ="password" placeholder="password(check)" name = "check"/>
 			<input type ="text" placeholder="emailaddress" name = "mailaddress"/>
 			<label><input type = "checkbox" name = "norobot" id = "norobots">確認のため、チェックしてください。（私はロボットではありません）</label>
 			<input type ="submit" value="create" class="button" id="create">
 			<p class="message">Already registered? <a href="#">Sigh In</a></p>
 		</form>
 		<form class="login-form" action ="LoginServlet" method="post">
 		 <input type ="text" placeholder="username" name ="username"/>
 		 <input type ="password" placeholder="password" name ="password"/>
 		 <label><input type = "checkbox" name = "norobot" id = "norobot">確認のため、チェックしてください。（私はロボットではありません）</label>
 		 <input type ="submit" value="login" class="button" id="login">
 		 <p class="message">Not registered? <a href="#">Create an account</a></p>
 		</form>
 	</div>
 </div>

<%@ include file = "footer.html" %>