<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../WebShop/css/bootstrap.min.css">
<link href="../WebShop/css/oderDetail.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/WebShop/css/star-rating-svg.css" rel="stylesheet">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:if test="${empty MemberLoginOK}">
	<c:redirect url="/WebShop/login_and_register.jsp" />
</c:if>
<title>個人訂單明細</title>

</head>
<body>
	<jsp:include page='header.jsp' />

	<div class="col-md-12 center" id="content">
		<section class="order-detail">
			<div class="tab-content">
				<h5 class="side-heading">
					<c:forEach begin='1' end='1' var="OrderDetail" items="${OrderDetail_coll}">						
						<span class="text">
						<a href="../WebShop/memberManage.jsp">
							訂單編號：${OrderDetail.orderId}
						</a>
						</span>
					</c:forEach>						
				</h5>
				<h3>
					<span class="center">訂單明細</span>
				</h3>

				<div id="order">
					<div>

						<table class="table table-order" id="order-record">

							<tr>
								<td class="col-sm-3 col-md-2 control-label">商品圖片</td>
								<td class="col-sm-3 col-md-2 control-label">商品名稱</td>
								<td class="col-sm-3 col-md-2 control-label">商品價格</td>
								<td class="col-sm-3 col-md-2 control-label">購買數量</td>
								<td class="col-sm-3 col-md-2 control-label">金額小計</td>
								<td class="col-sm-3 col-md-2 control-label">評價狀態</td>
								
							</tr>

							<c:forEach var="OrderDetail" items="${OrderDetail_coll}">
								<tr>
									<td class="col-sm-3 col-md-2 control-label"><img
										src="../_01_Product/getImage?id=${OrderDetail.productBean.productId}">
									</td>
									<td class="col-sm-3 col-md-2 control-label">${OrderDetail.productBean.name}</td>
									<td class="col-sm-3 col-md-2 control-label">${OrderDetail.productBean.pgPrice}元</td>
									<td class="col-sm-3 col-md-2 control-label">${OrderDetail.quantity}份</td>
									<td class="col-sm-3 col-md-2 control-label">${OrderDetail.subTotal}元</td>
									<c:choose>
										<c:when test="${OrderDetail.score ==-1}">
      										<td class="col-sm-3 col-md-2 control-label">
      										<b>幫我打分數</b><br>
      										<span id="${OrderDetail.productBean.productId}" class="star-rating-product"></span>
      										</td>
      										
    									</c:when>
    									<c:otherwise>
      										<td class="col-sm-3 col-md-2 control-label">已評分<br>
      										<span class=star-rated-product data-rating="${OrderDetail.score}"></span>
      										</td>
   										</c:otherwise>
									</c:choose>
								</tr>
							</c:forEach>

						</table>

					</div>
				</div>

			</div>
		</section>
		
	</div>
	
	<script src="${pageContext.request.contextPath}/WebShop/js/jquery-3.1.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/WebShop/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/WebShop/js/jquery.star-rating-svg.js"></script>
	<script src="${pageContext.request.contextPath}/WebShop/js/ShowOrderDetail.js">	</script>
	
</body>
	
</html>



