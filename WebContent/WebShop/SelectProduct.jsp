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
<H1>產品查詢</H1>
  
<HR>
<Form Action="SelectFindAll.do" method="POST">
<Table>
		
         <TR>
            <TD colspan="2" align="center">列出所有產品資料 <br><br><input type="submit" value="開始查詢"> </TD>
         </TR>
</Table>
</Form>
<HR>

<Form Action="../_21_ShoppingOrder/SelectTtacking.do" method="POST">
<Table>		
         <TR>
            <TD colspan="2" align="center"><br><input type="submit" value="開始查詢"> </TD>
         </TR>
</Table>
</Form>
<HR>


</CENTER>
</body>

</html>