<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/styles.css'  type="text/css" />
<script src ="../js/member.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<!-- <Form Action="Select" method="POST"> -->
<Form>

          	  輸入帳號查詢:
             <input type="text" name="Username"  value="helloSnoopy" size="20" placeholder="不輸入搜尋全部" onchange="getQueryData('Select');"/>
             <input type="submit" value="開始查詢" />
             
</Form>
<div id ="result" >
	This is a SelectMember.jsp's div.
</div>

</body>

</html>