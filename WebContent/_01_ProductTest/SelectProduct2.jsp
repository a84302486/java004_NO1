<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/test.css">
<script src="${pageContext.request.contextPath}/js/product.js" type="text/JavaScript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<title>MVC</title>
<body>

	<CENTER>
		<div>用序號查詢:
			<input type="text" id="productId" name="productId" value="002" size="20" placeholder="不輸入將搜尋全部"> 
			<input type="button" value="開始查詢" onclick="getQueryData('SelectFindAll2');">
		</div>		
	</CENTER>

</body>
</html>