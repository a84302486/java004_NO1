<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta name="viewport" content="width=device-width, initial-scale=1"
	charset="UTF-8">
<link rel="stylesheet" href="../asset/css/bootstrap.min.css">
<link rel="stylesheet" href="../asset/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../css/member/member2.css?v1">
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../asset/js/bootstrap.min.js"></script>
<script src="../js/member/member.js?v12345"></script>
<script src="../js/member/insert.js?v1"></script>
<script src="../js/member/delete.js?v1234"></script>
<script src="../js/member/select.js?v1"></script>
<!-- <script src="../js/member/jquery.js?v12"></script> -->
<script src="../js/member/update.js?v1"></script>


<title>會員管理首頁</title>
</head>
<body>
	<!-- 	<h3>highlight test</h3> -->
	<header class="container-fuild">
		<h4 class="text-center" id="indexheader">
			<strong>資料管理系統</strong>
		</h4>
	</header>

	<section class="container-fuild" id="portfolio">

		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="nav navbar-nav" id="buttons">
					<section class="container-fuild" id="about">
<!-- 		<div class="row"> -->

<%-- 			<jsp:include page="..\_00_Util\SelectMenu.jsp" /> --%>

<!-- 		</div> -->
		</section>
					<button
						id='buttonremark'>
						<br>說明
						
					</button>
					<button
						onclick="ajaxButtonTag('InsertMember.jsp','resultIndex');" id='buttoninsert'>
						<img src="../image/insert.png"><br>新增
						
					</button>
<!-- 					<button -->
<!-- 						onclick="ajaxButtonTag('UpdateMember.jsp','resp');getQueryDataLimit('LimitSelect','resultIndex','M_ID');"> -->
<!-- 						F3<br>修改 -->
<!-- 					</button> -->
<!-- 					<button -->
<!-- 						onclick="ajaxButtonTag('DeleteMember.jsp','resp');getQueryDataLimit('LimitSelect','resultIndex','M_ID');"> -->
<!-- 						F4<br>刪除 -->
<!-- 					</button> -->

				</div>
				<Form Action="Javascript:%200" id="formSelect">
				
					輸入帳號查詢: <input type="text" name="Username" id="M_Username"
						value="helloSnoopy" size="20" placeholder="不輸入搜尋全部" />
					<!--              <input type="submit" value="開始查詢" onclick="getQueryData('Select','resultIndex');"/> -->
					<button id="buttonsearch" onclick="getQueryData('M_Username','Select','resultIndex','result','M_ID');">
						<img src="../image/search.png">
					</button>
					
					<div id="result"></div>

				</Form>


				<ul class="nav navbar-nav navbar-right">

				</ul>
			</div>
		</nav>
	</section>

	<%-- 	<section class="container-fuild" id="resp"><center><h2>歡迎使用本系統</h2></center></section> --%>

	<section class="container-fuild" id="resultIndex">
		<form id="queryData">
		</form>
	</section>

	<div id='resultLimit'>
		
	</div>


	<footer class="container-fuild" style="position: fixed;">我是footer</footer>

</body>
</html>