﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
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
	<link href="css/shopcart.css" rel="stylesheet">

<head>


    <title>Java004_NO1 購物平台</title>
</head>

<body>

  	 <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="shop_index.jsp">購物平台</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse " id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                        	麵類<span class="caret"></span></a>
                         <ul class="dropdown-menu" role="menu">
                            <li><a href="#">牛肉類</a></li>
                            <li class="divider"></li>
                            <li><a href="#">豬肉類</a></li>
                            <li class="divider"></li>
                            <li><a href="#">雞肉類</a></li>
                          </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                        	飯類<span class="caret"></a>
                         <ul class="dropdown-menu" role="menu">
                            <li><a href="#">牛肉類</a></li>
                            <li class="divider"></li>
                            <li><a href="#">豬肉類</a></li>
                            <li class="divider"></li>
                            <li><a href="#">雞肉類</a></li>
                          </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                        	零嘴類<span class="caret"></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#">牛肉類</a></li>
                            <li class="divider"></li>
                            <li><a href="#">豬肉類</a></li>
                            <li class="divider"></li>
                            <li><a href="#">雞肉類</a></li>
                          </ul>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="memberManage.jsp">會員管理</a></li>
					<li><a href="login_and_register.jsp">登入/註冊</a></li>
					<li><a href="cartEdit.jsp">購物車</a></li>
					<li><a href="index.html">觀光工廠</a></li>
					
                 </ul>   
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
        <!-- .side-cart -->
		<div id="cd-cart-trigger"><a class="cd-img-replace" href="#0">購物車</a></div>
		<!-- /.side-cart -->
		<!-- cart items count -->
		<span class="cartCount">0</span> 
    </nav>


	<div id="cd-cart">
		<h2>購物車</h2>
			<ul class="cd-cart-items">
<%-- 			<c:forEach varStatus="vs" var="pb" items="${ShoppingCart.content}"> --%>
<%-- 				<li><span class="cd-qty" id="${pb.value.productId}">${pb.value.qty}</span>${pb.value.name} --%>
<%-- 				<div class="cd-price">$<em>${pb.value.pgPrice}</em></div> --%>
<!-- 					<a class="cd-item-remove cd-img-replace"></a> -->
<!-- 				</li> -->
<%-- 			</c:forEach> --%>
			</ul> 
		
		<!-- cd-cart-items -->
		
		<!-- cd-cart-total -->
		<div class="cd-cart-total">
			<p>總數量:<span>0</span></p>
			<b>總計  NT :<span>0</span></b>
		</div> 

		<a href="cartEdit.jsp" class="checkout-btn">結算</a>
		
		<p>#結算後購物清單可再修改數量!</p>
	</div> 
	<!-- /.side-cart -->
	
    <!-- Page Content -->
    <div class="container">

        <!-- Jumbotron Header -->
        <header class="jumbotron hero-spacer">
            <h1>A Warm Welcome!</h1>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsa, ipsam, eligendi, in quo sunt possimus non incidunt odit vero aliquid similique quaerat nam nobis illo aspernatur vitae fugiat numquam repellat.</p>
            <p><a class="btn btn-primary btn-large">Call to action!</a>
            </p>
        </header>

        <hr>

        <!-- Title -->
        <div class="row">
            <div class="col-lg-12">
                <h3>熱門商品</h3>
            </div>
        </div>
        <!-- /.row -->

        <!-- Page Features -->
        <div id="wrap" class="row text-center">

        </div>
        <!-- /.row -->
        <hr>
        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Java004_NO1 2017</p>
                </div>
            </div>
        </footer>

    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>
	
    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
	<script src="js/shop_index2.js"></script>
	<script type="text/javascript">

</script>
	
</body>
</html>