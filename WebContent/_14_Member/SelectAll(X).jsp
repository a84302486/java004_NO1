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

	<table border="1"
		style="height: 10%; width: 200%; background-color: rgb(255, 255, 255); table-layout: fixed;">
		<TR>
			<TD>會員帳號</TD>
			<TD>會員姓名</TD>
			<TD>會員卡號</TD>
			<TD>會員暱稱</TD>
			<TD>會員生日</TD>
			<TD>電子信箱</TD>
			<TD>會員電話</TD>
			<TD>會員手機</TD>
			<TD>LineID</TD>
			<TD>FaceBook</TD>
			<TD>身分證號</TD>
			<TD>統一編號</TD>
			<TD>發票抬頭</TD>
			<TD>加入時間</TD>
			<TD>會員等級</TD>
			<TD>紅利點數</TD>
			<TD>累積消費</TD>

		</tr>
		<tr>
		</tr>



		<c:forEach varStatus="stVar" var="MemberBean" items="${memberColl}">

			<TR>
				<TD>${MemberBean.m_Username}</TD>
				<TD>${MemberBean.m_Name}</TD>
				<TD>${MemberBean.m_ID}</TD>
				<TD>${MemberBean.m_Nick}</TD>
				<TD>${MemberBean.m_Birthday}</TD>
				<TD>${MemberBean.m_EMail}</TD>
				<TD>${MemberBean.m_Phone}</TD>
				<TD>${MemberBean.m_Cellphone}</TD>
				<TD>${MemberBean.m_Line}</TD>
				<TD>${MemberBean.m_FaceBook}</TD>
				<TD>${MemberBean.m_IdentityCard}</TD>
				<TD>${MemberBean.m_UniformNumber}</TD>
				<TD>${MemberBean.m_Invoice}</TD>
				<TD>${MemberBean.m_Joindate}</TD>
				<TD>${MemberBean.m_Level}</TD>
				<TD>${MemberBean.m_BonusPoints}</TD>
				<TD>${MemberBean.m_Total}</TD>

			</tr>
			<tr>
			</tr>

		</c:forEach>
	</table>

</body>
</html>