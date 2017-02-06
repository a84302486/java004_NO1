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
<title>廠商資料查詢</title>
</head>
<body>
	<H1>廠商資料查詢</h1>

	<table
		style="border: 3px; height: 10%; width: 100%; background-color: rgb(255, 255, 255); table-layout: fixed;"
		align="Center" cellpadding="5" cellspacing="5">

		</tbody>
		<TR>
			<TD>序號</TD>
			<TD>廠商名稱</TD>
			<TD>電話號碼</TD>
			<TD>郵遞區號</TD>
			<TD>地址</TD>
			<TD>傳真</TD>
			<TD>Email</TD>
			<TD>網站連結</TD>
			<TD>負責人</TD>
			<TD>連絡人</TD>
		</TR>
		<tr>
		</tr>

		</tbody>
	</TABLE>
	
	<c:forEach var="sc" items="${supplierColl}">

		<table
			style="border: 3px; height: 10%; width: 100%; background-color: rgb(255, 255, 255); table-layout: fixed;"
			align="Center" cellpadding="5" cellspacing="5" frame="border"
			rules="all">

			</tbody>

			<TR>
				<TD>${sc.supplierId}</TD>
				<TD>${sc.name}</TD>
				<TD>${sc.telephone}</TD>
				<TD>${sc.zipNo}</TD>
				<TD>${sc.address}</TD>
				<TD>${sc.fax}</TD>
				<TD>${sc.email}</TD>
				<TD>${sc.url}</TD>
				<TD>${sc.principalName}</TD>
				<TD>${sc.contactName}</TD>
			</TR>
			<tr>

			</tr>

			</tbody>
		</TABLE>

	</c:forEach>
</body>
</html>