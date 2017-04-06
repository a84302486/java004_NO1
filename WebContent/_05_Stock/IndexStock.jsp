<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<div>
	<table id="navBar">
		<tr class="abgne_tab">
			<td>
				<ul class="tabs">
					<li><a href="#stock1">庫存資料管理 </a></li>
					<li><a href="#stock2">資料表 </a></li>
				</ul>
			</td>

			<td id="toolBar">
				<button class="select"
					onclick="getAction('../_05_Stock/SelectStock.jsp','showDAOJsp');"></button>
				<button class="insert"
					onclick="getAction('../_05_Stock/InsertStock.jsp','showDAOJsp');"></button>
				<button class="delete" id=deleteStock ></button>
			<td>
		</tr>
	</table>
	<div class="tab_container">
		<div id="stock1" class="tab_content">
			<section class="container-fuild" id='showDAOJsp'>
				<h4>請選擇功能</h4>
			</section>
			<section class="container-fuild" id='showResult'>
			</section>
		</div>
		<div id="stock2" class="tab_content">
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
