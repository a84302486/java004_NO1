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
<link rel="stylesheet" href="css/bootstrap.min.css">
<link href="css/shop_index.css" rel="stylesheet">
<link href="css/star-rating-svg.css" rel="stylesheet">
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
                <a class="navbar-brand" href="../WebShop/shop_index.jsp">購物平台</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse " id="bs-example-navbar-collapse-1">
                <div class="navbar-form navbar-left">
					<div class="form-group">
						<input type="text" class="form-control" value=""
							placeholder="請輸入關鍵字">
					</div>
					<button id="search" type="submit" class="btn btn-default btn-success"><i class="glyphicon glyphicon-search"></i></button>
				</div>
				<ul class="nav navbar-nav navbar-right">
                	<li><a href="../WebShop/index.html"><img src="images/iconmonstr-home-8-16.png"> 觀光工廠</a></li>
                	<li><a href="../WebShop/cartEdit.jsp"><img src="images/iconmonstr-shopping-cart-3-16.png"> 購物清單</a></li>
                	<li>
                	<c:choose>
						<c:when test="${empty MemberLoginOK}">
							<a href="../WebShop/login_and_register.jsp"><span class="glyphicon glyphicon-log-in"></span> 登入註冊</a>
						</c:when>
            			<c:otherwise>
            				<a href="../WebShop/memberManage.jsp"><span class="glyphicon glyphicon-user"></span> 我的帳戶</a>
						</c:otherwise>
        			</c:choose>
                    </li>
								
                 </ul>   
            </div>
        </div>
     
    </nav>


	<div id="cd-cart">
		<h2>購物車</h2>
		<!-- cd-cart-items -->
		<ul class="cd-cart-items">
		</ul>

		<!-- cd-cart-total -->
		<div class="cd-cart-total">
			<p>
				總數量:<span>0</span>
			</p>
			<b>總計 NT :<span>0</span></b>
		</div>

		<a href="cartEdit.jsp" class="checkout-btn">結算</a>

		<p>#結算後購物清單可再修改數量!</p>
	</div>

	<div class="container">

		<br> <br> <br> <br>
		<section class="slideshow section">
			<div class="container">
				<div id="carousel-example-generic" class="carousel slide"
					data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0"
							class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					</ol>
					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<div class="slideshow_image slideshow_image01"></div>
						</div>
						<div class="item">
							<div class="slideshow_image slideshow_image02"></div>
						</div>
						<div class="item">
							<div class="slideshow_image slideshow_image03"></div>
						</div>
					</div>
				</div>
			</div>
			<br>
		</section>
		<div class="row">
			<div class="col-lg-10">
				<ul id="filter" class="nav nav-pills nav-justified">
					<li id="cmd=ALL&productId=" role="presentation"><a>所有產品</a></li>
					<li id="cmd=TYPE&type=A" role="presentation"><a>肉食類</a></li>
					<li id="cmd=TYPE&type=D" role="presentation"><a>飯食類</a></li>
					<li id="cmd=TYPE&type=B" role="presentation"><a>麵食類</a></li>
					<li id="cmd=TYPE&type=C" role="presentation"><a>沙拉類</a></li>
				</ul>

			</div>
			<div class="col-lg-2">
				<div class="btn-group">
					<button class="btn btn-primary">請選擇排序</button>
					<button class="btn btn-primary dropdown-toggle"
						data-toggle="dropdown">
						<span class="caret"></span>
					</button>
					<ul id="sort" class="dropdown-menu">
						<li data-sort-by="name"><a>品名</a></li>
						<li class="divider"></li>
						<li data-sort-by="priceDESC"><a>價格: 高到低</a></li>
						<li data-sort-by="price"><a>價格: 低到高</a></li>
						<li class="divider"></li>
						<li data-sort-by="starDESC"><a>評分: 高到低</a></li>
						<li data-sort-by="star"><a>評分: 低到高</a></li>
					</ul>
				</div>
			</div>
		</div>

		<hr>

		<div class="row">
			<div class="col-lg-12">
				<h3 id=hot-product>★熱門商品★</h3>
			</div>
		</div>

		<div id="wrap" class="row text-center"></div>
		<div class="modal fade bs-iot" tabindex="-1" role="dialog"
			aria-labelledby="mySmallModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
					<h3></h3>

					<div class="product-col">
						<div class="row">
							<div class="col-md-4">
								<div class="image toggle-image">
									<img src="" alt="product" class="img-responsive">
								</div>
							</div>
							<div class="col-md-8">
								<h4></h4>
								<h5>選用頂級台灣原產高級肉品，通過國家安全檢驗及多種安全合格標章。</h5>
							</div>
							<div class="col-md-8">
									<div class="input-group number-spinner">
									<span class="input-group-btn">
										<button class="btn btn-default btn-danger btn-number" data-dir="dwn">
											<span class="glyphicon glyphicon-minus"></span>
										</button>

									</span> 
									<input type="text" id="modal-count" class="form-control text-center" value="1">
									<span
										class="input-group-btn">
										<button class="btn btn-default btn-success btn-number" data-dir="up">

											<span class="glyphicon glyphicon-plus"></span>
										</button>
									</span>
							</div>
							<div class="extra_cart">
								<input class="addcart-Modal_id" id="" value="" type="hidden">
								<button type="button" class="btn btn-primary btn-submit"
									data-dismiss="modal" aria-hidden="true">加入購物車</button>
								<button type="button" class="btn btn-warning"
									aria-hidden="true">加入追蹤清單</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<hr>
		<footer>
			<div class="row">
				<div class="col-lg-12">
					<p>Copyright &copy; Java004_NO1 2017</p>
				</div>
			</div>
		</footer>
	</div>
	</div>

	<!-- /.container -->

	<!-- jQuery -->
	<script src="js/jquery-3.1.1.min.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.star-rating-svg.js"></script>
	<script src="js/isotope.pkgd.min.js"></script>
	<script src="js/shop_index2.js?v222"></script>



</body>
</html>