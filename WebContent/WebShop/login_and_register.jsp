<!DOCTYPE>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>

<head>

<meta charset=UTF-8>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" href="../WebShop/css/bootstrap.min.css">
<link rel="stylesheet" href="../WebShop/css/login_and_register.css?v017">

<title>registered</title>
</head>

<body>
	<jsp:include page='header.jsp' />

	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<a href="#" class="active" id="login-form-link">會員登入</a>
							</div>
							<div class="col-xs-6">
								<a href="#" id="register-form-link">會員註冊</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<div class="wrapper">

									<form id="login-form"
										Action="<c:url value='/WebShop/LoginMember' />" method="post"
										role="form" style="display: block;">

										<h3 class="form-signin-heading">歡迎回來! 請先登入!</h3>
										<hr class="colorgraph">
										<br> <input type="text" class="form-control"
											name="Username" id="Username" placeholder="帳號"
											value="${param.Username}" />

										<div class="form-group text-center" style="color: #FF0000;">
											${ErrorMsgKey.AccountEmptyError}<br>
										</div>

										<input type="password" class="form-control" name="Password"
											id="Password" placeholder="密碼" value="${param.Password}" />

										<div class="form-group text-center" style="color: #FF0000;">
											${ErrorMsgKey.PasswordEmptyError}<br>
										</div>

										<div class="form-group text-center">
											<input type="checkbox" tabindex="3" class="" name="remember"
												id="remember"> <label for="remember">
												Remember Me</label>
										</div>

										<div class="form-group">
											<div class="row">
												<div class="col-sm-6 col-sm-offset-3">
													<button class="btn btn-lg btn-primary btn-block"
														name="Submit" value="Login" type="Submit">Login</button>
												</div>
											</div>
										</div>
										<div class="form-group">
											<div class="row">
												<div class="col-lg-12">
													<div class="text-center">
														<a href="http://phpoll.com/recover" tabindex="5"
															class="forgot-password">忘記密碼?</a>
													</div>
												</div>
											</div>
										</div>
										<div class="form-group text-center" style="color: #FF0000;">
											${ErrorMsgKey.LoginError}<br>
										</div>

									</form>




									<form id="register-form" method="post" role="form"
										style="display: none;"  action="POST的網址" enctype="multipart/form-data" class="form-horizontal">
										<!-- 									<form class="form-horizontal" role="form"> -->


										<div class="form-group">
											<label for="member_Username" class="col-sm-3 control-label">會員帳號</label>
											<div class="col-sm-8">
												 <input type="email" id="member_Username" name="Username"
													placeholder="example@abc.com.tw"
													class="form-control required emailCheck usernameCheck"
													>
												 <div class="form-group text-center col-sm-6 col-sm-offset-3" id='usernameCheckResult'></div>
											</div>
											
										</div>
										<div class="form-group">
											<label for="Password" class="col-sm-3 control-label">會員密碼</label>
											<div class="col-sm-8">
												<input type="password" id="PasswordID" name="Password"
													placeholder="6～20個數字和英文組成的字元" class="form-control required atoz_number"
													>
												
											</div>
											
										</div>
										<div class="form-group">
											<label for="Password2" class="col-sm-3 control-label">密碼確認</label>
											<div class="col-sm-8">
												<input type="password" id="Password2" name="Password2" placeholder="再輸入一次密碼"
													class="form-control required atoz_number">
											

											</div>
											
										</div>
									    <div class="form-group">
											<label for="Name" class="col-sm-3 control-label">會員姓名</label>
											<div class="col-sm-8">
												 <input type="text" id="Name" placeholder="請輸入真實姓名" class="form-control required" name="Name">
												
											</div>
											
											
										</div>
										<div class="form-group">
											<label for="Cellphone" class="col-sm-3 control-label">會員手機</label>
											<div class="col-sm-8">
												 <input type="text" id="Cellphone" name="Cellphone"
													placeholder="0900-000-000"
													class="form-control required cellphonecheck">
												
											</div>
											
										</div>
										<div class="form-group">
											<label for="birthday" class="col-sm-3 control-label">會員生日</label>
											<div class="col-sm-8">
												 <input type="date" name="Birthday" id="birthday"
													class="form-control required date dayCheck" value="1992/01/01">
												 
											</div>
										
										</div>
										<div class="form-group">
											<div class="col-sm-12">
												<hr class="colorgraph">
											</div>
										</div>									
										<div class="form-group">
											<div class="col-sm-6 col-sm-offset-3">
												<button type="submit" id="register-form-submit" class="btn btn-primary btn-block">註
													冊</button>
											</div>
										</div>
										
									</form>
									<!-- /form -->
								</div>
								<!-- ./container -->


							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<script src="../WebShop/js/jquery-3.1.1.min.js"></script>
	<script src="../WebShop/js/bootstrap.min.js"></script>
	<script src="../WebShop/js/jquery.validate.js"></script>
	<script src="../WebShop/js/jquery.ajaxupload.js"></script>
	<script src="../WebShop/js/login_and_register.js?v129"></script>
</body>

</html>