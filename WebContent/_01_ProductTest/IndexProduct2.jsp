<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/product_main2.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/tab_main2.css">
<script src="${pageContext.request.contextPath}/jQuery/jquery-2.2.4.min.js" type="text/JavaScript"></script>
<script src="${pageContext.request.contextPath}/js/product_new2.js" type="text/JavaScript"></script>
<title>work</title>
</head>
<body onload="getQueryData('SelectProduct.do');">
	<div>
	<table id="navBar">
		<tr class="abgne_tab">
			<td>
				<ul class="tabs">
					<li><a href="#product1">資料表 </a></li>
					<li><a href="#product2">資料表 </a></li>
				</ul>
			</td>

			<td id="toolBar">
				<button class="select"
					onclick="getAction('SelectProduct.jsp','showDAOJsp');"></button>
				<button class="insert"
					onclick="getAction('InsertProduct.jsp','showDAOJsp');"></button>
				<button class="delete"
					onclick="setDeleteData();"></button>
				<button class="update"
					onclick="getAction('UpdateProduct.jsp','showDAOJsp');"></button>
				<button class="export" onclick=""></button>
				<button class="import"
					onclick="getAction('ImportProduct.jsp','showDAOJsp');"></button>
				<button class="printer" onclick=""></button>
			<td>
		</tr>
	</table>
	<div class="tab_container">
		<div id="product1" class="tab_content">
			<section class="container-fuild" id='showDAOJsp'>
				<h4>請選擇功能</h4>
			</section>
			<section class="container-fuild" id='showResult'></section>
		</div>
		<div id="product2" class="tab_content">
		123
		</div>
	</div>
</div>

</body>
</html>