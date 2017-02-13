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
<link rel="stylesheet" href="../asset/css/test.css">
<script src ="../js/member.js"></script>
<script src="../js/bootstrap.min.js"></script>
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
		
				<jsp:include page="..\_00_Util\SelectMenu.jsp"/>
			
		</div>
	</section>

	<section class="container-fuild" id="services">Tab</section>

	<section class="container-fuild" id="portfolio">

		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="nav navbar-nav">
					<button
						onclick="ajaxButtonTag('InsertMember.jsp','resp');ajaxButtonTag('Select.jsp','result');">
						<strong>F2 新增
						</strong>
					</button>
					<button
						onclick="ajaxButtonTag('DeleteMember.jsp','resp');ajaxButtonTag('Select.jsp','result');">
						<strong>F3 刪除
						</strong>
					</button>
					<button
						onclick="ajaxButtonTag('UpdateMember.jsp','resp');ajaxButtonTag('Select.jsp','result');">
						<strong>F4 修改
						</strong>
					</button>
					<button
						onclick="ajaxButtonTag('SelectMember.jsp','resp');ajaxButtonTag('Select.jsp','result');">
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

	<section class="container-fuild" id="result">contact</section>

	<div id='control_Flow'>
		<small> </small>
	</div>


	<footer class="container-fuild">footer</footer>

	
	
	
	
</body>
</html>