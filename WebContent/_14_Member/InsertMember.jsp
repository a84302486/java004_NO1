<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/styles.css'
	type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MVC</title>
</head>
<body>
		<Form Action="insert.do" method="POST">

			<table
				style="height: 10%; width: 85%; background-color: rgb(255, 255, 255); table-layout: fixed;">
				<TR>
					<TD align="left">會員卡號</TD>
					<TD align="left">會員帳號</TD>
					<TD align="left">會員密碼</TD>
					<TD align="left">密碼確認</TD>
					<TD align="left">電子信箱</TD>
					<TD align="left">會員姓名</TD>
					<TD align="left">會員暱稱</TD>

					</tr>
					<tr>
					</tr>


				<TR>
					<TD align="center"><input type="text" name="ID" value="001"
						size="20"></TD>
					<TD align="center"><input type="text" name="Username"
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
					
				</TR>
				<tr>
					<TD align="left">身分證號</TD>
					<TD align="left">會員性別</TD>
					<TD align="left">會員生日</TD>
					<TD align="left">會員電話</TD>
					<TD align="left">會員手機</TD>
					<TD align="left">會員地址</TD>
					<TD align="left">LineID</TD>
					
				</tr>
				<tr>
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
				</tr>
				<tr>
					<TD align="left">FaceBook</TD>
					<TD align="left">發票抬頭</TD>
					<TD align="left">統一編號</TD>
				</tr>
				<tr>
					<TD align="center"><input type="text" name="FaceBook"
						value="123" size="20"></TD>
					<TD align="center"><input type="text" name="Invoice"
						value="快樂股份有限公司" size="20"></TD>
					<TD align="center"><input type="text" name="UniformNumber"
						value="0999000999" size="20"></TD>
					</tr>
					<tr>
					<TD colspan="1" align="left"><input type="submit"
						value="加入會員"></TD>
				</tr>

			</table>
		</Form>

</body>

</html>
