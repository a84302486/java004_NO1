<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="SystemMain">
	<table class="SystemTitle">
		<tr>
			<td> </td>
			<td>資料管理系統</td>
			<td><a href="../_00_Login/logout.jsp">登出</a></td>
		</tr>
	</table>
	<table class="menuBar">
		<tr>
			<td>
				<ul class="drop-down-menu">
					<li><a href="#" data-toggle="dropdown">基本資料管理 <b
							class="caret"></b></a>
						<ul>
							<li><a href="#tab-product" 
							onclick="getAction('../_01_Product/IndexProduct.jsp','loadPageDiv');getQueryData('ALL','productId','');">
							產品上下架及資料管理</a>
							</li>							
							<li><a href="#tab-member" 
							onclick="getAction('../_14_Member/IndexMember.jsp','loadPageDiv');">
							會員系統</a>
							</li>
						</ul>
					<li>
				</ul>
			</td>
			<td>
				<ul class="drop-down-menu">
					<li><a href="#" data-toggle="dropdown">庫存管理系統 <b
							class="caret"></b></a>
						<ul>
							<li><a href="#tab-stock" 
							onclick="getAction('../_05_Stock/IndexStock.jsp','loadPageDiv');getStockData('productId' ,'');">
							庫存資料管理</a>
						</ul>
					<li>
				</ul>
			</td>
			<td>
				<ul class="drop-down-menu">
					<li><a href="#" data-toggle="dropdown">購物車訂單管理系統 <b
							class="caret"></b></a>
						<ul>
							<li><a href="" class="">功能1</a>
			
						</ul>
					<li>
				</ul>
			</td>
		</tr>
	</table>
</div>
