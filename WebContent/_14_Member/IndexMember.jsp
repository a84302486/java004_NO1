<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../asset/css/bootstrap.min.css">
<link rel="stylesheet" href="../asset/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../css/test.css">
<title>work</title>
</head>
<body id="body">
	<header class="container-fuild">
		<h4 class="text-center">
			<strong>Java004</strong>
		</h4>
	</header>
	<section class="container-fuild" id="about">
		<div class="row">

			<select class="col-md-3" onChange="selectMenu(this)">
				<option selected>主 選 單</option>
				<option value="../_14_Member/IndexMember.jsp">會員資料</option>
				<option value="../_01_ProductTest/IndexProduct2.jsp">商品資訊</option>

			</select> <input type="text" name="TextBox1" value="TextBox1" class="col-md-6">
			<input type="text" name="time" value="time" class="col-md-3">
		</div>
	</section>

	<section class="container-fuild" id="services">Tab</section>

	<section class="container-fuild" id="portfolio">

		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="nav navbar-nav">
					<button
						onclick="ajaxButtonTag1('InsertMember.jsp');ajaxButtonTag2('Insert.jsp');">
						<strong>F2 新增
						</strong>
					</button>
					<button
						onclick="ajaxButtonTag1('DeleteMember.jsp');ajaxButtonTag2('Delete.jsp');">
						<strong>F3 刪除
						</strong>
					</button>
					<button
						onclick="ajaxButtonTag1('UpdateMember.jsp');ajaxButtonTag2('SelectMember.jsp');">
						<strong>F4 修改
						</strong>
					</button>
					<button
						onclick="ajaxButtonTag1('SelectMember.jsp');ajaxButtonTag2('SelectAll');">
						<strong>F5 查詢
						</strong>
					</button>

				</div>
				<ul class="nav navbar-nav navbar-right">

				</ul>
			</div>
		</nav>
	</section>

	<section class="container-fuild" id='resp'></section>

	<section class="container-fuild" id="connect">contact</section>

	<div id='control_Flow'>
		<small> </small>
	</div>


	<footer class="container-fuild">footer</footer>

	<script src="../js/bootstrap.min.js"></script>
	
	<script type="text/JavaScript">
	
		function selectMenu(e){
		window.open(e.options[e.selectedIndex].value);}
	
	</script>
	
	<script>
		
		var tag1 = document.getElementById("resp");
		var tag2 = document.getElementById("connect");
		
		
		function ajaxButtonTag1(sendJsp) {
				
				// 步驟一: 新建XMLHttpRequest物件
				var xhr = new XMLHttpRequest();
				// 步驟二: 經由AJAX提出HTTP請求
				if (xhr != null) {
					xhr.onreadystatechange = function() {
						// 步驟三: 處理伺服器送回的回應資料
						if (xhr.readyState == 4 && xhr.status == 200) {
							tag1.innerHTML = "<h3>" + xhr.responseText
									+ "</h3>";
						}
					}
					xhr.open('GET', sendJsp, true);
					xhr.send();
				} else {
					tag1.innerHTML = "<h1>您的瀏覽器不支援Ajax</h1>";
				} 
			}
		
		//-------------------------------------------------------
		
		function ajaxButtonTag2(sendJsp) {
			
			// 步驟一: 新建XMLHttpRequest物件
			var xhr = new XMLHttpRequest();
			// 步驟二: 經由AJAX提出HTTP請求
			if (xhr != null) {
				xhr.onreadystatechange = function() {
					// 步驟三: 處理伺服器送回的回應資料
					if (xhr.readyState == 4 && xhr.status == 200) {
						tag2.innerHTML = "<h3>" + xhr.responseText
								+ "</h3>";
					}
				}
				xhr.open('GET', sendJsp, true);
				xhr.send();
			} else {
				tag2.innerHTML = "<h1>您的瀏覽器不支援Ajax</h1>";
			} 
		}
				
	</script>
	
</body>
</html>