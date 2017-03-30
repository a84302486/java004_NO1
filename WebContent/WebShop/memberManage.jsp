<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link href="css/memberManage.css" rel="stylesheet">

<head>
    <title>Java004_NO1 購物平台</title>
</head>

<body>

  	<jsp:include page='header.jsp' />
	
	<div class="col-md-12 center" id="content">
	<input type="hidden" value="${MemberLoginOK.m_Username}" id="memberVal"/>
	<section class="container-fuild" id="memberResult">
		<h3 class="side-heading">
            <span class="text">帳戶資料</span>
          </h3>
          <hr>
          <div class="account-row">
            <div class="shoplist-container">
                <div class="form-warp account-form">
              <form class="form-horizontal">          
                  <div class="form-group">
                    <label class="col-sm-3 col-md-2 control-label"> 會員帳號：</label>
                    <div class="col-sm-9 col-md-10">
                      <span class="label-text">${MemberLoginOK.m_Username}</span>
                    </div>
                  </div>

                  <div class="form-group">
                    <label class="col-sm-3 col-md-2 control-label"> 會員密碼：</label>
                    <div class="col-sm-9 col-md-10">
                      <span class="label-text"> <a href="/account/modify_password" class="link-color">修改會員密碼</a></span>
                    </div>
                  </div>
                  
                  <div class="form-group">
                    <label class="col-sm-3 col-md-2 control-label"> 帳戶姓名：</label>
                    <div class="col-sm-9 col-md-10">
                      <span class="label-text">${MemberLoginOK.m_Name}</span>
                      
                    </div>
                  </div>
                  
                  <div class="form-group">
                    <label class="col-sm-3 col-md-2 control-label"> 生日：</label>
                    <div class="col-sm-9 col-md-10">
                    
                      <span class="label-text">${MemberLoginOK.m_Birthday}</span>
                    
                    </div>
                  </div>
         
                  <div class="form-group">
                    <label class="col-sm-3 col-md-2 control-label">手機：</label>
                    <div class="col-sm-9 col-md-10">
                      <span class="label-text"> ${MemberLoginOK.m_Cellphone}</span>
                    </div>
                  </div>
      
                <div class="row">
                  <div class="col-sm-9 col-md-10 col-sm-offset-3 col-md-offset-2">
                    <div class=" btn-warp check-btn">
                      <a href="logout.jsp" type="button" class="btn btn-default "><i class="fa fa-sign-out"></i> 登出</a>
                      <a href="/account/account_edit" class="btn btn-primary "><i class="fa fa-pencil"></i> 編輯帳戶資料</a>
                    </div>
                  </div>
                </div>
              </form>
            </div>
          </div>
	 <hr>
	
	</section>
	<section class="container-fuild" id="orderResult">
	
	</section>
	
	</div>
	

        
	
    <script src="js/jquery.js"></script>
	
    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
	<script src="js/memberManage.js"></script>

	
</body>
</html>