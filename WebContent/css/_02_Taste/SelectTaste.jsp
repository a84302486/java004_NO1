<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<title>MVC</title>
<body>

	<CENTER>
	<Form Action="Javascript:%200" >
		<div>
			序號查詢:<input type="text" id="tasteId" name="tasteId" value="" size="20" placeholder="不輸入將搜尋全部"> 
					<input type="button" value="開始查詢" onclick="getQueryData('../_02_Taste/SelectTaste.do');">
			口味查詢:<input type="text" id="tasteId" name="tasteId" value="" size="20" placeholder="不輸入將搜尋全部"> 
			<input type="button" value="開始查詢" onclick="getQueryData('../_02_Taste/SelectTaste.do');">
		</div>	
	</Form>
		<div id="selectResult"></div>
	</CENTER>

</body>
</html>