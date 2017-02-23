<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<!-- <link rel="stylesheet" href="../css/member/member2.css?v524" -->
<!-- 	type="text/css"> -->
<script src="../js/member/insert.js"></script>
<script src="../js/member/member.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MVC</title>
</head>
<body>
	<Form Action="Javascript:%200" id="formInsert">
	
		<table style="position: absolute ;left:15em;">
			<TR>
				<TD align="center">欄位名稱</TD>
				<TD align="center"></TD>
			</TR>
			<TR>
				<TD>會員帳號</TD>
				<TD align="center"><input type="text" name="Username"
					id="Username" value="helloSnoopy"></TD>
			</TR>
			<TR>
				<TD align="center">會員密碼</TD>
				<TD align="center"><input type="password" name="Password"
					value="123456"></TD>
			</TR>
			<TR>
				<TD align="center">密碼確認</TD>
				<TD align="center"><input type="password" name="Password2"
					value="123456"></TD>
			</TR>
			<TR>
				<TD align="center">會員卡號</TD>
				<TD align="center"><input type="text" name="ID" id="ID"
					value=""></TD>
			</TR>
			<TR>
				<TD align="center">電子信箱</TD>
				<TD align="center"><input type="text" name="EMail"
					value="leo123@gmail.com"></TD>
			</TR>
			<TR>
				<TD align="center">會員姓名</TD>
				<TD align="center"><input type="text" name="Name" value="史努比"></TD>
			</TR>
			<TR>
				<TD align="center">會員暱稱</TD>
				<TD align="center"><input type="text" name="Nick" value="比"></TD>
			</TR>
			<TR>
				<TD align="center">身分證號</TD>
				<TD align="center"><input type="text" name="IdentityCard"
					value="F123456789"></TD>
			</TR>
			<TR>
				<TD align="center">會員性別</TD>
				<TD align="center"><input type="text" name="Sex" value="男"></TD>
			</TR>
			<TR>
				<TD align="center">會員生日</TD>
				<TD align="center"><input type="text" name="Birthday"
					value="2000-01-01"></TD>
			</TR>
			<TR>
				<TD align="center">會員電話</TD>
				<TD align="center"><input type="text" name="Phone"
					value="02-2695-1111"></TD>
			</TR>
			<TR>
				<TD align="center">會員手機</TD>
				<TD align="center"><input type="text" name="Cellphone"
					value="0999000999"></TD>
			</TR>
			<TR>
				<TD align="center">會員地址</TD>
				<TD align="center"><input type="text" name="Address"
					value="台北市101"></TD>
			</TR>
			<TR>
				<TD align="center">LineID</TD>
				<TD align="center"><input type="text" name="Line" value="123"></TD>
			</TR>
			<TR>
				<TD align="center">FaceBook</TD>
				<TD align="center"><input type="text" name="FaceBook"
					value="123"></TD>
			</TR>
			<TR>
				<TD align="center">發票抬頭</TD>
				<TD align="center"><input type="text" name="Invoice"
					value="快樂股份有限公司"></TD>
			</TR>
			<TR>
				<TD align="center">統一編號</TD>
				<TD align="center"><input type="text" name="UniformNumber"
					value="0999000999"></TD>
			</TR>
			<TR>
				<TD colspan="2"> <br></TD>
			</TR>

			<TR>
				<TD colspan="1">
					<button onclick="location.href='http://localhost:8080/java004/_14_Member/IndexMember.jsp'">						
						<font color="red">
						取消新增
						</font>
					</button>
				</TD>
				<TD colspan="1">
					<Button id="submitinsert" onclick="setInsertData('Username','Insert','resultInsert');">
						<font color="#018bbd">
						確認新增
						</font>
					</Button>
				</TD>
			</TR>
			<br>
			
			<!-- 					<TD align="center">會員等級</TD> -->
				<!-- 					<TD align="center">紅利點數</TD> -->
				<!-- 					<TD align="center">累積消費</TD> -->

		</table>

	</Form>
	<div id="resultInsert"></div>

</body>

</html>
