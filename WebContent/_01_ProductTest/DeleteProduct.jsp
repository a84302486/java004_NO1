<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/test.css' type="text/css" />
<script src="../js/product.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MVC</title>
</head>
<body>

	<Form Action="Javascript:%200" onsubmit="setDeleteData('Delete');">
		<div>
			請輸入要刪除的產品序號: 
			<input type="text" name="productId" id="productId" value="" size="20"> 
			<input type="submit" value="開始刪除">
		</div>
	</Form>

	<div id="result"></div>

</body>
</html>