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
<title>倉庫查詢</title>
</head>
<body>
	<H1>折扣列表查詢</h1>

	<table
		style="border: 3px; height: 10%; width: 100%; background-color: rgb(255, 255, 255); table-layout: fixed;"
		align="Center" cellpadding="5" cellspacing="5">

		</tbody>
		<TR>
			<TD>序號</TD>
			<TD>客戶</TD>
			<TD>產品</TD>
			<TD>口味</TD>
			<TD>包裝</TD>
			<TD>庫存</TD>
			<TD>acREC</TD>
			<TD>acRET</TD>
			<TD>acSAL</TD>
			<TD>acBAD</TD>
			<TD>acBAL</TD>
			<TD>MFD</TD>
		</TR>
		<tr>
		</tr>

		</tbody>
	</TABLE>
	
	<c:forEach var="wc" items="${wColl}">

		<table
			style="border: 3px; height: 10%; width: 100%; background-color: rgb(255, 255, 255); table-layout: fixed;"
			align="Center" cellpadding="5" cellspacing="5" frame="border"
			rules="all">

			</tbody>

			<TR>
				<TD>${wc.wId}</TD>
				<TD>${wc.customerId}</TD>
				<TD>${wc.productId}</TD>
				<TD>${wc.tasteId}</TD>
				<TD>${wc.packageId}</TD>
				<TD>${wc.stock}</TD>
				<TD>${wc.acREC}</TD>
				<TD>${wc.acRET}</TD>
				<TD>${wc.acSAL}</TD>
				<TD>${wc.acBAD}</TD>
				<TD>${wc.acBAL}</TD>
				<TD>${wc.mfd}</TD>				
			</TR>
			<tr>

			</tr>

			</tbody>
		</TABLE>

	</c:forEach>
</body>
</html>