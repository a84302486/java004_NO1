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
<H1>實盤更新</H1>
  
<HR>
<Form Action="Insert.do" method="POST">
    <Table>
<!--          <TR> -->
<!--              <TD align="RIGHT">序號：</TD> -->
<!--              <TD align="LEFT"><input	type="text" name="cpId" value="null" size="20"></TD> -->
<!--          </TR> -->
                  <TR>
             <TD align="RIGHT">日期：</TD>
             <TD align="LEFT"><input	type="text" name="cpDate" value="20170206" size="20"></TD>
         </TR>

         <TR>
             <TD align="RIGHT">REC：</TD>
             <TD align="LEFT"><input	type="text" name="cpREC" value="1" size="20"></TD>
         </TR>
         <TR>
             <TD align="RIGHT">RET：</TD>
             <TD align="LEFT"><input	type="text" name="cpRET" value="2" size="20"></TD>
         </TR>
         
         <TR>
             <TD align="RIGHT">SAL：</TD>
             <TD align="LEFT"><input	type="text" name="cpSAL" value="3" size="20"></TD>
         </TR>
 
         <TR>
             <TD align="RIGHT">BAD：</TD>
             <TD align="LEFT"><input	type="text" name="cpBAD" value="4" size="20"></TD>
         </TR>
         
         <TR>
             <TD align="RIGHT">BAL：</TD>
             <TD align="LEFT"><input	type="text" name="cpBAL" value="50" size="20"></TD>
         </TR>
         <TR>
             <TD align="RIGHT">結存：</TD>
             <TD align="LEFT"><input	type="text" name="endStock" value="100" size="20"></TD>
         </TR>
         <TR>
             <TD align="RIGHT">網路庫存：</TD>
             <TD align="LEFT"><input	type="text" name="netStock" value="100" size="20"></TD>
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
