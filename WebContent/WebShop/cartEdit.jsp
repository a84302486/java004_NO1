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
<link rel="stylesheet" href="../WebShop/css/cartEdit.css">

<title>registered</title>
</head>
<body>
	<jsp:include page='header.jsp' />

	<div class="container">
		<h2 id="header">購物車</h2>
		<br>
	
		<table class="table">
			<thead>
				<tr>
					<th>商品描述</th>
					<th>單價</th>
					<th>數量</th>
					<th>小計</th>
					<th>刪除</th>
				</tr>
			</thead>	
			<tbody>	
			<c:forEach varStatus="vs" var="pb" items="${ShoppingCart.content}">
				<tr id="${pb.value.productId}">
					<td>
						<div class=media>
							 
								<img class="media-object pull-left"
								src="${pageContext.request.contextPath}/_01_Product/getImage?id=${pb.value.productId}">
							
							<div class=media-body>

								<h4 class=media-heading>
									<a href=# class=name>${pb.value.name}</a>
								</h4>

								<h5 class=media-heading>
									by <a href=#>包裝</a>
								</h5>
								<span>Status: </span>
								<span class=text-success>In Stock</span>
							</div>
						</div>
					</td>
					<td class=price>${pb.value.pgPrice}</td>
					<td class=countTd><button class=minus
							onclick=changeAmount($(this));>－</button> <input class=count
						type=text size=1 value="${pb.value.qty}" readonly>
						<button class=plus onclick=changeAmount($(this));>＋</button></td>
					<td class=total></td>
					<td class=remove>
						<button type=button class='btn btn-danger' onclick=setDel($(this));>
							<span class='glyphicon glyphicon-remove'></span> Remove
						</button>
					</td>
				</tr>
			</c:forEach>	
			</tbody>
			<tbody>
				<tr class="footer">
					<td colspan="5">商品數量 :</td>
					<td class="amount"></td>
					<td>件</td>
				</tr>
				<tr class="footer">
					<td colspan="5">商品金額 :</td>
					<td class="subtotal"></td>
					<td>元</td>
				</tr>
				<tr class="footer">
					<td colspan="5">運費小計 :</td>
					<td class="shipment">0</td>
					<td>元</td>
				</tr>
				<tr class="footer">
					<td colspan="5">購物總計 :</td>
					<td class="subtotal"></td>
					<td>元</td>
				</tr>
				<tr class="footer">
					<td colspan="4"></td>

					<td colspan="3">
					<a href="shop_index.jsp">
							<button type="button" class="btn btn-default">
								繼續購物 <span class="glyphicon glyphicon-shopping-cart"></span>
							</button>
					</a>
					<c:choose>
					<c:when test="${empty ShoppingCart.content}">
						<button type="button" class="btn btn-success" data-toggle="tooltip" data-placement="bottom" title="請先選購商品"
							id="shop_insert_order" disabled>
							確定結帳 <span class="glyphicon glyphicon-play"></span>
						</button>
					</c:when>
            		<c:otherwise>
            			
                		 <button type="button" class="btn btn-success" id="shop_insert_order">
							
							確定結帳 <span class="glyphicon glyphicon-play"></span>
							
						</button>
						
            		</c:otherwise>
        			</c:choose>
        			</td>
				</tr>
			</tbody>
		</table>
	</div>

	<script src="jQuery/jquery-2.2.4.min.js" type="text/JavaScript"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="../WebShop/js/cartEdit.js"></script>

</body>
</html>