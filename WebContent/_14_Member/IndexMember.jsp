<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta name="viewport" content="width=device-width, initial-scale=1"
	charset="UTF-8">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<link rel="stylesheet" href="../asset/css/bootstrap.min.css">
<link rel="stylesheet" href="../asset/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../css/member/member2.css?v010301">
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../asset/js/bootstrap.min.js"></script>
<script src="../js/member/member.js?v00101"></script>
<script src="../js/member/insert.js?v0001"></script>
<script src="../js/member/delete.js?v0010001"></script>
<script src="../js/member/select.js?v00110"></script>
<!-- <script src="../js/member/jquery.js?v12"></script> -->
<script src="../js/member/update.js?v010110"></script>


<title>會員管理首頁</title>
</head>
<body>
	<!-- 	<h3>highlight test</h3> -->
	<header class="container-fuild">
		<div class="row">

			<h4 class="text-center" id="indexheader">
				<strong>資料管理系統</strong>
			</h4>

		</div>
		
	</header>

	<section class="container-fuild" id="portfolio">

		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="nav navbar-nav" id="buttons">
					<section class="container-fuild" id="about">
		
		</section>
					<button
						id='buttonremark'>
						<br>說明
						
					</button>
					<button onclick="location.href='http://localhost:8080/java004/_14_Member/IndexMember.jsp'">
						
						<br>首頁
						
					</button>
					
					<button
						onclick="ajaxButtonTag('InsertMember.jsp','insertIndex');" id='buttoninsert'>
						<img src="../image/insert.png"><br>新增
						
					</button>
					<button onclick = "updateData();" id='buttonupdate'>
						<img src='../image/update.png'><br>修改
						
					</button>
					<button onclick = "setDeleteData('Delete','Username','resultIndex','resultLimit');" id='buttondelete'>
						<img src='../image/delete.png'><br>刪除
						
					</button>

				</div>
				<Form Action="Javascript:%200" id="formSelect">
				
					輸入帳號查詢: <input type="text" name="Username" id="M_Username"
						value="" size="20" placeholder="不輸入搜尋全部" />
<!-- 					             <input type="submit" value="開始查詢" onclick="getQueryData('Select','resultIndex');"/> -->
					
					<div id="pageControl">
				<button id="pageBack" onclick="pageBack();">
					<img src="../image/back.png" style="width: 2em; height: 1.5em;">
					<br> 上頁
				</button>


				<input type="text" name="pageNo" id="pageNo" value="1"
					readonly="readonly" style="width: 3em;" /> / 
				
				<input type="text"
					name="totalPages" id="totalPages" value="0" readonly="readonly"
					style="width: 3em;" />

				<button id="pageNext" onclick="pageNext();">
					<img src="../image/next.png" style="width: 2em; height: 1.5em;">
					<br> 下頁
				</button>
			</div>
					<button id="buttonsearch" onclick="getQueryData('M_Username','Select','resultIndex','result','M_Username');">
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

	</section>
	<section class="container-fuild" id="insertIndex">

	</section>
	
	
	
	


	<footer class="container-fuild" >我是footer</footer>

</body>
</html>