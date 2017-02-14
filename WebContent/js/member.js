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

function getQueryData(servelet) {
//	var usernameID = document.getElementById("Username");
//	var username = usernameID.value;
//	if(usernameID!=null){
//		alert(username);
//	}
	var xhr = new XMLHttpRequest();
	xhr.open("GET", servelet, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {

			var content = "<table>" + "<tr><td>序號</td>" + "<td>定價</td>"
					+ "<td>名稱</td>" + "<td>成本</td>" + "<td>生產地</td>"
					+ "<td>保存期</td>" + "<td>供應商</td></tr>";

			var data = JSON.parse(xhr.responseText);
			for (var i = 0; i < data.length; i++) {
				content += "<tr><td>" + data[i].M_ID + "</td>" + "<td>"
						+ data[i].M_Username + "</td>" + "<td>" + data[i].M_Name
						+ "</td>" + "<td>" + data[i].avgCost + "</td>" + "<td>"
						+ data[i].oplace + "</td>" + "<td>" + data[i].slife
						+ "</td>" + "<td>" + data[i].suppierId + "</td></tr>";
			}
			content += "</table>";
			var divs = document.getElementById("result");
			divs.innerHTML = content;
		}
	}
}

window.addEventListener('load',getQueryData('Select'),false);