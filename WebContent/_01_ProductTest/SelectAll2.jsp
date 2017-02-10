<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/styles.css' type="text/css" />

<script type="text/JavaScript">
 window.onload = function(){ 

	   	var xhr = new XMLHttpRequest();
	   	xhr.open("GET", "SelectFindAll2", true);
	   	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	   	xhr.send();
	   	xhr.onreadystatechange = function() {
		// 向伺服器提出的請求已經收到回應
	        if (xhr.readyState === 4) {
	        // status: HTTP通訊協定的狀態碼伺服器，
	        // 200表示Server成功的處理請求
	            if (xhr.status === 200) {
	          	// getResponseHeader: 取得回應內容的MIME Type
	                var type = xhr.getResponseHeader("Content-Type");   
	                // 判斷回應類型，這裡使用 JSON
	                 if (type.indexOf("application/json") === 0) {               
	                      var data = JSON.parse(xhr.responseText);
	                        if (data.coll) {
	                            document.getElementById("Result").innerHTML =
	                            	"<font color='red'>" + data + '</font> 您好，' + data ;
	                        } else {
	                            document.getElementById("Result").innerHTML = "資料錯誤";
	                        }
	                    }
	                } else {
	                    alert("發生錯誤1: " + xhr.status + ", " + xhr.responseText);
	                }
	            } 
	    	}
};
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