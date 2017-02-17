<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/member.css'  type="text/css" />
<script src ="../js/member/select.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<!-- <Form Action="Select" method="POST"> -->
<!-- <Form Action="Javascript:%200" onsubmit="getQueryData('Select');return false;"> -->
<Form Action="Javascript:%200" >
<center>
          	  輸入帳號查詢:
             <input type="text" name="Username" id="SelectUsername"  value="helloSnoopy" size="20" placeholder="不輸入搜尋全部"/>
<!--              <input type="submit" value="開始查詢" onclick="getQueryData('Select','resultIndex');"/> -->    
             <input type="submit" value="開始查詢" onclick ="getQueryData('SelectUsername','Select','resultIndex','result');" style="position:fixed;top:110px;right:250px;"/>
</center>
</Form>
<div id="result">
	<br>
</div>

</body>

</html>