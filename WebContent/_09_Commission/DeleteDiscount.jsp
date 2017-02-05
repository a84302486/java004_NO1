<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/styles.css'
	type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MVC</title>
</head>
<body>
	<CENTER>
		<H1>折扣資料刪除</H1>
		<HR>

		<Form Action="Delete.do" method="POST">
			<Table>
				<TR>
					<TD align="RIGHT">請輸入要刪除的折扣序號</TD>
					<TD align="LEFT"><input type="text" name="discountId" value="001"
						size="20"></TD>
				</TR>
				<TR>
					<TD colspan="2" align="center"><br> <input type="submit"
						value="開始刪除"></TD>
				</TR>
			</Table>
		</Form>
		<HR>

	</CENTER>
</body>

</html>