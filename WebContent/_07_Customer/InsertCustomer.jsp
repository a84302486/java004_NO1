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
<H1>新增客戶</H1>
  
<HR>
<Form Action="insert.do" method="POST">
    <Table>
    	 <TR>
             <TD align="RIGHT">客戶編號：</TD>
             <TD align="LEFT"><input	type="text" name="Customer_id" value="A001" size="20"></TD>
         </TR>
         <TR>
             <TD align="RIGHT">簡稱：</TD>
             <TD align="LEFT"><input	type="text" name="Simple_Name" value="北科大" size="20"></TD>
         </TR>
         <TR>
             <TD align="RIGHT">名稱：</TD>
             <TD align="LEFT" ><input	type="text" name="Name" value="台北科技大學" size="20"></TD>
         </TR> 
         <TR>
             <TD align="RIGHT">通路：</TD>
             <TD align="LEFT" ><input	type="text" name="Sale_Path" value="" size="20"></TD>
         </TR>            
         <TR>
             <TD align="RIGHT">電話：</TD>
             <TD align="LEFT" ><input	type="text" name="Telephone" value=""  size="30"></TD>
         </TR>                
         <TR>
             <TD align="RIGHT">傳真：</TD>
             <TD align="LEFT" ><input	type="text" name="Fax" value=""  size="30"></TD>
         </TR> 
         <TR>
             <TD align="RIGHT">聯絡人：</TD>
             <TD align="LEFT" ><input	type="text" name="Contacter" value=""  size="30"></TD>
         </TR>        
         <TR>
             <TD align="RIGHT">地址：</TD>
             <TD align="LEFT" ><input	type="text" name="Address" value=""  size="30"></TD>
         </TR> 
           
         <TR>
             <TD align="RIGHT">統一編號：</TD>
             <TD align="LEFT" ><input type="text" name="Uniform_NO" value="" size="40"></TD>
         </TR>             
         <TR>
             <TD align="RIGHT">此次盤點日期：</TD>
             <TD align="LEFT" > <input type="text" name="This_Invertory_Date" value="2017-01-31"></TD>
         </TR>  
         <TR>
             <TD align="RIGHT">上次盤點日期：</TD>
             <TD align="LEFT" > <input type="text" name="Last_Invertory_Date" value="2017-01-20"></TD>
         </TR>
         <TR>
             <TD align="RIGHT">盤點狀態：</TD>
             <TD align="LEFT" > <input type="text" name="PR_Status" value=""></TD>
         </TR>
         <TR>
             <TD align="RIGHT">此次折扣代碼：</TD>
             <TD align="LEFT" > <input type="text" name="Current_Discount_id" value=""></TD>
         </TR>
         <TR>
             <TD align="RIGHT">下次折扣代碼：</TD>
             <TD align="LEFT" > <input type="text" name="Next_Discount_id" value=""></TD>
         </TR>
         <TR>
             <TD align="RIGHT">傳真：</TD>
             <TD align="LEFT" > <input type="text" name="Tax_Type" value=""></TD>
         </TR>
         <TR>
             <TD align="RIGHT">網站：</TD>
             <TD align="LEFT" > <input type="text" name="URL" value=""></TD>
         </TR>
         <TR>
             <TD align="RIGHT">老闆：</TD>
             <TD align="LEFT" > <input type="text" name="Principal_Name" value=""></TD>
         </TR>  
         <TR>
             <TD align="RIGHT">聯絡人：</TD>
             <TD align="LEFT" > <input type="text" name="Contact_Name" value=""></TD>
         </TR> 
         <TR>
             <TD align="RIGHT">Email：</TD>
             <TD align="LEFT" > <input type="text" name="Email" value=""></TD>
         </TR> 
         <TR>
             <TD align="RIGHT">LineID：</TD>
             <TD align="LEFT" > <input type="text" name="Line" value=""></TD>
         </TR> 
         <TR>
             <TD align="RIGHT">Skype：</TD>
             <TD align="LEFT" > <input type="text" name="Skype" value=""></TD>
         </TR>                   
         <TR>
            <TD colspan="2" align="center"> <input type="submit" value="提交"> </TD>
         </TR>
         </Table>
</Form>
</CENTER>
</body>

</html>
