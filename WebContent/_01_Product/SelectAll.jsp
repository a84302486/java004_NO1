<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/styles.css'
	type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>產品查詢</title>
</head>
<body>
	<H1>產品列表查詢</h1>

	<table
		style="border: 3px; height: 10%; width: 100%; background-color: rgb(255, 255, 255); table-layout: fixed;"
		align="Center" cellpadding="5" cellspacing="5">

		</tbody>
		<TR>
			<TD>序號</TD>
			<TD>定價</TD>
			<TD>名稱</TD>
			<TD>成本</TD>
			<TD>生產地</TD>
			<TD>保存期</TD>
			<TD>供應商</TD>
		</TR>
		<tr>
		</tr>

		</tbody>
	</TABLE>
	
	<c:forEach var="pc" items="${productColl}">

		<table
			style="border: 3px; height: 10%; width: 100%; background-color: rgb(255, 255, 255); table-layout: fixed;"
			align="Center" cellpadding="5" cellspacing="5" frame="border"
			rules="all">

			</tbody>

			<TR>
				<TD>${pc.productId}</TD>
				<TD>${pc.pgPrice}</TD>
				<TD>${pc.name}</TD>
				<TD>${pc.avgCost}</TD>
				<TD>${pc.oplace}</TD>
				<TD>${pc.slife}</TD>
				<TD>${pc.suppierId}</TD>
			</TR>
			<tr>

			</tr>

			</tbody>
		</TABLE>

	</c:forEach>
</body>
</html>