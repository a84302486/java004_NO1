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
             <TD align="RIGHT">成份類型：</TD>
             <TD align="LEFT"><input	type="text" name="compositionType" value="B" size="20"></TD>
         </TR>
         <TR>
             <TD align="RIGHT">成份序號：</TD>
             <TD align="LEFT"><input	type="text" name="compositionId" value="001" size="20"></TD>
         </TR>
                  <TR>
             <TD align="RIGHT">成份敘述：</TD>
             <TD align="LEFT"><input	type="text" name="compositionDesc" value="牛肉" size="20"></TD>
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
