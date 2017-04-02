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
<H1>新增資料</H1>
  
<HR>
<Form Action="Insert.do" method="POST">
    <Table>
    	 <TR>
             <TD align="RIGHT">產品序號：</TD>
             <TD align="LEFT"><input	type="text" name="productId" value="001" size="20"></TD>
         </TR>
         <TR>
             <TD align="RIGHT">產品定價：</TD>
             <TD align="LEFT"><input	type="text" name="PGPrice" value="500" size="20"></TD>
         </TR>
         <TR>
             <TD align="RIGHT">產品品名：</TD>
             <TD align="LEFT" ><input	type="text" name="name" value="羊咩咩羊肉爐" size="20"></TD>
         </TR>
         <TR>
             <TD align="RIGHT">產品成本：</TD>
             <TD align="LEFT" ><input	type="text" name="avgCost" value="300" size="20"></TD>
         </TR>      
         <TR>
             <TD align="RIGHT">產品生產地：</TD>
             <TD align="LEFT" ><input	type="text" name="oPlace" value="台灣台北" size="20"></TD>
         </TR>            
         <TR>
             <TD align="RIGHT">產品保存期：</TD>
             <TD align="LEFT" ><input	type="text" name="sLife" value="360"  size="30"></TD>
         </TR>                
                  <TR>
             <TD align="RIGHT">產品供應商：</TD>
             <TD align="LEFT" ><input	type="text" name="suppierId" value="A"  size="30"></TD>
         </TR> 
         <TR>
            <TD colspan="2" align="center"> 
            <input type="submit" value="提交"> </TD>
         </TR>
         </Table>
</Form>
</CENTER>
</body>

</html>
