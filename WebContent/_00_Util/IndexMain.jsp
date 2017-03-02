<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/indexMain.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/tab_main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/toolBar.css">
<script src="${pageContext.request.contextPath}/jQuery/jquery-1.12.4.min.js" type="text/JavaScript"></script>
<script src="${pageContext.request.contextPath}/js/product_new.js" type="text/JavaScript"></script>
<script src="${pageContext.request.contextPath}/js/tab_new.js" type="text/JavaScript"></script>

<title>work</title>
</head>
<body onload="getQueryData('SelectServlet');">
	
	<!-- 插入工具列 -->
	<div>
		<jsp:include page='../_00_Util/ToolBar.jsp' />
	</div>
	<!-- /插入工具列 -->
	
	<!-- 頁籤與相對應之頁面-->
	<div class="abgne_tab">
		<ul class="tabs">
			<li><a href="#tab1">資料表 <i><img id="cross"></i></a></li>
		</ul>
		<div class="tab_container">
			<div id="tab1" class="tab_content">
				<section class="container-fuild" id='showDAOJsp'>
					<h3>請選擇功能</h3>
				</section>
				<section class="container-fuild" id='showResult'>
				</section>
			</div>
		</div>
	</div>
	<!-- /頁籤與相對應之頁面-->
</body>
</html>