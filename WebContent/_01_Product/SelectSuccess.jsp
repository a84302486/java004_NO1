﻿<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/styles.css'
	type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>產品</title>
</head>
<body>
	<H1>產品查詢成功</h1>
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
	
	<c:forEach var="pic" items="${productIdColl}">

		<table
			style="border: 3px; height: 10%; width: 100%; background-color: rgb(255, 255, 255); table-layout: fixed;"
			align="Center" cellpadding="5" cellspacing="5" frame="border"
			rules="all">

			</tbody>

			<TR>
				<TD>${pic.product_id}</TD>
				<TD>${pic.p_g_price}</TD>
				<TD>${pic.name}</TD>
				<TD>${pic.avg_cost}</TD>
				<TD>${pic.o_place}</TD>
				<TD>${pic.s_life}</TD>
				<TD>${pic.suppier_id}</TD>
			</TR>
			<tr>

			</tr>

			</tbody>
		</TABLE>

	</c:forEach>
</body>
</html>