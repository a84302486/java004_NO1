<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/styles.css'
	type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MVC</title>
</head>
<body>
<Form Action="InsertProduct" method="POST">
	<CENTER>
			<div align="LEFT">
				<font size="4" color="red" face="Tahoma"> 
				產品序號： <input type="text" name="productId" value="001" size="7"> 
				產品定價： <input type="text" name="PGPrice" value="500" size="5"> 
				產品品名： <input type="text" name="name" value="羊咩咩羊肉爐" size="25"> 
				產品成本： <input type="text" name="avgCost" value="300" size="5"> 
				產品生產地： <input type="text" name="oPlace" value="台灣台北" size="25"><br>
				產品保存期： <input type="text" name="sLife" value="360" size="5">
				產品供應商： <input type="text" name="suppierId" value="A" size="5">
				<input  type="button" value="提交" onclick="getAction('Insert','showResult');">
				</font> 
			</div>
			
	</CENTER>

</Form>
</body>

</html>
