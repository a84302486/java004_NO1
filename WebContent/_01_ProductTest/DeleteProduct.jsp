<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/test.css' type="text/css" />
<script src="${pageContext.request.contextPath}/js/product_new.js" type="text/JavaScript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MVC</title>
</head>
<body>
<CENTER>
	<Form Action="Javascript:%200" >
		<div>
			<font size="4" color="blue" face="Tahoma"> 
			請輸入要刪除的產品序號: 
			<input type="text" id="productId" name="productId" value="" size="20" placeholder="請輸入序號"> 
			<input type="button" value="開始刪除"  onclick="getMessage('DeleteServlet');">
			</font>
		</div>
	</Form>
		<div id="deleteResult"></div>
</CENTER>

</body>
</html>