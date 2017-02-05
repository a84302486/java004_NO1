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
					<TD>${CustomerBean.customer_id}</TD>
					<TD>${CustomerBean.simple_Name}</TD>
					<TD>${CustomerBean.name}</TD>
					<TD>${CustomerBean.sale_Path}</TD>
					<TD>${CustomerBean.telephone}</TD>
					<TD>${CustomerBean.fax}</TD>
					<TD>${CustomerBean.contacter}</TD>
					<TD>${CustomerBean.address}</TD>
					<TD>${CustomerBean.uniform_NO}</TD>
					<TD>${CustomerBean.this_Invertory_Date}</TD>
					<TD>${CustomerBean.last_Invertory_Date}</TD>
					<TD>${CustomerBean.PR_Status}</TD>
					<TD>${CustomerBean.current_Discount_id}</TD>
					<TD>${CustomerBean.next_Discount_id}</TD>
					<TD>${CustomerBean.tax_Type}</TD>
					<TD>${CustomerBean.URL}</TD>
					<TD>${CustomerBean.principal_Name}</TD>
					<TD>${CustomerBean.contact_Name}</TD>
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