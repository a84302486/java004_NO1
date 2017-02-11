<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/asset/css/test.css' type="text/css" />

<script type="text/JavaScript">
window.onload = getQueryData('SelectFindAll2');
/* document.getElementById(btn).onclick= getQueryData('SelectFindAll2'); */
 
	 function getQueryData(servelet){ 
	   	var xhr = new XMLHttpRequest();
	   	xhr.open("GET", servelet, true);
	   	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	   	xhr.send();
	   	xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {

				var content = "<table>" +
								"<tr><td>序號</td>" + 
	               				"<td>定價</td>" +
	               				"<td>名稱</td>" +
	               				"<td>成本</td>" +					              
	               				"<td>生產地</td>" +
	               				"<td>保存期</td>" +
	               				"<td>供應商</td></tr>";

				var data = JSON.parse(xhr.responseText);
				for(var i=0; i < data.length; i++){
					content += "<tr><td>" + data[i].productId + "</td>" + 
					               "<td>" + data[i].pgPrice + "</td>" +
					               "<td>" + data[i].name + "</td>" +
					               "<td>" + data[i].avgCost + "</td>" +					              
					               "<td>" + data[i].oplace + "</td>" +
					               "<td>" + data[i].slife + "</td>" +
					               "<td>" + data[i].suppierId + "</td></tr>";    
				}
				content += "</table>";
				var divs = document.getElementById("Result");
				divs.innerHTML = content;
		}
	}
}

</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>產品查詢</title>
</head>
<body>
	<h2>所有產品資料</h2>

		<div id='Result'>顯示結果<br></div>

</body>
</html>