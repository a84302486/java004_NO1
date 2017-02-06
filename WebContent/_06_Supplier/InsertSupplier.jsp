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
<H1>新增廠商資料</H1>
  
<HR>
<Form Action="Insert.do" method="POST">
    <Table>
    	 <TR>
             <TD align="RIGHT">序號：</TD>
             <TD align="LEFT"><input	type="text" name="supplierId" value="001" size="20"></TD>
         </TR>
         <TR>
             <TD align="RIGHT">廠商名稱：</TD>
             <TD align="LEFT"><input	type="text" name="name" value="好犇牛肉商" size="20"></TD>
         </TR>
         <TR>
             <TD align="RIGHT">電話號碼：</TD>
             <TD align="LEFT"><input	type="text" name="telephone" value="0222881122" size="20"></TD>
         </TR>
         <TR>
             <TD align="RIGHT">郵遞區號：</TD>
             <TD align="LEFT"><input	type="text" name="zipNo" value="247" size="20"></TD>
         </TR>
         <TR>
             <TD align="RIGHT">地址：</TD>
             <TD align="LEFT"><input	type="text" name="address" value="新北市XXXXXXXXXXX" size="20"></TD>
         </TR>
         <TR>
             <TD align="RIGHT">傳真：</TD>
             <TD align="LEFT"><input	type="text" name="fax" value="0222883344" size="20"></TD>
         </TR>
         <TR>
             <TD align="RIGHT">Email：</TD>
             <TD align="LEFT"><input	type="text" name="email" value="goodBeef@gmail.com" size="20"></TD>
         </TR>
         <TR>
             <TD align="RIGHT">網站連結：</TD>
             <TD align="LEFT"><input	type="text" name="url" value="www.goodBeef.com.tw" size="20"></TD>
         </TR>
         <TR>
             <TD align="RIGHT">負責人：</TD>
             <TD align="LEFT"><input	type="text" name="principalName" value="牛某人" size="20"></TD>
         </TR>
         <TR>
             <TD align="RIGHT">連絡人：</TD>
             <TD align="LEFT"><input	type="text" name="contactName" value="某業務" size="20"></TD>
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
