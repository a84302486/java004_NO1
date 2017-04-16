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
<link rel="stylesheet" href="../WebShop/css/drag.css">
<link rel="stylesheet" href="../WebShop/css/load.css">
<link rel="stylesheet" href="../WebShop/css/jquery.autocomplete.css">
<link rel="stylesheet" href="../WebShop/css/login_and_register.css">


<title>registered</title>
</head>

<body id="body">
	<jsp:include page='header.jsp' />

	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login" id="panel">
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
										role="form">

										<h3 class="form-signin-heading">歡迎回來! 請先登入!</h3>
										<hr class="colorgraph">
										<br>
										<c:choose>
											<c:when test="${empty ErrorMsgKey}">
												<input type="text" class="form-control" name="Username"
													id="Username" placeholder="帳號"
													value="${sessionScope.username}" autofocus />

												<div class="form-group text-center" style="color: #FF0000;">
													${ErrorMsgKey.AccountEmptyError}<br>
												</div>

												<input type="password" class="form-control" name="Password"
													id="Password" placeholder="密碼"
													value="${sessionScope.password}" autofocus />
											</c:when>

											<c:otherwise>
												<input type="text" class="form-control" name="Username"
													id="Username" placeholder="帳號"
													value="${param.Username}" autofocus />

												<div class="form-group text-center" style="color: #FF0000;">
													${ErrorMsgKey.AccountEmptyError}
												</div>

												<input type="password" class="form-control" name="Password"
													id="Password" placeholder="密碼"
													value="${param.Password}" autofocus />
											</c:otherwise>
										</c:choose>


										<div class="form-group text-center" style="color: #FF0000;">
											${ErrorMsgKey.PasswordEmptyError}
										</div>
										
										<c:choose>
											<c:when test="${empty cookie['SESSION_LOGIN_USERNAME']}">
												<div class="form-group text-center">
											<input type="checkbox" tabindex="3" class="" name="remember"
												id="remember" value="true"> <label for="remember">
												記住我</label>
										</div>
											</c:when>

											<c:otherwise>
												<div class="form-group text-center">
											<input type="checkbox" tabindex="3" class="" name="remember"
												id="remember" value="true" checked> <label for="remember">
												記住我</label>
										</div>
											</c:otherwise>
										</c:choose>
									
										<div id="drag" class="form-group col-sm-offset-2"></div>
										<!-- 										<div class="form-group"> -->
										<!-- 											<div class="row"> -->
										<!-- 												<div id="drag" class="col-sm-offset-3"> -->
										<!-- 												</div> -->
										<!-- 											</div> -->
										<!-- 										</div> -->


										<div class="form-group">
											<div class="row">
												<div class="col-sm-6 col-sm-offset-3">
													<button class="btn btn-lg btn-primary btn-block"
														name="Submit" id="loginSubmit" type="Submit" disabled>Login</button>
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
										style="display: none;"  enctype="multipart/form-data" class="form-horizontal">
										<!-- 									<form class="form-horizontal" role="form"> -->


										<div class="form-group">
											<label for="member_Username" class="col-sm-3 control-label">會員帳號</label>
											<div class="col-sm-8">
												 <input type="email" id="member_Username" name="Username"
													placeholder="example@abc.com.tw"
													class="form-control required emailCheck usernameCheck"
													autofocus>
<!-- 												 <div class="form-group text-center col-sm-6 col-sm-offset-3" id='usernameCheckResult'></div> -->
											</div>
											
										</div>
										<div class="form-group">
											<label for="Password" class="col-sm-3 control-label">會員密碼</label>
											<div class="col-sm-8">
												<input type="password" id="PasswordID" name="Password"
													placeholder="6～20個數字和英文組成" class="form-control required atoz_number"
													autofocus>
											</div>
											
											
										</div>
										
										<div class="form-group">
											<label for="Password2" class="col-sm-3 control-label">密碼確認</label>
											<div class="col-sm-8">
												<input type="password" id="Password2" name="Password2" placeholder="再輸入一次密碼"
													class="form-control required atoz_number" autofocus>
											

											</div>
											
										</div>
										<div class="form-group">
											<label for="Name" class="col-sm-3 control-label">會員姓名</label>
											<div class="col-sm-8">
												<input type="text" id="Name" placeholder="請輸入真實姓名"
													class="form-control required" name="Name" autofocus>

											</div>


										</div>
										

										<div class="form-group" id="dvAddress">		
											<div id="twAddrHelper"></div>
											<label for="Address" class="col-sm-3 control-label">會員地址</label>
											<div class="col-sm-8">
												<input type="hidden" class="cCountry" value="TW" /> 
												<input type="text" name="Address" id="Address" placeholder="寄件地址" class="form-control required cAddress" autofocus/>
											</div>
										</div>

										<div class="form-group">
											<label for="Cellphone" class="col-sm-3 control-label">會員手機</label>
											<div class="col-sm-8">
												 <input type="text" id="Cellphone" name="Cellphone"
													placeholder="0900-000-000"
													class="form-control required cellphonecheck" autofocus>
												
											</div>
											
										</div>
										<div class="form-group">
											<label for="birthday" class="col-sm-3 control-label">會員生日</label>
											<div class="col-sm-8">
												 <input type="date" name="Birthday" id="birthday"
													class="form-control required date dayCheck" value="" autofocus>
												 
											</div>
										
										</div>
										<div class="form-group">
											<div class="col-sm-12">
												<hr class="colorgraph">
											</div>
										</div>
									 
									 	
										<div class="form-group">
											<div class="col-sm-6 col-sm-offset-3">
												<button class="btn btn-primary btn-block" type="submit" id="register-form-submit">註冊</button>  
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
	<script src="../WebShop/js/drag.js"></script>
	<script src="../WebShop/js/load.js"></script>
	<script src="../WebShop/js/jquery.autocomplete.js"></script>
    <script src="../WebShop/js/jquery.twAddrHelper.js"></script>
	<script src="../WebShop/js/login_and_register.js"></script>
</body>

</html>