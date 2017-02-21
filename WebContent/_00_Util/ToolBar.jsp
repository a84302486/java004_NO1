<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/toolBar.css">
<script src="${pageContext.request.contextPath}/jQuery/jquery-1.12.4.min.js" type="text/JavaScript"></script>
	
	<div class='SystemTitle'>
		<strong>資料管理系統</strong>
	</div>
	
	<div class="toolBar">
		<span class="span-btn-left"> 
		<input type='button' name='???' id='???' value="F1&#13;&#10;說明" /> 
			<input type='button' onclick="getAction('SelectProduct.jsp','showDAOJsp');"
			name='insertName' id='selectId' value="F2&#13;&#10;查詢"/> 
			<input type='button' onclick="getAction('InsertProduct.jsp','showDAOJsp');"
			name='deleteName' id='insertId' value="F3&#13;&#10;新增"/> 
			<input type='button' onclick="getAction('UpdateProduct.jsp','showDAOJsp');"
			name='selectName' id='updateId' value="F4&#13;&#10;修改"/> 
			<input type='button' onclick="getAction('DeleteProduct.jsp','showDAOJsp');"
			name='updateName' id='deleteId' value="F5&#13;&#10;刪除"/>
				
			<ul class="drop-down-menu">
				<li><a href="#" data-toggle="dropdown">選單 <b class="caret"></b></a>
					<ul>
						<li><a href="#" class="SelectProduct.jsp">產品資訊</a>
							<ul>
								<li><a href="#">子功能1</a></li>
							</ul>
						</li>
						<li><a href="#" class="#">會員系統</a>
							<ul>
								<li><a href="#">子功能1</a></li>
							</ul>
						</li>
					</ul>
				<li>
			</ul>

		</span> 
		<span class="span-btn-right"> 
			<input type='button' id='none' value="首頁"> 
			<input type='button' id='none' value="上頁"> 
			<input type='button' id='none' value="下頁"> 
			<input type='button' id='none' value="尾頁">
		</span>
	</div>

