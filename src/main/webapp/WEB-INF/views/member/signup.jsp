<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Join</title>
	<link rel="icon" href="http://localhost/resources/favicon.ico">  
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <style>
    body {
      min-height: 100vh;
      background: -webkit-gradient(linear, left bottom, right top, from(#FBF5EF), to(#1d466c));
      background: -webkit-linear-gradient(bottom left, #FBF5EF 0%, #1d466c 100%);
      background: -moz-linear-gradient(bottom left, #FBF5EF 0%, #1d466c 100%);
      background: -o-linear-gradient(bottom left, #FBF5EF 0%, #1d466c 100%);
      background: linear-gradient(to top right, #FBF5EF 0%, #1d466c 100%);
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
<script language="JavaScript" src = "members.js"></script>
  <div class="container">
    <div class="input-form-backgroud row">
      <div class="input-form col-md-12 mx-auto">
        <h4 class="mb-3">Join</h4>
        <form role="form"name="reg_frm" method="post" autocomplete="off" >
          <div class="form-group">
              <label for="userId">아이디</label>
              <input type="text" class="form-control" id="userId" name="userId" placeholder="아이디를 입력해주세요." required="required">
              <label for="userPass">비밀번호</label>
              <input type="password" class="form-control" id="userPass" name="userPass" placeholder="비밀번호를 입력해주세요." required>
              <label for="userName">닉네임</label>
              <input type="text" class="form-control" id="userName" name="userName" placeholder="닉네임을 입력해주세요" required="required">
              <label for="userPhone">연락처</label>
              <input type="text" class="form-control" id="userPhone" name="userPhone" placeholder="연락처를 입력해주세요" required="required"  >
          </div>
          <button class="btn btn-light btn-lg btn-block" type="submit"  id="signup_btn" name="signup_btn">Join</button>
          <button class="btn btn-light btn-lg btn-block" type="reset" onclick="javascript:window.location='/'">Home</button>
        </form>
      </div>
    </div>
    <footer class="my-3 text-center text-small">
      <p class="mb-1">&copy; 2021 Weaver</p>
    </footer>
  </div>
</body>
</html>