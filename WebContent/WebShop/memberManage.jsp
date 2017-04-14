<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" href="../WebShop/css/bootstrap.min.css">
<link rel="stylesheet" href="../WebShop/css/load.css">
<link href="../WebShop/css/memberManage.css" rel="stylesheet">
<head>
<title>Java004_NO1 購物平台</title>
</head>

<body>

	<jsp:include page='header.jsp' />

	<div class="col-md-12 center" id="content">
		<input type="hidden" value="${MemberLoginOK.m_Username}"
			id="memberVal" />
		<section class="container-fuild" id="memberResult">
			<div class="row">
				<div class="col-md-3">
					<h3>帳戶資料</h3>
				</div>
				<div class="col-md-offset-7 col-md-2">
					<div class=" btn-warp check-btn">
								<button type="button" class="btn btn-primary btn-lg btn3d"
									data-toggle="modal" data-target="#myModal">編輯帳戶資料</button>
					</div>
				</div>
			</div>
			<hr>
			<div class="account-row">
				<form class="form-horizontal" style="font-weight: 900;">
	
					<div class="form-group">
						<div class="col-md-offset-4 col-md-1">會員帳號</div>
						<div class="col-md-4">${MemberLoginOK.m_Username}</div>
					</div>
					<div class="form-group">
						<div class="col-md-offset-4 col-md-1 info">會員密碼</div>
						<div class="col-md-4">
							<div class=" btn-warp check-btn">
								<button type="button" class="btn btn-magick btn-sm btn3d"
									data-toggle="modal" data-target="#myModalpwd">修改會員密碼</button>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-offset-4 col-md-1 info">會員姓名</div>
						<div class="col-md-4">${MemberLoginOK.m_Name}</div>
					</div>
					<div class="form-group">
						<div class="col-md-offset-4 col-md-1 info">會員地址</div>
						<div class="col-md-4">${MemberLoginOK.m_Address}</div>
					</div>
					<div class="form-group">
						<div class="col-md-offset-4 col-md-1 info">會員手機</div>
						<div class="col-md-4">${MemberLoginOK.m_Cellphone}</div>
					</div>
					<div class="form-group">
						<div class="col-md-offset-4 col-md-1 info">會員生日</div>
						<div class="col-md-4">${MemberLoginOK.m_Birthday}</div>
					</div>
				</form>

			</div>

			<!-- 編輯帳戶資料 -->
			
			
			<div id="myModal" class="modal fade" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">

						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title text-center" id="myModalLabel"
								style="font-weight: 900;">編輯帳戶資料</h4>
						</div>
						<hr>
						<div class="modal-body" style="font-weight: 700;">
							<form id="update-member-form" method="post" role="form"
								enctype="multipart/form-data" class="form-horizontal">

								<div class="form-group">
									<label for="member_Username" class="col-sm-3 control-label">會員帳號</label>
									<div class="col-sm-8">
										<input type="email" id="member_Username" name="Username"
											class="form-control" value="${MemberLoginOK.m_Username}"
											readonly>
									</div>

								</div>
								<div class="form-group">
									<label for="Name" class="col-sm-3 control-label">會員姓名</label>
									<div class="col-sm-8">
										<input type="text" id="Name" placeholder="請輸入真實姓名"
											class="form-control required" name="Name" autofocus
											value="${MemberLoginOK.m_Name}" />
									</div>
								</div>
								<div class="form-group" id="dvAddress">
									<div id="twAddrHelper"></div>
									<label for="Address" class="col-sm-3 control-label">會員地址</label>
									<div class="col-sm-8">
										<input type="hidden" class="cCountry" value="TW" /> <input
											type="text" name="Address" id="Address" placeholder="寄件地址"
											class="form-control required cAddress" autofocus
											value="${MemberLoginOK.m_Address}" />
									</div>
								</div>

								<div class="form-group">
									<label for="Cellphone" class="col-sm-3 control-label">會員手機</label>
									<div class="col-sm-8">
										<input type="text" id="Cellphone" name="Cellphone"
											placeholder="0900-000-000"
											class="form-control required cellphonecheck" autofocus
											value="${MemberLoginOK.m_Cellphone}" />

									</div>

								</div>
								<div class="form-group">
									<label for="birthday" class="col-sm-3 control-label">會員生日</label>
									<div class="col-sm-8">
										<input type="text" name="Birthday" id="birthday"
											class="form-control required date dayCheck" autofocus
											value="${MemberLoginOK.m_Birthday}" />

									</div>

								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">取消</button>
									<button type="button" class="btn btn-primary"
										id="update-member">儲存修改</button>
								</div>

							</form>
						</div>


					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<!-- /.modal -->
			
		<!-- 編輯帳戶資料  end------------------------                             -->
		
		
		<!-- 編輯帳戶資料 -->
			
			
			<div id="myModalpwd" class="modal fade" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">

						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title text-center" id="myModalLabel"
								style="font-weight: 900;">修改帳戶密碼</h4>
						</div>
						<hr>
						<div class="modal-body" style="font-weight: 700;">
							<form id="update-memberpassword-form" method="post" role="form"
								class="form-horizontal">
								<input type="hidden" id="member_Username" name="Username"
									value="${MemberLoginOK.m_Username}">
								<div class="form-group">
									<label class="col-sm-3 control-label">舊的密碼</label>
									<div class="col-sm-8">
										<input type="password" id="password1" class="form-control"
											name="password1" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">新的密碼</label>
									<div class="col-sm-8">
										<input type="password" id="password2" class="form-control"
											name="password2" />
									</div>
								</div>
								<div class="form-group" id="dvAddress">
									<label class="col-sm-3 control-label">新的密碼</label>
									<div class="col-sm-8">
										<input type="password" id="password3" class="form-control"
											name="password3" />
									</div>
								</div>


								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">取消</button>
									<button type="button" class="btn btn-primary"
										id="update-member-pwd">儲存修改</button>
								</div>

							</form>
						</div>


					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<!-- /.modal -->
			
		<!-- 編輯帳戶資料  end------------------------ -->
	

		</section>
		<section class="container-fuild" id="orderResult"></section>

	</div>




	<script src="../WebShop/js/jquery-3.1.1.min.js"></script>
	<script src="../WebShop/js/bootstrap.min.js"></script>
	<script src="../WebShop/js/load.js"></script>
	<script src="../WebShop/js/memberManage.js"></script>


</body>
</html>