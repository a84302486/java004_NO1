function getJsp(jsp, sectionId) {
	var showResult = document.getElementById(sectionId);
	var xhr = new XMLHttpRequest(); // 步驟一: 新建XMLHttpRequest物件
	if (xhr != null) { // 步驟二: 經由AJAX提出HTTP請求
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) { // 步驟三: 處理伺服器送回的回應資料
				showResult.innerHTML = "<h3>" + xhr.responseText + "</h3>";
			}
		}
		xhr.open('GET', jsp, true);
		xhr.send();
	} else {
		showResult.innerHTML = "<h1>您的瀏覽器不支援Ajax</h1>";
	}
}

function getQueryData(servelet) {
	var xhr = new XMLHttpRequest();
	xhr.open("GET", servelet, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {

			var content = "<table>" + "<tr><td></td>" + "<td>序號</td>"
					+ "<td>定價</td>" + "<td>名稱</td>" + "<td>成本</td>"
					+ "<td>生產地</td>" + "<td>保存期</td>" + "<td>供應商</td></tr>";

			var data = JSON.parse(xhr.responseText);
			for (var i = 0; i < data.length; i++) {
				content += "<tr><td><input type=checkbox name = productId value=" + data[i].productId +"></td>"
						+ "<td>" + data[i].productId + "</td>"
						+ "<td>" + data[i].pgPrice   + "</td>"
						+ "<td>" + data[i].name      + "</td>"
						+ "<td>" + data[i].avgCost   + "</td>"
						+ "<td>" + data[i].oplace    + "</td>"
						+ "<td>" + data[i].slife     + "</td>" 
						+ "<td>" + data[i].suppierId + "</td></tr>";
			}
			content += "</table>";
			var divs = document.getElementById("showResult");
			divs.innerHTML = content;
		}
	}
}