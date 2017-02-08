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
				<ul class="nav navbar-nav">
					<strong><input type='submit' name='insertName' id='insertId' value="F2&#13;&#10;新增"></strong>
					<strong><input type='submit' name='deleteName' id='deleteId' value="F2&#13;&#10;刪除"></strong>
					<strong><input type='submit' name='selectName' id='selectId' value="F2&#13;&#10;查詢"></strong>
					<strong><input type='submit' name='updateName' id='updateId' value="F2&#13;&#10;修改"></strong>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<strong><input type='submit' id='none' value="首頁"></strong>
					<strong><input type='submit' id='none' value="上頁"></strong>
					<strong><input type='submit' id='none' value="下頁"></strong>
					<strong><input type='submit' id='none' value="尾頁"></strong>
				</ul>
			</div>
		</nav>
	</section>
	
	<section class="container-fuild" id='resp'></section>
	<p>
		<script>
			var btnJSP1 = document.getElementById("insertId");
			var div1 = document.getElementById("resp");
			btnJSP1.onclick = function() {
				// ajax的同步請求
				// 步驟一: 新建XMLHttpRequest物件
				var xhr = new XMLHttpRequest();
				// 步驟二: 經由AJAX提出HTTP請求
				if (xhr != null) {
					xhr.onreadystatechange = function() {
						// 步驟三: 處理伺服器送回的回應資料
						if (xhr.readyState == 4 && xhr.status == 200) {
							div1.innerHTML = "<h1>" + xhr.responseText
									+ "</h1>";
						}
					}
					xhr.open('GET', 'InsertProduct.jsp', true);
					xhr.send();
				} else {
					div1.innerHTML = "<h1>您的瀏覽器不支援Ajax</h1>";
				}
			}

			var btnJSP2 = document.getElementById("deleteId");
			var div1 = document.getElementById("resp");
			btnJSP2.onclick = function() {
				// ajax的同步請求
				// 步驟一: 新建XMLHttpRequest物件
				var xhr = new XMLHttpRequest();
				// 步驟二: 經由AJAX提出HTTP請求
				if (xhr != null) {
					xhr.onreadystatechange = function() {
						// 步驟三: 處理伺服器送回的回應資料
						if (xhr.readyState == 4 && xhr.status == 200) {
							div1.innerHTML = "<h1>" + xhr.responseText
									+ "</h1>";
						}
					}
					xhr.open('GET', 'DeleteProduct.jsp', true);
					xhr.send();
				} else {
					div1.innerHTML = "<h1>您的瀏覽器不支援Ajax</h1>";
				}
			}

			var btnJSP3 = document.getElementById("selectId");
			var div1 = document.getElementById("resp");
			btnJSP3.onclick = function() {
				// ajax的同步請求
				// 步驟一: 新建XMLHttpRequest物件
				var xhr = new XMLHttpRequest();
				// 步驟二: 經由AJAX提出HTTP請求
				if (xhr != null) {
					xhr.onreadystatechange = function() {
						// 步驟三: 處理伺服器送回的回應資料
						if (xhr.readyState == 4 && xhr.status == 200) {
							div1.innerHTML = "<h1>" + xhr.responseText
									+ "</h1>";
						}
					}
					xhr.open('GET', 'SelectProduct.jsp', true);
					xhr.send();
				} else {
					div1.innerHTML = "<h1>您的瀏覽器不支援Ajax</h1>";
				}
			}

			var btnJSP4 = document.getElementById("updateId");
			var div1 = document.getElementById("resp");
			btnJSP4.onclick = function() {
				// ajax的同步請求
				// 步驟一: 新建XMLHttpRequest物件
				var xhr = new XMLHttpRequest();
				// 步驟二: 經由AJAX提出HTTP請求
				if (xhr != null) {
					xhr.onreadystatechange = function() {
						// 步驟三: 處理伺服器送回的回應資料
						if (xhr.readyState == 4 && xhr.status == 200) {
							div1.innerHTML = "<h1>" + xhr.responseText
									+ "</h1>";
						}
					}
					xhr.open('GET', 'UpdateProduct.jsp', true);
					xhr.send();
				} else {
					div1.innerHTML = "<h1>您的瀏覽器不支援Ajax</h1>";
				}
			}
		</script>
		
	<section class="container-fuild" id="connect">contact
		<jsp:include page="/_14_Member/SelectAll.jsp" />	
	</section>

	<footer class="container-fuild">footer</footer>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>