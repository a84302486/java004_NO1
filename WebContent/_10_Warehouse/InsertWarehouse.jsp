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
<H1>倉庫資料</H1>
  
<HR>
<Form Action="Insert.do" method="POST">
    <Table>
         <TR>
             <TD align="RIGHT">倉庫序號：</TD>
             <TD align="LEFT"><input	type="text" name="wId" value="001" size="20"></TD>
         </TR>
                  <TR>
             <TD align="RIGHT">客戶：</TD>
             <TD align="LEFT"><input	type="text" name="customerId" value="張三" size="20"></TD>
         </TR>
         <TR>
             <TD align="RIGHT">產品：</TD>
             <TD align="LEFT"><input	type="text" name="productId" value="羊咩咩羊肉爐" size="20"></TD>
         </TR>

         <TR>
             <TD align="RIGHT">口味：</TD>
             <TD align="LEFT"><input	type="text" name="tasteId" value="原味" size="20"></TD>
         </TR>

         <TR>
             <TD align="RIGHT">包裝：</TD>
             <TD align="LEFT"><input	type="text" name="packageId" value="大包" size="20"></TD>
         </TR>

         <TR>
             <TD align="RIGHT">庫存：</TD>
             <TD align="LEFT"><input	type="text" name="stock" value="10" size="20"></TD>
         </TR>

         <TR>
             <TD align="RIGHT">acREC：</TD>
             <TD align="LEFT"><input	type="text" name="acREC" value="1" size="20"></TD>
         </TR>
         <TR>
             <TD align="RIGHT">acRET：</TD>
             <TD align="LEFT"><input	type="text" name="acRET" value="2" size="20"></TD>
         </TR>
         <TR>
             <TD align="RIGHT">acSAL：</TD>
             <TD align="LEFT"><input	type="text" name="acSAL" value="3" size="20"></TD>
         </TR>
         <TR>
             <TD align="RIGHT">acBAD：</TD>
             <TD align="LEFT"><input	type="text" name="acBAD" value="4" size="20"></TD>
         </TR>
         <TR>
             <TD align="RIGHT">acBAL：</TD>
             <TD align="LEFT"><input	type="text" name="acBAL" value="5" size="20"></TD>
         </TR>
         <TR>
             <TD align="RIGHT">MFC：</TD>
             <TD align="LEFT"><input	type="text" name="mfd" value="6" size="20"></TD>
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
