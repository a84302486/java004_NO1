function selectMenu(e) {
	window.open(e.options[e.selectedIndex].value);
}

//-------------------------------------------------------

function ajaxButtonTag(sendJsp, tag) {

	var tagId = document.getElementById(tag);
	// 步驟一: 新建XMLHttpRequest物件
	var xhr = new XMLHttpRequest();
	// 步驟二: 經由AJAX提出HTTP請求
	if (xhr != null) {
		xhr.onreadystatechange = function() {
			// 步驟三: 處理伺服器送回的回應資料
			if (xhr.readyState == 4 && xhr.status == 200) {
				tagId.innerHTML = "<h3>" + xhr.responseText + "</h3>";
			}
		}
		xhr.open('GET', sendJsp, true);
		xhr.send();
	} else {
		tagId.innerHTML = "<h1>您的瀏覽器不支援Ajax</h1>";
	}
}

//-------------------------------------------------------

//function getQueryData2(servelet) {
//	var usernameID = document.getElementById("Username");
//	var username = usernameID.value;
//	alert(username);
//	var xhr = new XMLHttpRequest();
//	xhr.open("POST", servelet, true);
//	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
//	xhr.send("Username=" + username);
//	xhr.onreadystatechange = function() {
//		if (xhr.readyState == 4 && xhr.status == 200) {
//			var content = "";
//			var data = JSON.parse(xhr.responseText);
//			alert(data);
//			
//			content += "<tr>;"
//			for (var i = 0; i < data.length; i++) {
//				for ( var name in data[i]) {
//					content += "<td>" + data[i].name + "</td>";
//				}
//			}
//
//			
//			content += "</tr>";
//			content += "<tr>;"
//
//			for (var i = 0; i < data.length; i++) {
//				for ( var key in data[i]) {
//					content += "<td>" + data[i].key + "</td>";
//				}
//			}
//			
//			content += "</tr>";
//			content += "</table>";
//			var divs = document.getElementById("result");
//			divs.innerHTML = content;
//		}
//	}
//}

//-------------------------------------------------------
function getQueryData(servelet) {

	var username = document.getElementById("Username").value;
	var divs = document.getElementById("result");

	var xhr = new XMLHttpRequest();
	xhr.open("POST", servelet, true);//send要傳參數一定要用POST
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

	var queryString = setQueryString();
	//xhr.send("Username=" + username);//request.getParameter("Username");
	xhr.send(queryString);
	//alert(queryString);

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {

			var validation_messages = JSON.parse(xhr.responseText);//由servelet傳過來JSON格式的資料		
			
			if(validation_messages == null){//找不到
				var content = "<font color='red'>"; 
				content += username +" couldn't find.";
				content += "</Font>";
				divs.innerHTML = content;
				return;
			}
			var content = "";

			content += "<table>";

			//欄位名稱
			for ( var key in validation_messages) {
				// skip loop if the property is from prototype
				if (!validation_messages.hasOwnProperty(key))
					continue;
				content += "<tr>";
				var obj = validation_messages[key];
				for ( var prop in obj) {
					// skip loop if the property is from prototype
					if (!obj.hasOwnProperty(prop))
						continue;

					content += "<td>" + prop + "</td>";
				}
				content += "</tr>";
				break;//欄位名稱只要一次
			}

			//每一筆資料
			for ( var key in validation_messages) {
				// skip loop if the property is from prototype
				if (!validation_messages.hasOwnProperty(key))
					continue;
				content += "<tr>";
				var obj = validation_messages[key];
				for ( var prop in obj) {
					// skip loop if the property is from prototype
					if (!obj.hasOwnProperty(prop))
						continue;

					content += "<td>" + obj[prop] + "</td>";
				}
				content += "</tr>";
			}

			content += "</table>";

			divs.innerHTML = content;
		}
	}
}

//-------------------------------------------------------
function setDeleteData(servelet) {

	if (confirm("確定要刪除嗎?")) {
		var divs = document.getElementById("result");
	
		var xhr = new XMLHttpRequest();
		xhr.open("POST", servelet, true);// send要傳參數一定要用POST
		xhr.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");

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
					for ( var key in validation_messages) {
						// skip loop if the property is from prototype
						if (!validation_messages.hasOwnProperty(key))
							continue;
						// content += "<tr>";
						var obj = validation_messages[key];
						for ( var prop in obj) {
							// skip loop if the property is from prototype
							if (!obj.hasOwnProperty(prop))
								continue;

							content += " " + obj[prop] + " ";
						}
						// content += "</tr>";
					}

					content += "</Font>";

					divs.innerHTML = content;
					document.getElementById("Username").value = "";
				} 
			}

		}
	}
}

//-------------------------------------------------------

function setQueryString() {
	queryString = "";
	var frm = document.forms[0];
	var numberElements = frm.elements.length;
	for (var i = 0; i < numberElements; i++) {
		if (i < numberElements - 1) {
			//            	alert(frm.elements[i].name);
			//            	alert(frm.elements[i].value);
			queryString += frm.elements[i].name + "="
					+ encodeURIComponent(frm.elements[i].value) + "&";
		} else {
			queryString += frm.elements[i].name + "="
					+ encodeURIComponent(frm.elements[i].value);
		}

	}
	return queryString;
}

//-------------------------------------------------------