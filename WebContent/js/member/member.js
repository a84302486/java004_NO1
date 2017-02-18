function doFirstIndex(){

	getQueryDataLimit('LimitSelect','resultIndex');
	
}


//-------------------------------------------------------

function selectMenu(e) {
	window.open(e.options[e.selectedIndex].value);
}

////-------------------------------------------------------

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

function DeleteButton(){
	  //新增按鈕
	  var NewButton = document.createElement("INPUT");
	  
	  //按鈕屬性
	  with(NewButton){
	    type = "Button";
	    style.position = "absolute";
	    style.top = 100;
	    style.left = 100;
	    style.width = 200;
	    style.height = 100;
	    style.id = "DeleteButton";
//	    style.fontSize = "16pt"; 
//	    style.borderStyle = "solid";
//	    style.borderColor = "#000000"; 
	    value = "確認刪除"; 
	  }
	  
	  //加入到畫面
	  document.body.appendChild(NewButton);
	  
	  //參數設定
	  //NewButton.XXX = "Clark";
	  
	  //click事件設定

	}

	//新的按鈕click事件處理
//	function Test(){
//	  alert(this.XXX);
//	}



function SeletButton(){
	  //新增按鈕
	  var NewButton = document.createElement("INPUT");
	  
	  //按鈕屬性
	  with(NewButton){
	    type = "Button";
	    style.position = "absolute";
	    style.top = 100;
	    style.left = 100;
	    style.width = 200;
	    style.height = 100;
//	    style.fontSize = "16pt"; 
//	    style.borderStyle = "solid";
//	    style.borderColor = "#000000"; 
	    value = "確認搜尋"; 
	  }
	  
	  //加入到畫面
	  document.body.appendChild(NewButton);
	  
	  //參數設定
	  //NewButton.XXX = "Clark";
	  
	  //click事件設定
	  NewButton.onclick = getQueryData('Select','resultIndex'); 
	}


////-------------------------------------------------------


function getQueryDataLimit(servelet, div) {

	// alert("Load!!");
	// var username = document.getElementById("Username").value;
	var divs = document.getElementById(div);

	var xhr = new XMLHttpRequest();
	xhr.open("GET", servelet, true);// send要傳參數一定要用POST
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

	xhr.send();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {

			var validation_messages = JSON.parse(xhr.responseText);// 由servelet傳過來JSON格式的資料
			if (validation_messages != null) {

				var content = "<h3>最新更新資料<br><br>";

				content += "<table>";

				// 欄位名稱
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
					break;// 欄位名稱只要一次
				}

				// 每一筆資料
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
}


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

//window.addEventListener('load',doFirst,false);
//document.onload=load("Load!!!");
//window.onload=getQueryDataLoad('SelectLimit');


//----------------------------------------------------


document.getElementById("DeleteButton").onclick = setDeleteData('Delete','DeleteUsername','result');
