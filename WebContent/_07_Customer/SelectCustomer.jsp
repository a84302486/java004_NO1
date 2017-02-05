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
<H1>客戶查詢</H1>
  
<HR>
<Form Action="SelectFindAll.do" method="POST">
<Table>
		
         <TR>
            <TD colspan="2" align="center">列出所有客戶資料 <br><br><input type="submit" value="開始查詢"> </TD>
         </TR>
</Table>
</Form>
<HR>

<Form Action="SelectFindByPrimaryKey.do" method="POST">
<Table>
		<br>
		<TR>
             <TD align="RIGHT">用客戶編號查詢</TD>
             <TD align="LEFT"><input type="text" name="Customer_id" value="A001" size="20"></TD>
         </TR>
         <TR>
            <TD colspan="2" align="center"><br><input type="submit" value="開始查詢"> </TD>
         </TR>
</Table>
</Form>
<HR>


</CENTER>
</body>

</html>