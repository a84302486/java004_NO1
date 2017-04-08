<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<div>
	<table id="navBar">
		<tr class="abgne_tab">
			<td>
				<ul class="tabs">
					<li><a href="#product1">產品上下架及資料管理</a></li>
					<li><a href="#product2">資料表 </a></li>
				</ul>
			</td>

			<td id="toolBar">
				<button class="select"
					onclick="getAction('SelectProduct.jsp','showDAOJsp');"></button>
				<button class="insert"
					onclick="getAction('InsertProduct.jsp','showDAOJsp');"></button>
				<button class="delete" id=deleteProduct></button>
				<button class="update"
					onclick="getAction('UpdateProduct.jsp','showDAOJsp');"></button>
<!-- 				<button class="export" onclick=""></button> -->
<!-- 				<button class="import" -->
<!-- 					onclick="getAction('ImportProduct.jsp','showDAOJsp');"></button> -->
<!-- 				<button class="printer" onclick=""></button> -->
			<td>
		</tr>
	</table>
	<div class="tab_container">
		<div id="product1" class="tab_content">
			<section class="container-fuild" id='showDAOJsp'>
				<h4>請選擇功能</h4>
			</section>
			<section class="container-fuild" id='showResult'>
			</section>
		</div>
		<div id="product2" class="tab_content">
		測試文字<br>
		測試文字<br>	
		測試文字<br>	
		測試文字<br>	
		測試文字<br>	
		測試文字<br>	
		測試文字		
		</div>
	</div>
</div>
