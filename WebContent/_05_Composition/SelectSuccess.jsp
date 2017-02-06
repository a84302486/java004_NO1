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
<title>成份</title>
</head>
<body>
	<H1>成份查詢成功</h1>
	<table
		style="border: 3px; height: 10%; width: 100%; background-color: rgb(255, 255, 255); table-layout: fixed;"
		align="Center" cellpadding="5" cellspacing="5">

		</tbody>
		<TR>
			<TD>類型</TD>
			<TD>序號</TD>
			<TD>敘述</TD>
		</TR>
		<tr>
		</tr>
		</tbody>
	</TABLE>

	<c:forEach var="cic" items="${compositionIdColl}">

		<table
			style="border: 3px; height: 10%; width: 100%; background-color: rgb(255, 255, 255); table-layout: fixed;"
			align="Center" cellpadding="5" cellspacing="5" frame="border"
			rules="all">

			</tbody>

			<TR>
				<TD>${cic.comType}</TD>
				<TD>${cic.comId}</TD>
				<TD>${cic.comDescription}</TD>
			</TR>
			<tr>
			</tr>
			
			</tbody>
		</TABLE>

	</c:forEach>
</body>
</html>