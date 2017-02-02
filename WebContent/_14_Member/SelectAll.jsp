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

	<table style="border: 3px ;height: 10%; width:100%;background-color: rgb(255, 255, 255);table-layout:fixed;" align="Center" cellpadding="5" cellspacing="5" >

			</tbody>
			
				<TR>
					<TD>會員帳號</TD>
					<TD>會員姓名</TD>
					<TD>會員卡號</TD>
					<TD>會員暱稱</TD>
					<TD>會員生日</TD>
					<TD>電子信箱</TD>
					<TD>會員電話</TD>

				</TR>
				 <tr>
              	  
             	</tr>
            
				
			</tbody>
	</TABLE>
	<c:forEach varStatus="stVar" var="MemberBean" items="${memberColl}">


		
			<table style="border: 3px ; height: 10%; width:100%;background-color: rgb(255, 255, 255);table-layout:fixed;" align="Center" cellpadding="5" cellspacing="5" frame="border" rules="all">

			</tbody>
			
				<TR>
					<TD>${MemberBean.m_Username}</TD>
					<TD>${MemberBean.m_Name}</TD>
					<TD>${MemberBean.m_ID}</TD>
					<TD>${MemberBean.m_Nick}</TD>
					<TD>${MemberBean.m_Birthday}</TD>
					<TD>${MemberBean.m_EMail}</TD>
					<TD>${MemberBean.m_Phone}</TD>

				</TR>
				 <tr>
              	 
             	</tr>
            
				</tbody>
			</TABLE>
		

	</c:forEach>

</body>
</html>