function indexdofirst(){

//	getQueryDataLimit('LimitSelect','resultIndex','M_ID');
	getQueryData('M_Username','Select','resultIndex','result','M_Username');
	
	document.getElementById('buttonremark').onclick = function(){
		alert("remark");
	}
	
	totalPages('TotalPages');
//	document.getElementById('buttonsearch').onclick = getQueryData('M_Username','Select','resultIndex','result','M_Username');

//	document.getElementById('buttondelete').onclick = setDeleteData('Delete','Username','resultIndex','LimitSelect','resultLimit');


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
				tagId.innerHTML =  xhr.responseText;
			}
		}
		xhr.open('POST', sendJsp, true);
		xhr.send();
	} else {
		tagId.innerHTML = "<h1>您的瀏覽器不支援Ajax</h1>";
	}
}



////-------------------------------------------------------


//function getQueryDataLimit(servelet, div ,first) {
//
//	 //alert("Load!!");
//	// var username = document.getElementById("Username").value;
//	var divs = document.getElementById(div);
//
//	var xhr = new XMLHttpRequest();
//	xhr.open("GET", servelet, true);// send要傳參數一定要用POST
//	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
//
//	xhr.send();
//
//	xhr.onreadystatechange = function() {
//		if (xhr.readyState == 4 && xhr.status == 200) {
//
//			var validation_messages = JSON.parse(xhr.responseText);// 由servelet傳過來JSON格式的資料
//			if (validation_messages != null) {
//
//				var content = "";
////				content += "<div><h4>最新更新資料</h4><br></div>";
////				content += "<form id='queryData'>";
//				content += "<table>";
//
//				// 欄位名稱
//				for ( var key in validation_messages) {
//					// skip loop if the property is from prototype
//					if (!validation_messages.hasOwnProperty(key))
//						continue;
//				
//					content += "<tr><td>#</td>";
//					var obj = validation_messages[key];
//					for ( var prop in obj) {
//						// skip loop if the property is from prototype
//						if (!obj.hasOwnProperty(prop))
//							continue;
//
//						content += "<td>" + prop + "</td>";
//					}
//					content += "</tr>";
//					break;// 欄位名稱只要一次
//				}
//
//				// 每一筆資料
//				for ( var key in validation_messages) {
//					// skip loop if the property is from prototype
//					if (!validation_messages.hasOwnProperty(key))
//						continue;
//					content += "<tr>";
//					var obj = validation_messages[key];
//					for ( var prop in obj) {
//						// skip loop if the property is from prototype
//						if (!obj.hasOwnProperty(prop))
//							continue;
//
//						if(prop == first){
//							
//							content += "<td width='1em'><input type = 'radio' name = 'radio'" + 
//												" value ="  + obj[prop] +"</td>";			
//						}
//						content += "<td>"+ obj[prop] + "</td>";
//					}
//					
//					
//					content += "</tr>";
//				}
//				content += "<button onclick=ajaxButtonTag(UpdateMember.jsp,resp);getQueryDataLimit(LimitSelect,resultIndex,M_ID); id='buttonupdate';>" 
//							+"<img src='../image/update.png'><br>修改</button>";
//				content += "	";
//				content += "<button onclick=ajaxButtonTag(DeleteMember.jsp,resp);getQueryDataLimit(LimitSelect,resultIndex,M_ID); id='buttondelete';>"
//							+"<img src='../image/delete.png'><br>刪除</button>";
////				content += "<br><br>";
//
//				content += "</table>";
////				content += "</form>";
//
//				divs.innerHTML = content;
//			}
//		}
//	}
//}


function setQueryString(formId) {
	queryString = "";
	//alert(formId);
	var frm = document.forms.namedItem(formId);
	var numberElements = frm.elements.length;
	for (var i = 0; i < numberElements; i++) {
		if (i < numberElements - 1) {
			            	//alert(frm.elements[i].name);
			            	//alert(frm.elements[i].value);
			queryString += frm.elements[i].name + "="
					+ encodeURIComponent(frm.elements[i].value) + "&";
		} else {
			queryString += frm.elements[i].name + "="
					+ encodeURIComponent(frm.elements[i].value);
		}

	}
	return queryString;
}



function totalPages(servelet){
	
	var xhr = new XMLHttpRequest();
	xhr.open("POST", servelet, true);//send要傳參數一定要用POST
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

	xhr.send();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {

			var validation_messages = JSON.parse(xhr.responseText);//由servelet傳過來JSON格式的資料		
			
			alert(validation_messages);
		}
	}
}


function pageBack(){
	
	var pageNoId = document.getElementById("pageNo");
	var num =  Number(pageNoId.value); 
	
	if(num >=2){
		pageNoId.value = num-1;
	}
	
	getQueryData('M_Username','Select','resultIndex','result','M_Username');
}

function pageNext(){
	
	var pageNoId = document.getElementById("pageNo");
	var num =  Number(pageNoId.value);  
	
	if(num >=1){
		pageNoId.value = num+1;
	}
	
	getQueryData('M_Username','Select','resultIndex','result','M_Username');
}


//----------------------------------------------------



window.addEventListener('load',indexdofirst,false);
