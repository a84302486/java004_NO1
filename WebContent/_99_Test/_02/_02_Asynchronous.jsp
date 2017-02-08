<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/styles.css' type="text/css" />
<meta charset="UTF-8">
<title>完整的Ajax程式</title>
</head>
<body>
<div class='center'>
<input type='submit' id='btnJSP1' value='Member查詢'>
<input type='Button' id='btnJSP2' value='刪除'>
<input type='Button' id='btnJSP3' value='修改'>
<input type='Button' id='btnJSP4' value='查詢'>


<hr>
<div id='resp'></div><p>
<script>
	var btnJSP1 = document.getElementById("btnJSP1");
	var div1 = document.getElementById("resp");
	btnJSP1.onclick = function() {
		// ajax的同步請求
		// 步驟一: 新建XMLHttpRequest物件
		var xhr = new XMLHttpRequest();
		// 步驟二: 經由AJAX提出HTTP請求
		if (xhr != null) {
			xhr.onreadystatechange = function(){
				// 步驟三: 處理伺服器送回的回應資料
				if  (xhr.readyState == 4 && xhr.status == 200) {
					div1.innerHTML = "<h1>" +  xhr.responseText + "</h1>";
				}
			}
			xhr.open('GET', 'SelectMember.jsp', true);
			xhr.send();
		} else {
			div1.innerHTML = "<h1>您的瀏覽器不支援Ajax</h1>";
		}
	}  
	
	var btnJSP2 = document.getElementById("btnJSP2");
	var div1 = document.getElementById("resp");
	btnJSP2.onclick = function() {
		// ajax的同步請求
		// 步驟一: 新建XMLHttpRequest物件
		var xhr = new XMLHttpRequest();
		// 步驟二: 經由AJAX提出HTTP請求
		if (xhr != null) {
			xhr.onreadystatechange = function(){
				// 步驟三: 處理伺服器送回的回應資料
				if  (xhr.readyState == 4 && xhr.status == 200) {
					div1.innerHTML = "<h1>" +  xhr.responseText + "</h1>";
				}
			}
			xhr.open('GET', 'SimpleJSPAjax.jsp', true);
			xhr.send();
		} else {
			div1.innerHTML = "<h1>您的瀏覽器不支援Ajax</h1>";
		}
	}   
	
	var btnJSP3 = document.getElementById("btnJSP3");
	var div1 = document.getElementById("resp");
	btnJSP3.onclick = function() {
		// ajax的同步請求
		// 步驟一: 新建XMLHttpRequest物件
		var xhr = new XMLHttpRequest();
		// 步驟二: 經由AJAX提出HTTP請求
		if (xhr != null) {
			xhr.onreadystatechange = function(){
				// 步驟三: 處理伺服器送回的回應資料
				if  (xhr.readyState == 4 && xhr.status == 200) {
					div1.innerHTML = "<h1>" +  xhr.responseText + "</h1>";
				}
			}
			xhr.open('GET', 'SimpleJSPAjax.jsp', true);
			xhr.send();
		} else {
			div1.innerHTML = "<h1>您的瀏覽器不支援Ajax</h1>";
		}
	}   
	
	var btnJSP4 = document.getElementById("btnJSP4");
	var div1 = document.getElementById("resp");
	btnJSP4.onclick = function() {
		// ajax的同步請求
		// 步驟一: 新建XMLHttpRequest物件
		var xhr = new XMLHttpRequest();
		// 步驟二: 經由AJAX提出HTTP請求
		if (xhr != null) {
			xhr.onreadystatechange = function(){
				// 步驟三: 處理伺服器送回的回應資料
				if  (xhr.readyState == 4 && xhr.status == 200) {
					div1.innerHTML = "<h1>" +  xhr.responseText + "</h1>";
				}
			}
			xhr.open('GET', 'SimpleJSPAjax.jsp', true);
			xhr.send();
		} else {
			div1.innerHTML = "<h1>您的瀏覽器不支援Ajax</h1>";
		}
	}   
	
	
</script>
<div id='control_Flow'>
<small>
按下"送出請求"按鈕後，瀏覽器向後端程式(/ch03/_02/SimpleJSPAjax.jsp)發出AJAX非同步請求
</small>
</div>


</div>    
</body>
</html>