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

			<table style="border: 5px double rgb(109, 2, 107); height: 50px; background-color: rgb(255, 255, 255);" align="left" cellpadding="5" cellspacing="5" frame="border" rules="all">
			<tbody>
				<TR height='30'>
					<TD width='560'>會員帳號</TD>
					<TD width='560'>會員姓名</TD>
					<TD width='560'>會員卡號</TD>
					<TD width='560'>會員暱稱</TD>
					<TD width='560'>會員生日</TD>
					<TD width='560'>電子信箱</TD>
					<TD width='1200'>會員電話</TD>

				</TR>
				</tbody>
			</TABLE>
	

	<c:forEach varStatus="stVar" var="MemberBean" items="${memberColl}">


		
			<table style="border: 5px double rgb(109, 2, 107); height: 30px; background-color: rgb(255, 255, 255);" align="left" cellpadding="5" cellspacing="5" frame="border" rules="all">

			</tbody>
				<TR height='30'>
					<TD width='560'>${MemberBean.m_Username}</TD>
					<TD width='560'>${MemberBean.m_Name}</TD>
					<TD width='560'>${MemberBean.m_ID}</TD>
					<TD width='560'>${MemberBean.m_Nick}</TD>
					<TD width='560'>${MemberBean.m_Birthday}</TD>
					<TD width='560'>${MemberBean.m_EMail}</TD>
					<TD width='1200'>${MemberBean.m_Phone}</TD>

				</TR>
				</tbody>
			</TABLE>
		

	</c:forEach>

</body>
</html>