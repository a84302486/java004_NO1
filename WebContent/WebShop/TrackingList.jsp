<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../WebShop/css/bootstrap.min.css">
<link href="../WebShop/css/TrackingList.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/WebShop/css/star-rating-svg.css" rel="stylesheet">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:if test="${empty MemberLoginOK}">
	<c:redirect url="/WebShop/login_and_register.jsp" />
</c:if>
<title>產品追蹤清單</title>

</head>
<body>
	<jsp:include page='header.jsp' />

	<div class="container">
		<br><br><br>
		<div class="row">
			<div class="col-lg-12">
				<h3 id="track-product">追蹤清單</h3>
				<hr>
				<div id="warp" class="row text-center">
				<c:forEach var="tk" items="${TrackingList_coll}">
					<div class="col-md-3 col-sm-6 hero-feature">
						<div id="${tk.productId}" class="thumbnail">
							<img src="../_01_Product/getImage?id=${tk.productId}" alt="產品圖片">
							<div class="caption">
								<span class="name">${tk.name}</span>
								: NT<span class="price">${tk.pgPrice}</span><br>
								<span class=star-rating-product data-rating="${tk.score}">${tk.score}<b>星</b></span>
								<p>
									<button id="" class="btn btn-primary">加入購物清單</button>
									<button id="" class="btn btn-danger">刪除追蹤</button>
								</p>
							</div>
						</div>
					</div>
				</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<script src="${pageContext.request.contextPath}/WebShop/js/jquery-3.1.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/WebShop/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/WebShop/js/jquery.star-rating-svg.js"></script>
	<script src="${pageContext.request.contextPath}/WebShop/js/TrackList.js"></script>
</body>

</html>



