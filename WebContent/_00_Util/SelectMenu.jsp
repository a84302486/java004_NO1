<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主選單</title>
</head>
<body>
	<select class="col-md-3" onChange="selectMenu(this)">
				<option selected>主 選 單</option>
				<option value="../_14_Member/IndexMember.jsp">會員資料</option>
				<option value="../_01_ProductTest/IndexProduct2.jsp">商品資訊</option>
	</select>
	<input type="text" name="time" value="time" class="col-md-3">
</body>

</html>
