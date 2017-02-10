<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/test.css">
<title>work</title>
</head>
<body>
	<header class="container-fuild">
		<h4 class="text-center">
			<strong>Window</strong>
		</h4>
	</header>
	<section class="container-fuild" id="about">
		<div class="row">
			<select class="col-md-3">
				<option value="no1">主選單</option>
			</select> <input type="text" name="TextBox1" value="TextBox1" class="col-md-6">
			<input type="datetime-loca" name="time" value="time" class="col-md-3">
		</div>
	</section>

	<section class="container-fuild" id="services">Tab</section>

	<section class="container-fuild" id="portfolio">
		<nav class="container-fuild">
			<div class="container-fluid">
				<input type='button' name='???' id='???'value="F1&#13;&#10;說明" />
				<input type='button'
					onclick="getDaoJsp('SelectProduct2.jsp');getResultJsp('SelectAll2.jsp');"
					name='insertName' id='insertId' value="F2&#13;&#10;查詢">
				<input type='button'
					onclick="getDaoJsp('InsertProduct.jsp');getResultJsp('InsertSuccess.jsp');"
					name='deleteName' id='deleteId' value="F3&#13;&#10;新增">
				<input type='button'
					onclick="getDaoJsp('UpdateProduct.jsp');getResultJsp('UpdateSuccess.jsp');"
					name='selectName' id='selectId' value="F4&#13;&#10;修改">
				<input type='button'
					onclick="getDaoJsp('DeleteProduct.jsp');getResultJsp('DeleteSuccess.jsp');"
					name='updateName' id='updateId' value="F5&#13;&#10;刪除">
				<input type='button' id='none' value="首頁">
				<input type='button' id='none' value="上頁">
				<input type='button' id='none' value="下頁">
				<input type='button' id='none' value="尾頁">
			</div>
		</nav>
	</section>

	<section class="container-fuild" id='showDAOJsp'>
		<jsp:include page="SelectProduct2.jsp" />
	</section>

	<section class="container-fuild" id="showResultJsp">
		<jsp:include page="SelectAll2.jsp" />
	</section>

	<script>
		var dao = document.getElementById("showDAOJsp");
		function getDaoJsp(jsp) {
			// 步驟一: 新建XMLHttpRequest物件
			var xhr = new XMLHttpRequest();
			// 步驟二: 經由AJAX提出HTTP請求
			if (xhr != null) {
				xhr.onreadystatechange = function() {
					// 步驟三: 處理伺服器送回的回應資料
					if (xhr.readyState == 4 && xhr.status == 200) {
						dao.innerHTML = "<h3>" + xhr.responseText + "</h3>";
					}
				}
				xhr.open('GET', jsp, true);
				xhr.send();
			} else {
				dao.innerHTML = "<h1>您的瀏覽器不支援Ajax</h1>";
			}
		}

		var result = document.getElementById("showResultJsp");
		function getResultJsp(jsp) {
			var xhr = new XMLHttpRequest();
			if (xhr != null) {
				xhr.onreadystatechange = function() {
					if (xhr.readyState == 4 && xhr.status == 200) {
						result.innerHTML = "<h3>" + xhr.responseText + "</h3>";
					}
				}
				xhr.open('GET', jsp, true);
				xhr.send();
			} else {
				result.innerHTML = "<h1>您的瀏覽器不支援Ajax</h1>";
			}
		}
	</script>

	<footer class="container-fuild">footer</footer>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>