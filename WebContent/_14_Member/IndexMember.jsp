<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">
<link rel="stylesheet" href="../asset/css/bootstrap.min.css">
<link rel="stylesheet" href="../asset/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../css/member.css">
<script src ="../js/member/member.js"></script>
<script src ="../js/member/insert.js"></script>
<script src ="../js/member/delete.js"></script>
<script src ="../js/member/select.js"></script>
<script src="../js/bootstrap.min.js"></script> 


<title>會員管理首頁</title>
</head>
<body onload="doFirstIndex();">

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
				<div class="nav navbar-nav" id="buttons">
					<button
						onclick="ajaxButtonTag('InsertMember.jsp','resp');getQueryDataLimit('LimitSelect','resultIndex');">
						<strong>F2 新增
						</strong>
					</button>
					<button 
						onclick="ajaxButtonTag('DeleteMember.jsp','resp');getQueryDataLimit('LimitSelect','resultIndex');">
						<strong>F3 刪除
						</strong>
					</button>
					<button
						onclick="ajaxButtonTag('UpdateMember.jsp','resp');getQueryDataLimit('LimitSelect','resultIndex');">
						<strong>F4 修改
						</strong>
					</button>
					<button

						onclick="ajaxButtonTag('SelectMember.jsp','resp');getQueryDataLimit('LimitSelect','resultIndex');"">

					
						<strong>F5 查詢
						</strong>
					</button>
<!-- 					<button -->
<!-- 						onclick="setDeleteData('Delete','Username','result');">> -->
<!-- 						<strong>提交 -->
<!-- 						</strong> -->
<!-- 					</button> -->
				</div>
				<ul class="nav navbar-nav navbar-right">

				</ul>
			</div>
		</nav>
	</section>

	<section class="container-fuild" id="resp"><center><h2>歡迎使用本系統</h2></center></section>

	<section class="container-fuild" id="resultIndex"></section>  

	<div id='control_Flow'>
		<small> </small>
	</div>


	<footer class="container-fuild" style="position:fixed;">我是footer</footer>

</body>
</html>