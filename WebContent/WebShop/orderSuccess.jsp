<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" href="../WebShop/css/bootstrap.min.css">
<link rel="stylesheet" href="../WebShop/css/cartEdit.css">

<title>registered</title>
</head>
<body>
	<jsp:include page='header.jsp' />

	<div class="container">
		<br>
		<br>
		<br>
		<br>
		<h1>${MemberLoginOK.m_Name} 感謝您的購買</h1>
		<br>
		<h2>歡迎再度光臨!</h2>
		<br>
		<h2><a href="${pageContext.request.contextPath}/WebShop/memberManage.jsp">您此次的購物完成!請在會員管理查看訂單</a></h2>
	</div>

	<script src="jQuery/jquery-2.2.4.min.js" type="text/JavaScript"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="../WebShop/js/cartEdit.js"></script>

</body>
</html>