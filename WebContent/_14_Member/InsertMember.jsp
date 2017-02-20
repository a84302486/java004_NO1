<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" href="../css/member.css" type="text/css">
<script src ="../js/member/insert.js"></script>
<script src ="../js/member/member.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MVC</title>
</head>
<body>
<!-- 			<Form Action="Insert" method="POST" id="result">  -->
<!-- 			<Form Action="Javascript:%200" onsubmit="getQueryData('Insert');"> -->
		
				<table>
				<TR>
					<TD align="center">會員卡號</TD>
					<TD align="center">會員帳號</TD>
					<TD align="center">會員密碼</TD>
					<TD align="center">密碼確認</TD>
					<TD align="center">電子信箱</TD>
					<TD align="center">會員姓名</TD>
					<TD align="center">會員暱稱</TD>
					<TD align="center">身分證號</TD>
					<TD align="center">會員性別</TD>
					<TD align="center">會員生日</TD>
					<TD align="center">會員電話</TD>
					<TD align="center">會員手機</TD>
					<TD align="center">會員地址</TD>
					<TD align="center">LineID</TD>			
					<TD align="center">FaceBook</TD>
					<TD align="center">發票抬頭</TD>
					<TD align="center">統一編號</TD>
<!-- 					<TD align="center">會員等級</TD> -->
<!-- 					<TD align="center">紅利點數</TD> -->
<!-- 					<TD align="center">累積消費</TD> -->

				</tr>
				</table>

		<Form Action="Javascript:%200">
				<table>
				<TR>
					<TD align="center"><input type="text" name="ID" value=""
						size="20"></TD>
					<TD align="center"><input type="text" name="Username" id="Username"
						value="helloSnoopy" size="20"></TD>
					<TD align="center"><input type="password" name="Password"
						value="123456" size="20"></TD>
					<TD align="center"><input type="password" name="Password2"
						value="123456" size="20"></TD>
					<TD align="center"><input type="text" name="EMail"
						value="leo123@gmail.com" size="30"></TD>
					<TD align="center"><input type="text" name="Name" value="史努比"
						size="20"></TD>
					<TD align="center"><input type="text" name="Nick" value="比"
						size="20"></TD>
					<TD align="center"><input type="text" name="IdentityCard"
						value="F123456789" size="20"></TD>
					<TD align="center"><input type="text" name="Sex" value="男"
						size="20"></TD>
					<TD align="center"><input type="text" name="Birthday"
						value="2000-01-01" size="20"></TD>
					<TD align="center"><input type="text" name="Phone"
						value="02-2695-1111" size="20"></TD>
					<TD align="center"><input type="text" name="Cellphone"
						value="0999000999" size="20"></TD>
					<TD align="center"><input type="text" name="Address"
						value="台北市101" size="20"></TD>
					<TD align="center"><input type="text" name="Line" value="123"
						size="20"></TD>
					<TD align="center"><input type="text" name="FaceBook"
						value="123" size="20"></TD>
					<TD align="center"><input type="text" name="Invoice"
						value="快樂股份有限公司" size="20"></TD>
					<TD align="center"><input type="text" name="UniformNumber"
						value="0999000999" size="20"></TD>
					<TD colspan="1" align="right" style="position:fixed;top:4em;right:15.625em;">
						<button onclick="setInsertData('Username','Insert','resultInsert','LimitSelect','resultIndex');">
						新增
						</button>
					</TD>
				</tr>
			
					
			</table>
		</Form>
		<div id ="resultInsert" >
			
		</div>

</body>

</html>
