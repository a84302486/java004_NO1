function setDeleteData(servelet,ID,div) {
	
	if (confirm("確定要刪除嗎?")) {
		
		var idValue = document.getElementById(ID).value;//Username
		var divId = document.getElementById(div);//result
	
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
				
				if (validation_messages != "true") {
					var content = "<font color='red'>";
					
					if(validation_messages == "false"){
						
						content += "刪除 "+idValue+" 發生錯誤 !!";
					}else if(validation_messages == "miss"){
						
						content += "找不到 "+idValue+"!";
					}else{
						
						content += "請輸入"+ID+"作刪除";
					}			
					content += "</Font>";
				
				} else{
					
					var content = "<font color='blue'>";					
					content += "刪除 "+idValue+" 成功";
					content += "</Font>";
				}
				
				divId.innerHTML = content;
				idValue = "";
			}

		}
		
//		getQueryDataLimit('LimitSelect','resultIndex');
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

