<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="SystemMain">
<!-- 	<table class="SystemTitle"> -->
<!-- 		<tr> -->
<!-- 			<td> </td> -->
<!-- 			<td>好食在資料管理系統</td> -->
<!-- 			<td><a href="../_00_Login/logout.jsp">登出</a></td> -->
<!-- 		</tr> -->
<!-- 	</table> -->
	<div class="menuBar" style="color:white;font:2em bold;">		
		<div class="row">
			
			<div class="col-md-offset-1 col-md-3">
				<ul class="drop-down-menu">
					<li><a href="#" data-toggle="dropdown">產品管理系統 <b
							class="caret"></b></a>
						<ul>
							<li><a href="#tab-product" 
							onclick="getAction('../_01_Product/IndexProduct.jsp','loadPageDiv');getQueryData('ALL','productId','');">
							產品資料管理</a>
							</li>							
							
							<li><a href="#tab-stock" 
							onclick="getAction('../_05_Stock/IndexStock.jsp','loadPageDiv');getStockData('productId' ,'');">
							庫存資料管理</a>
						
						</ul>
					<li>
				</ul>
			</div>
			<div class="col-md-offset-1 col-md-3">
						<div>好食在資料管理系統</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-offset-11 col-md-1">
				<a href="../_00_Login/logout.jsp" style="color:white;">登出</a>
			</div>
		</div>
	</div>
</div>
