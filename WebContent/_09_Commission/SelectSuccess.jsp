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
<title>佣金</title>
</head>
<body>
	<H1>佣金查詢成功</h1>
	<table
		style="border: 3px; height: 10%; width: 100%; background-color: rgb(255, 255, 255); table-layout: fixed;"
		align="Center" cellpadding="5" cellspacing="5">

		</tbody>
		<TR>
			<TD>折扣01</TD>
			<TD>折扣02</TD>
			<TD>折扣03</TD>
			<TD>折扣04</TD>
			<TD>折扣05</TD>
			<TD>折扣06</TD>
			<TD>折扣07</TD>
			<TD>折扣08</TD>
			<TD>折扣09</TD>
			<TD>折扣10</TD>
		</TR>
		<TR>
			<TD>Rate01</TD>
			<TD>Rate02</TD>
			<TD>Rate03</TD>
			<TD>Rate04</TD>
			<TD>Rate05</TD>
			<TD>Rate06</TD>
			<TD>Rate07</TD>
			<TD>Rate08</TD>
			<TD>Rate09</TD>
			<TD>Rate10</TD>
		</TR>
		<tr>
		</tr>
		</tbody>
	</TABLE>

	<c:forEach var="cic" items="${commissionIdColl}">

		<table
			style="border: 3px; height: 10%; width: 100%; background-color: rgb(255, 255, 255); table-layout: fixed;"
			align="Center" cellpadding="5" cellspacing="5" frame="border"
			rules="all">

			</tbody>

			<TR>
				<TD>${cic.discount01}</TD>
				<TD>${cic.discount02}</TD>
				<TD>${cic.discount03}</TD>
				<TD>${cic.discount04}</TD>
				<TD>${cic.discount05}</TD>
				<TD>${cic.discount06}</TD>
				<TD>${cic.discount07}</TD>
				<TD>${cic.discount08}</TD>
				<TD>${cic.discount09}</TD>
				<TD>${cic.discount10}</TD>
			</TR>
			<TR>
				<TD>${cic.rate01}</TD>
				<TD>${cic.rate02}</TD>
				<TD>${cic.rate03}</TD>
				<TD>${cic.rate04}</TD>
				<TD>${cic.rate05}</TD>
				<TD>${cic.rate06}</TD>
				<TD>${cic.rate07}</TD>
				<TD>${cic.rate08}</TD>
				<TD>${cic.rate09}</TD>
				<TD>${cic.rate10}</TD>
			</TR>
			<tr>
			</tr>
			
			</tbody>
		</TABLE>

	</c:forEach>
</body>
</html>