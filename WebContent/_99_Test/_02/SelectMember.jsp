<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/styles.css'  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MVC</title>
</head>
<body>
<CENTER>

<Form Action="_14_Member/Select.do" method="POST">
<Table>
		<TR>
             <TD align="RIGHT">用帳號查詢</TD>
             <TD align="LEFT"><input type="text" name="Username" value="helloSnoopy" size="20"></TD>
         </TR>
         <TR>
            <TD colspan="2" align="center"><input type="submit" value="開始查詢"> </TD>
         </TR>
</Table>
</Form>


</CENTER>
</body>

</html>