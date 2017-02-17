<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/member.css'  type="text/css" />
<script src ="../js/member/delete.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<!-- <Form Action="Select" method="POST"> -->
<!-- <Form Action="Javascript:%200" onsubmit="getQueryData('Select');return false;"> -->
<Form Action="Javascript:%200">
<center>
<!-- setDeletData('Delete'); -->
          	   輸入帳號刪除:
             <input type="text" name="Username" id="DeleteUsername" value="" size="20" align="center">
             <input type="button" value="開始刪除" onclick="setDeleteData('Delete','DeleteUsername','result');" style="position:fixed;top:110px;right:250px;">
<!--              <input type="submit" value="開始查詢" onclick ="getQueryData('Select')"/> -->
</center>
</Form>
<div id ="result" >
	<br>
</div>

</body>

</html>