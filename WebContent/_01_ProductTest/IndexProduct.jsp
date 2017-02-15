<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/test.css">
<script src="${pageContext.request.contextPath}/js/product.js" type="text/JavaScript"></script>
<title>work</title>
</head>
<body >
	<header class="container-fuild" id='window'>
		<h4 class="text-center">
			<strong>Window</strong>
		</h4>
	</header>
	<section class="container-fuild" id="about">
		<div class="row">
		
			<select class="col-md-3" onChange="selectMenu(this)">
				<option value="no1">主選單</option>
				<option value="../_14_Member/IndexMember.jsp">會員資料</option>
				<option value="../_01_ProductTest/IndexProduct2.jsp">商品資訊</option>
				
			</select> <input type="text" name="TextBox1" value="TextBox1" class="col-md-6">
			<input type="datetime-loca" name="time" value="time" class="col-md-3">
		</div>
	</section>

	<section class="container-fuild" id="services">Tab</section>

	<section class="container-fuild" id="portfolio">
		<nav class="container-fuild">
			<div class="container-fluid">
				<input type='submit' name='???' id='???'value="F1&#13;&#10;說明" />
				<input type='submit'
					onclick="getAction('SelectProduct.jsp','showDAOJsp');"
					name='insertName' id='selectId' value="F2&#13;&#10;查詢">
				<input type='submit'
					onclick="getAction('InsertProduct.jsp','showDAOJsp');"
					name='deleteName' id='insertId' value="F3&#13;&#10;新增">
				<input type='submit'
					onclick="getAction('UpdateProduct.jsp','showDAOJsp');"
					name='selectName' id='updateId' value="F4&#13;&#10;修改">
				<input type='submit'
					onclick="getAction('DeleteProduct.jsp','showDAOJsp');"
					name='updateName' id='deleteId' value="F5&#13;&#10;刪除">
				<input type='button' id='none' value="首頁">
				<input type='button' id='none' value="上頁">
				<input type='button' id='none' value="下頁">
				<input type='button' id='none' value="尾頁">
			</div>
		</nav>
	</section>

	<section class="container-fuild" id='showDAOJsp'>
<%-- 		<jsp:include page='SelectProduct.jsp'/> --%>
	</section>
	
	<section class="container-fuild" id='showResult'>
<%--        <jsp:include page='SelectProduct.jsp'/>  --%>
	</section>

	<footer class="container-fuild">footer</footer>

</body>
</html>