
//點擊Text改變背景顏色------------------------------------------------------
$(function(){
$(':text').focus(function(){
	$(this).css('background-color','yellow')
			.css('font','normal 20px Tahoma');
	});
	$(':text').blur(function(){
		$(this).css('background-color','#fff')
				.css('font','normal 16px Tahoma');
	});						
});

//主選單下拉功能------------------------------------------------------
function optionsMenu(e){
	window.open(e.options[e.selectedIndex].value);
}

//載入頁面替換Section內容----------------------------------------------
function getAction(action, tagId) {
	var showResult = document.getElementById(tagId);
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

//讀取透過Servelet取出的Json資料,替換Section內容------------------------------
function getQueryData(servelet) {
	if(document.getElementById("productId")){
		var productId = document.getElementById("productId").value;
	}else{
		var productId = "";
	}
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

//判斷是否刪除該筆資料,並由Servelet回傳是否成功的json字串,再顯示至畫面----------------
function getMessage(servelet) {	
		var productId = document.getElementById("productId").value;
		if (confirm("確定要刪除嗎?")) {
		var xhr = new XMLHttpRequest();
		xhr.open("POST", servelet, true);
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhr.send("productId=" + productId);

		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var data = JSON.parse(xhr.responseText);
				var result = document.getElementById("deleteResult");
				result.innerHTML = data;
			}
		}
	}
}

//以下方法無使用------------------------------------------------------

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