<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" href="../WebShop/css/bootstrap.min.css">
<link href="../WebShop/css/oderDetail.css" rel="stylesheet">

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
				<h3 class="side-heading">
					<span class="text">訂單明細</span>
				</h3>

				<div id="order">
					<div>

						<table class="table table-order" id="order-record">

							<tr>
								<td>商品名稱</td>
								<td>商品價格</td>
								<td>購買數量</td>
								<td>金額小計</td>
							</tr>

							<c:forEach var="OrderDetail" items="${OrderDetail_coll}">
								<tr>
									<td>${OrderDetail.productBean.name}</td>
									<td>${OrderDetail.productBean.pgPrice}</td>
									<td>${OrderDetail.quantity}</td>
									<td>${OrderDetail.subTotal}</td>
								</tr>
							</c:forEach>

						</table>

					</div>
				</div>

			</div>
		</section>
	</div>

</body>
</html>



