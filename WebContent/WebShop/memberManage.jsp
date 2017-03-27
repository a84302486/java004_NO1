<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link href="css/memberManage.css" rel="stylesheet">
	<link href="css/shopcart.css" rel="stylesheet">

<head>


    <title>Java004_NO1 購物平台</title>
</head>

<body>

  	<jsp:include page='header.jsp' />
	
	
	<section class="container-fuild" id="memberResult">
		<form id="memberSelect">
			<input type="hidden" value="${MemberLoginOK.m_Username}"/>
		</form>
	</section>
	<section class="container-fuild" id="orderResult">
		<form id="orderSelect">
			<input type="hidden" value="${MemberLoginOK.m_Username}"/>
		</form>
	</section>
	
	
    <script src="js/jquery.js"></script>
	
    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
	<script src="js/memberManage.js"></script>
	<script type="text/javascript">

</script>
	
</body>
</html>