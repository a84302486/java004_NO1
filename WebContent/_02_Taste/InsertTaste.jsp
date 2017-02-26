<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/product_main.css' type="text/css" />
<script src="${pageContext.request.contextPath}/js/product_new.js" type="text/JavaScript"></script>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MVC</title>
</head>
<body>
	<CENTER>
<Form Action="Javascript:%200">	
			<div align="LEFT">
				<font size="3" color="red" face="Tahoma"> 
				口味序號： <input type="text" name="tasteId" value="001" size="7"> 
				口味名稱： <input type="text" name="tasteName" value="大包" size="5"> 

				<input  type="submit" value="提交" onclick="getInsertMessage('InsertTaste.do');">
				</font> 
			</div>
</Form>			
	<div id="insertResult"></div>
	</CENTER>
</body>

</html>
