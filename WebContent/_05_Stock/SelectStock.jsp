<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/css/tab_main.css"> --%>
<%-- <script src="${pageContext.request.contextPath}/js/product_new.js" type="text/JavaScript"></script> --%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<title>MVC</title>
<body>
	<CENTER>
		<div>
			產品序號查詢:<input type="text"  name="productId" value="" size="20" placeholder="不輸入將搜尋全部"> 
			<input id="productId" type="button" value="開始查詢">
			製造日期查詢:<input type="text"  name="mfg" value="" size="20" placeholder="YYYYMMDD"> 
			<input id="stockMFG" type="button" value="開始查詢">
			到期日期查詢:<input type="text" name="exp" value="" size="20" placeholder="YYYYMMDD"> 
			<input  id="stockEXP" type="button" value="開始查詢">
		</div>	
		<div id="selectResult"></div>
	</CENTER>
</body>
</html>