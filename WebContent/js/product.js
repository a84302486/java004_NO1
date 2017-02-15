function getAction(action, sectionId) {
	var showResult = document.getElementById(sectionId);
	var xhr = new XMLHttpRequest(); // 步驟一: 新建XMLHttpRequest物件
	if (xhr != null) { // 步驟二: 經由AJAX提出HTTP請求
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) { // 步驟三: 處理伺服器送回的回應資料
				showResult.innerHTML = "<h3>" + xhr.responseText + "</h3>";
			}
		}
		xhr.open("POST", action, true);
		xhr.send();
	} else {
		showResult.innerHTML = "<h1>您的瀏覽器不支援Ajax</h1>";
	}
}

//------------------------------------------------------

function getQueryData(servelet) {
	var productId = document.getElementById("productId").value;
	var xhr = new XMLHttpRequest();
	xhr.open("POST", servelet, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("productId=" + productId);
	
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
			var result = document.getElementById("showResult");
			result.innerHTML = content;
		}
	}
}

//------------------------------------------------------

function setDeleteData(servelet) {

	if (confirm("確定要刪除嗎?")) {
		var divs = document.getElementById("result");
	
		var xhr = new XMLHttpRequest();
		xhr.open("POST", servelet, true);// send要傳參數一定要用POST
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");

		var queryString = setQueryString();
		// xhr.send("Username=" + username);//request.getParameter("Username");
		xhr.send(queryString);

		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {

				var validation_messages = JSON.parse(xhr.responseText);// 由servelet傳過來JSON格式的資料
				//alert(validation_messages);
				if (validation_messages != null) {
					var content = "<font color='blue'>";

					// 每一筆資料
					for( var key in validation_messages) {
						// skip loop if the property is from prototype
						if(!validation_messages.hasOwnProperty(key))
							continue;
						// content += "<tr>";
						var obj = validation_messages[key];
						for( var prop in obj) {
							// skip loop if the property is from prototype
							if (!obj.hasOwnProperty(prop))
								continue;

							content += " " + obj[prop] + " ";
						}
						// content += "</tr>";
					}
					content += "</Font>";
					divs.innerHTML = content;
					document.getElementById("productId").value = "";
				} 
			}
		}
	}
}

//------------------------------------------------------

function selectMenu(e){
	window.open(e.options[e.selectedIndex].value);
}