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
<body>
	<header class="container-fuild" id='window'>
		<h4 class="text-center">
			<strong>Window</strong>
		</h4>
	</header>
	<section class="container-fuild" id="about">
		<div class="row">
			<select class="col-md-3">
				<option value="no1">主選單</option>
				<option value="no1" href ="SelectProduct2.jsp"></option>
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
					onclick="getJsp('SelectProduct2.jsp','showDAOJsp');getQueryData('SelectFindAll2');"
					name='insertName' id='selectId' value="F2&#13;&#10;查詢">
				<input type='submit'
					onclick="getJsp('InsertProduct.jsp','showDAOJsp');getJsp('InsertSuccess.jsp','showResultJsp');"
					name='deleteName' id='insertId' value="F3&#13;&#10;新增">
				<input type='submit'
					onclick="getJsp('UpdateProduct.jsp','showDAOJsp');getJsp('UpdateSuccess.jsp','showResultJsp');"
					name='selectName' id='updateId' value="F4&#13;&#10;修改">
				<input type='submit'
					onclick="getJsp('DeleteProduct.jsp','showDAOJsp');getJsp('DeleteSuccess.jsp','showResultJsp');"
					name='updateName' id='deleteId' value="F5&#13;&#10;刪除">
				<input type='button' id='none' value="首頁">
				<input type='button' id='none' value="上頁">
				<input type='button' id='none' value="下頁">
				<input type='button' id='none' value="尾頁">
			</div>
		</nav>
	</section>

	<section class="container-fuild" id='showDAOJsp'>
		<jsp:include page='SelectProduct2.jsp'/>
	</section>
	<section class="container-fuild" id='showResult' >
	
		<%-- <jsp:include page='SelectAll2.jsp'/>  --%>
	</section>

	<footer class="container-fuild">footer</footer>

</body>
</html>