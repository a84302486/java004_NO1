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
	<center>
		產品序號： <input type="text" name="productId" value="" size="20">
		數量：         <input type="text" name="quantity" value="" size="20"> 
		       <input id="insertStockBtn" type="submit" value="提交">

		<div>
			<div id="insertResult"></div>
		</div>
	</center>
</body>
</html>
