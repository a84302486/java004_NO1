<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/test.css'  type="text/css" />
<script src ="../js/member.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<!-- <Form Action="Select" method="POST"> -->
<Form Action="Javascript:%200" onsubmit="getQueryData('Select')";return false;">

          	  輸入帳號查詢:
             <input type="text" name="Username" id="Username"  value="helloSnoopy" size="20" placeholder="不輸入搜尋全部" />
             <input type="submit" value="開始查詢" />
<!--              <input type="submit" value="開始查詢" onclick ="getQueryData('Select')"/> -->
</Form>
<div id ="result" >
	
</div>

</body>

</html>