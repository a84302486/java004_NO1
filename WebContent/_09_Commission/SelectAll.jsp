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
<title>佣金查詢</title>
</head>
<body>
	<H1>佣金列表查詢</h1>

	<table
		style="border: 3px; height: 10%; width: 100%; background-color: rgb(255, 255, 255); table-layout: fixed;"
		align="Center" cellpadding="5" cellspacing="5">

		</tbody>
		<TR>
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
	
	<c:forEach var="cc" items="${commissionColl}">

		<table
			style="border: 3px; height: 10%; width: 100%; background-color: rgb(255, 255, 255); table-layout: fixed;"
			align="Center" cellpadding="5" cellspacing="5" frame="border"
			rules="all">

			</tbody>
			<TR>
				<TD>${cc.discount01}</TD>
				<TD>${cc.discount02}</TD>
				<TD>${cc.discount03}</TD>
				<TD>${cc.discount04}</TD>
				<TD>${cc.discount05}</TD>
				<TD>${cc.discount06}</TD>
				<TD>${cc.discount07}</TD>
				<TD>${cc.discount08}</TD>
				<TD>${cc.discount09}</TD>
				<TD>${cc.discount10}</TD>
			</TR>
			<TR>
				<TD>${cc.rate01}</TD>
				<TD>${cc.rate02}</TD>
				<TD>${cc.rate03}</TD>
				<TD>${cc.rate04}</TD>
				<TD>${cc.rate05}</TD>
				<TD>${cc.rate06}</TD>
				<TD>${cc.rate07}</TD>
				<TD>${cc.rate08}</TD>
				<TD>${cc.rate09}</TD>
				<TD>${cc.rate10}</TD>
			</TR>
			<tr>

			</tr>

			</tbody>
		</TABLE>

	</c:forEach>
</body>
</html>