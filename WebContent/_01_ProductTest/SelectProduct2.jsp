<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel='stylesheet'
	href='${pageContext.request.contextPath}/css/styles.css'
	type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MVC</title>
</head>
<body >
<CENTER>
	<font size="4" color="red" face="Tahoma"> 
	
		<Form>
		 
			<div>
			 			
				列出所有產品資料:<input type="Submit" value="開始查詢" id="btn">
			</div>
			
		</Form>
		
		
		<Form Action="SelectFindByPrimaryKey.do" method="POST">
			<div>
				用序號查詢:<input type="text" name="productId" value="001" size="20">
				<input type="submit" value="開始查詢">
			</div>
			
			
		</Form>

	</font>
	</CENTER>
</body>

<script type="text/JavaScript">
 //window.onload = getQueryData();
 document.getElementById(btn).onclick = getQueryData();
	 
	 
	 
	 function getQueryData(){ 
	
	   	var xhr = new XMLHttpRequest();
	   	xhr.open("POST", "SelectFindAll2", true);
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

</html>