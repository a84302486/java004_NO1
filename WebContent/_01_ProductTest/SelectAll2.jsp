<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/styles.css' type="text/css" />

<script type="text/JavaScript">
 window.onload = getQueryData();
 document.getElementById(btn).onclick = getQueryData();
	 
	 
	 
	 function getQueryData(){ 
	
	   	var xhr = new XMLHttpRequest();
	   	xhr.open("GET", "SelectFindAll2", true);
	   	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	   	xhr.send();
	   	xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var content = "<table border='1'; height: 10%; width: 100%;>";
				var data = JSON.parse(xhr.responseText);
				for(var i=0; i < data.length; i++){
					content += "<tr><td>" + data[i].productId + "</td>" + 
					               "<td>" + data[i].pgPrice + "</td>" +
					               "<td>" + data[i].name + "</td>" +
					               "<td>" + data[i].avgCost + "</td>" +					              
					               "<td>" + data[i].oplace + "</td>" +
					               "<td>" + data[i].slife + "</td>" +
					               "<td>" + data[i].suppierId + "</td>";
					           "</tr>";    
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
	<H1>產品列表查詢2</h1>

	<table
		style="border: 3px; height: 10%; width: 100%; background-color: rgb(255, 255, 255); table-layout: fixed;"
		align="Center" cellpadding="5" cellspacing="5">

		</tbody>
		<TR>
			<TD>序號</TD>
			<TD>定價</TD>
			<TD>名稱</TD>
			<TD>成本</TD>
			<TD>生產地</TD>
			<TD>保存期</TD>
			<TD>供應商</TD>
		</TR>
		<tr>
		</tr>
		
		</tbody>
	</TABLE>

<div id='Result'>
顯示結果<br/>
</div>

</body>
</html>