<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- <html> -->
<!-- <head> -->
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/product_main.css' type="text/css" />
<script src="${pageContext.request.contextPath}/js/product_new.js" type="text/JavaScript"></script>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<!-- <title>MVC</title> -->
<!-- </head> -->
<!-- <body> -->

<Form Action="Javascript:%200">	
	<center>
		<div id="insertTable">
			<table>
				<tr>
					<td>產品序號：</td> 
					<td><input type="text" name="productId" value="001"></td>
				</tr>
				<tr> 
					<td >產品定價： </td> 
					<td><input type="text" name="PGPrice" value="500" ></td>
				</tr>
				<tr>
					<td >產品品名：</td> 
					<td><input type="text" name="name" value="羊咩咩羊肉爐" ></td>
				<tr> 
					<td>產品成本： </td> 
					<td><input type="text" name="avgCost" value="300"></td>
				</tr>
				<tr>
					<td>產品生產地：</td>
					<td><input type="text" name="oPlace" value="台灣台北"></td>
				</tr>
				<tr>
					<td>產品保存期： </td>
					<td><input type="text" name="sLife" value="360" ></td>
				</tr>
				<tr>
					<td>產品供應商：</td> 
					<td><input type="text" name="suppierId" value="A"></td>	
				</tr>
			</table>	
		</div>
		<div>
			<input type="submit" value="提交" onclick="getInsertData('InsertProduct.do');"/>
			<div id="insertResult"></div>
		</div>
	</center>
</Form>			
	

<!-- </body> -->

<!-- </html> -->
