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
	<font size="4" color="#cccc" face="Tahoma"> 
	<CENTER>
		<Form Action="DeleteProduct" method="POST">
			<div>
				請輸入要刪除的產品序號: <input type="text" name="productId" value="001" size="20">
				<input type="submit" value="開始刪除">
			</div>
		</Form>
	</CENTER>
	</font>
</body>
</html>