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
<title>會員查詢</title>
</head>
<body>
	<H1>會員列表查詢</h1>


	<TD height='32' width='560'>
			<TABLE border='1'>
				<TR>
					<TD width='560'>會員帳號</TD>
					<TD width='560'>會員姓名</TD>
					<TD width='560'>會員卡號</TD>
					<TD width='560'>會員暱稱</TD>
					<TD width='560'>會員生日</TD>
					<TD width='560'>電子信箱</TD>
					<TD width='1200'>會員電話</TD>

				</TR>
			</TABLE>
	</TD>

	<c:forEach varStatus="stVar" var="Member" items="${memberColl}">


		<TD height='32' width='560'>
			<TABLE border='1'>
				<TR height='30'>
				<TR height='30'>
					<TD width='560'>${Member.m_Username}</TD>
					<TD width='560'>${Member.m_Name}</TD>
					<TD width='560'>${Member.m_ID}</TD>
					<TD width='560'>${Member.m_Nick}</TD>
					<TD width='560'>${Member.m_Birthday}</TD>
					<TD width='560'>${Member.m_EMail}</TD>
					<TD width='1200'>${Member.m_Phone}</TD>

				</TR>
			</TABLE>
		</TD>

	</c:forEach>



</body>
</html>