<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/styles.css'  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<!-- <Form Action="Select.do" method="POST"> -->
<div onclick="getQueryData('Select.do','Result')">
          	  輸入帳號查詢:
             <input type="text" name="Username" value="helloSnoopy" size="20" placeholder="不輸入搜尋全部" />
             <input type="submit" value="開始查詢" />
             
</div>
<div id="Result">
 Result
</div>
<!-- </Form > -->
<script>
		
		var tag1 = document.getElementById("resp");
		var tag2 = document.getElementById("connect");
		
		
		function ajaxButtonTag1(sendJsp) {
				
				// 步驟一: 新建XMLHttpRequest物件
				var xhr = new XMLHttpRequest();
				// 步驟二: 經由AJAX提出HTTP請求
				if (xhr != null) {
					xhr.onreadystatechange = function() {
						// 步驟三: 處理伺服器送回的回應資料
						if (xhr.readyState == 4 && xhr.status == 200) {
							tag1.innerHTML = "<h3>" + xhr.responseText
									+ "</h3>";
						}
					}
					xhr.open('GET', sendJsp, true);
					xhr.send();
				} else {
					tag1.innerHTML = "<h1>您的瀏覽器不支援Ajax</h1>";
				} 
			}
		
		
		 function getQueryData(fromJsp,htmlDiv){ 
				
			   	var xhr = new XMLHttpRequest();
			   	xhr.open("GET", fromJsp, true);
			   	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			   	xhr.send();
			   	xhr.onreadystatechange = function() {
					if (xhr.readyState == 4 && xhr.status == 200) {
						var content = "<table border='1'; height: 10%; width: 100%;>";
						var data = JSON.parse(xhr.responseText);
						//data.length
						for(var i=0; i < 3; i++){
							content += "<tr><td>" + data[i].M_Username + "</td>" + 
							               "<td>" + data[i].M_ID + "</td>" +
							               "<td>" + data[i].M_Name + "</td>" ;
							           "</tr>";    
						}
						content += "</table>";
						var div = document.getElementById(htmlDiv);
						div.innerHTML = content;
				}
			}
		}
		
</script>
</body>

</html>