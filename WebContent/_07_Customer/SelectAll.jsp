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
<title>客戶查詢</title>
</head>
<body>
	<H1>客戶列表查詢</h1>

	<table style="border: 3px ;height: 10%; width:200%;background-color: rgb(255, 255, 255);table-layout:fixed;" align="Center" cellpadding="5" cellspacing="5" >

			</tbody>
			
				<TR>
					<TD>客戶編號</TD>
					<TD>簡稱</TD>
					<TD>名稱</TD>
					<TD>通路</TD>
					<TD>電話</TD>
					<TD>傳真</TD>
					<TD>聯絡人</TD>
					<TD>地址</TD>
					<TD>統一編號</TD>
					<TD>此次盤點日期</TD>
					<TD>上次盤點日期</TD>
					<TD>盤點狀態</TD>
					<TD>此次折扣代碼</TD>
					<TD>下次折扣代碼</TD>
					<TD>傳真</TD>
					<TD>網站</TD>
					<TD>老闆</TD>
					<TD>聯絡人</TD>
					<TD>Email</TD>
					<TD>LineID</TD>
					<TD>Skype</TD>

				</TR>
				 <tr>           	  
             	</tr>
             	
             	 <TR>
             
            
				
			</tbody>
	</TABLE>
	<c:forEach varStatus="stVar" var="CustomerBean" items="${customerColl}">


		
			<table style="border: 3px ; height: 10%; width:200%;background-color: rgb(255, 255, 255);table-layout:fixed;" align="Center" cellpadding="5" cellspacing="5" frame="border" rules="all">

			</tbody>
			
				<TR>
					<TD>${CustomerBean.customerId}</TD>
					<TD>${CustomerBean.simpleName}</TD>
					<TD>${CustomerBean.name}</TD>
					<TD>${CustomerBean.salePath}</TD>
					<TD>${CustomerBean.telephone}</TD>
					<TD>${CustomerBean.fax}</TD>
					<TD>${CustomerBean.contacter}</TD>
					<TD>${CustomerBean.address}</TD>
					<TD>${CustomerBean.uniformNO}</TD>
					<TD>${CustomerBean.thisInvertoryDate}</TD>
					<TD>${CustomerBean.lastInvertoryDate}</TD>
					<TD>${CustomerBean.prStatus}</TD>
					<TD>${CustomerBean.currentDiscountId}</TD>
					<TD>${CustomerBean.nextDiscountId}</TD>
					<TD>${CustomerBean.taxType}</TD>
					<TD>${CustomerBean.url}</TD>
					<TD>${CustomerBean.principalName}</TD>
					<TD>${CustomerBean.contactName}</TD>
					<TD>${CustomerBean.email}</TD>
					<TD>${CustomerBean.line}</TD>
					<TD>${CustomerBean.skype}</TD>

				</TR>
				 <tr>            	 
             	</tr>
            
				</tbody>
			</TABLE>
		

	</c:forEach>

</body>
</html>