<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Log in</title>
	<link rel="icon" href="http://localhost/resources/favicon.ico">
  
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <style>
    body {
      min-height: 100vh;
      background: -webkit-gradient(linear, left bottom, right top, from(#EFFBEF), to(#1d466c));
      background: -webkit-linear-gradient(bottom left, #EFFBEF 0%, #1d466c 100%);
      background: -moz-linear-gradient(bottom left, #EFFBEF 0%, #1d466c 100%);
      background: -o-linear-gradient(bottom left, #EFFBEF 0%, #1d466c 100%);
      background: linear-gradient(to top right, #EFFBEF 0%, #1d466c 100%);
    }
    .input-form {
      max-width: 400px;
      margin-top: 80px;
      padding: 20px;
      background: #fff;
      -webkit-border-radius: 10px;
      -moz-border-radius: 10px;
      border-radius: 10px;
      -webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
      -moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
      box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15)
    }
  </style>
</head>
<body>
  	<div class="container">
    <div class="input-form-backgroud row">
      <div class="input-form col-md-12 mx-auto">
        <h4 class="mb-3">Log in</h4>
        <form role="form" method="post" autocomplete="off">
          <div class="form-group">
              <label for="userId">아이디</label>
              <input type="text" class="form-control" id = "userId" name = "userId" required = "required" />
              <label for="userPass">비밀번호</label>
              <input type="password" class="form-control" id = "userPass" name = "userPass" required = "required" />
          </div>
          <button class="btn btn-light btn-lg btn-block" type="submit" id = "signin_btn" name = "signin_btn" >Log in</button>
			<c:if test = "${msg == false}">
				<p style = "color:#f00;">아이디나 비밀번호가 틀렸습니다!</p>
			</c:if>
        </form>
      </div>
    </div>
    <footer class="my-3 text-center text-small">
      <p class="mb-1">&copy; 2021 Weaver</p>
    </footer>
  </div>
</body>
</body>
</html>
