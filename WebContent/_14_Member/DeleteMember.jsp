<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/member.css'  type="text/css" />
<script src ="../js/member/delete.js"></script>
<script src ="../js/member/member.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<!-- <Form Action="Select" method="POST"> -->
<!-- <Form Action="Javascript:%200" onsubmit="getQueryData('Select');return false;"> -->
<Form Action="Javascript:%200">
<center>
<!-- setDeletData('Delete'); -->
          	   輸入帳號刪除:
<<<<<<< HEAD
             <input type="text" name="Username" id="Username" value="" size="20">
             <input type="submit" value="開始刪除">
<!-- <input type="submit" value="開始查詢" onclick ="getQueryData('Select')"/> -->
=======
             <input type="text" name="Username" id="DeleteUsername" value="" size="20" align="center">
             <button onclick="setDeleteData('Delete','DeleteUsername','result');getQueryDataLimit('LimitSelect','resultIndex');" style="position:fixed;top:4em;right:15.625em;">
           		刪除
           	 </button>
<!--  <input type="submit" value="開始查詢" onclick ="getQueryData('Select')"/> -->
</center>
>>>>>>> 050a76e9b244aa8a8167b8f86285e203036efd18
</Form>
<div id ="result" >
	<br>
</div>

</body>

</html>