<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">
<link rel="stylesheet" href="../asset/css/bootstrap.min.css">
<link rel="stylesheet" href="../asset/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../css/test.css">
<script src ="../js/member/member.js"></script>
<script src="../js/bootstrap.min.js"></script> 


<title>會員管理首頁</title>
</head>
<body onload="getQueryDataLimit('LimitSelect','resultIndex');">
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
						onclick="ajaxButtonTag('InsertMember.jsp','resp');">
						<strong>F2 新增
						</strong>
					</button>
					<button
						onclick="ajaxButtonTag('DeleteMember.jsp','resp');">
						<strong>F3 刪除
						</strong>
					</button>
					<button
						onclick="ajaxButtonTag('UpdateMember.jsp','resp');">
						<strong>F4 修改
						</strong>
					</button>
					<button

						onclick="ajaxButtonTag('SelectMember.jsp','resp');">

					
						<strong>F5 查詢
						</strong>
					</button>

				</div>
				<ul class="nav navbar-nav navbar-right">

				</ul>
			</div>
		</nav>
	</section>

	<section class="container-fuild" id='resp' style="height: 50%; width:100%;overflow:scroll;"></section>

	<section class="container-fuild" id="resultIndex" style="height: 70%; width:100%;overflow:scroll;">contact</section> -->

	<div id='control_Flow'>
		<small> </small>
	</div>


	<footer class="container-fuild">footer</footer>

</body>
</html>