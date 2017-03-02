<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- <html> -->
<!-- <head> -->
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/product_main2.css'
	type="text/css" />
<script src="${pageContext.request.contextPath}/js/product_new2.js"
	type="text/JavaScript"></script>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<!-- <title>MVC</title> -->
<!-- </head> -->
<!-- <body> -->

<Form Action="Javascript:%200">
	產品序號： <input type="text" name="productId" value="001"> 
	產品定價： <input type="text" name="PGPrice" value="500"> 
	產品品名： <input type="text" name="name" value="羊咩咩羊肉爐"> 
	產品成本： <input type="text" name="avgCost" value="300"> 
	產品生產地： <input type="text" name="oPlace" value="台灣台北"> 
	產品保存期： <input type="text" name="sLife" value="360"> 
            產品供應商： <input type="text" name="suppierId" value="A"> 
            <input type="submit" value="提交" onclick="getInsertData('InsertProduct.do');" />
	<div>
		<div id="insertResult"></div>
	</div>
</Form>


<!-- </body> -->

<!-- </html> -->
