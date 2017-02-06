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
<title>實盤更新</title>
</head>
<body>
	<H1>實盤更新查詢成功</h1>
	<table
		style="border: 3px; height: 10%; width: 100%; background-color: rgb(255, 255, 255); table-layout: fixed;"
		align="Center" cellpadding="5" cellspacing="5">

		</tbody>
		<TR>
			<TD>序號</TD>
			<TD>日期</TD>
			<TD>REC</TD>
			<TD>RET</TD>
			<TD>SAL</TD>
			<TD>BAD</TD>
			<TD>BAL</TD>
			<TD>結存</TD>
			<TD>網路庫存/TD>
		</TR>
		<tr>
		</tr>
		</tbody>
	</TABLE>

	<c:forEach var="cic" items="${cpIdColl}">

		<table
			style="border: 3px; height: 10%; width: 100%; background-color: rgb(255, 255, 255); table-layout: fixed;"
			align="Center" cellpadding="5" cellspacing="5" frame="border"
			rules="all">

			</tbody>

			<TR>
				<TD>${cic.cpId}</TD>
				<TD>${cic.cpDate}</TD>
				<TD>${cic.cpREC}</TD>
				<TD>${cic.cpRET}</TD>
				<TD>${cic.cpSAL}</TD>
				<TD>${cic.cpBAD}</TD>
				<TD>${cic.cpBAL}</TD>
				<TD>${cic.endStock}</TD>
				<TD>${cic.netStock}</TD>	
			</TR>
			<tr>
			</tr>
			
			</tbody>
		</TABLE>

	</c:forEach>
</body>
</html>