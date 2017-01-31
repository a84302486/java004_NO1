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
<H1>加入會員</H1>
  
<HR>
<Form Action="insert.do" method="POST">
    <Table>
    	 <TR>
             <TD align="RIGHT">卡號：</TD>
             <TD align="LEFT"><input	type="text" name="ID" value="001" size="20"></TD>
         </TR>
         <TR>
             <TD align="RIGHT">帳號：</TD>
             <TD align="LEFT"><input	type="text" name="Username" value="helloSnoopy" size="20"></TD>
         </TR>
         <TR>
             <TD align="RIGHT">密碼：</TD>
             <TD align="LEFT" ><input	type="password" name="Password" value="123456" size="20"></TD>
         </TR> 
         <TR>
             <TD align="RIGHT">密碼確認：</TD>
             <TD align="LEFT" ><input	type="password" name="Password2" value="123456" size="20"></TD>
         </TR>            
         <TR>
             <TD align="RIGHT">姓名：</TD>
             <TD align="LEFT" ><input	type="text" name="Name" value="史努比"  size="30"></TD>
         </TR>                
         <TR>
             <TD align="RIGHT">暱稱：</TD>
             <TD align="LEFT" ><input	type="text" name="Nick" value="比"  size="30"></TD>
         </TR> 
         <TR>
             <TD align="RIGHT">性別：</TD>
             <TD align="LEFT" ><input	type="text" name="Sex" value="男"  size="30"></TD>
         </TR>        
         <TR>
             <TD align="RIGHT">生日：</TD>
             <TD align="LEFT" ><input	type="text" name="Birthday" value="2000-01-01"  size="30"></TD>
         </TR> 
           
         <TR>
             <TD align="RIGHT">EMail：</TD>
             <TD align="LEFT" ><input type="text" name="EMail" value="abc@ppp.com.tw" size="40"></TD>
         </TR>             
         <TR>
             <TD align="RIGHT">電話號碼：</TD>
             <TD align="LEFT" > <input type="text" name="Phone" value="02-2695-1111"></TD>
         </TR>  
         <TR>
             <TD align="RIGHT">手機號碼：</TD>
             <TD align="LEFT" > <input type="text" name="Cellphone" value="0999000999"></TD>
         </TR>
         <TR>
             <TD align="RIGHT">地址：</TD>
             <TD align="LEFT" > <input type="text" name="Address" value="台北市101"></TD>
         </TR>
         <TR>
             <TD align="RIGHT">LineID：</TD>
             <TD align="LEFT" > <input type="text" name="Line" value="123"></TD>
         </TR>
         <TR>
             <TD align="RIGHT">FaceBook：</TD>
             <TD align="LEFT" > <input type="text" name="FaceBook" value="123"></TD>
         </TR>
         <TR>
             <TD align="RIGHT">身分證號：</TD>
             <TD align="LEFT" > <input type="text" name="IdentityCard" value="F123456789"></TD>
         </TR>
         <TR>
             <TD align="RIGHT">發票抬頭：</TD>
             <TD align="LEFT" > <input type="text" name="Invoice" value="快樂股份有限公司"></TD>
         </TR>
         <TR>
             <TD align="RIGHT">統一編號：</TD>
             <TD align="LEFT" > <input type="text" name="UniformNumber" value="0999000999"></TD>
         </TR>                    
         <TR>
            <TD colspan="2" align="center"> <input type="submit" value="提交"> </TD>
         </TR>
         </Table>
</Form>
</CENTER>
</body>

</html>
