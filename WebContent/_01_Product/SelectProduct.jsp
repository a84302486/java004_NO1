<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<h1>產品</h1>
	<hr>
	<Form Action="select.do" method="POST">
		<Table>
			<TR>
				<TD align="RIGHT">用料號查詢：</TD>
				<TD align="LEFT"><input type="text" name="Product_id"
					value="123" size="20"></TD>
			</TR>
			<TR>
				<TD colspan="2" align="center"><input type="submit" value="提交">
				</TD>
			</TR>
		</Table>
	</Form>
</body>
</html>