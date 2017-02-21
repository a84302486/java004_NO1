function getQueryData(input,servelet,successdiv,errordiv,first) {
	
	//alert("getQueryData "+input+" "+servelet+" "+div);
	var username = document.getElementById(input).value;
	var successID = document.getElementById(successdiv);
	var errorID = document.getElementById(errordiv);
	
	var xhr = new XMLHttpRequest();
	xhr.open("POST", servelet, true);//send要傳參數一定要用POST
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

	var queryString = setQueryString('formSelect');
	//xhr.send("Username=" + username);//request.getParameter("Username");
	//alert("send before");
	xhr.send(queryString);
	//alert(queryString);

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {

			var validation_messages = JSON.parse(xhr.responseText);//由servelet傳過來JSON格式的資料		
			//alert(validation_messages);
			if(validation_messages == null){//找不到
				var content = "<font color='red'>"; 
				content += username +" 找不到!";
				content += "</Font>";
				errorID.innerHTML = content;
				return;
			}
			var content = "";
			
//			content += "<h3>搜尋結果<br></h3>";
			content += "<form>";
			content += "<table>";

			//欄位名稱
			for ( var key in validation_messages) {
				// skip loop if the property is from prototype
				if (!validation_messages.hasOwnProperty(key))
					continue;
				content += "<tr><td>選擇</td>";
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
					
					if(prop == first){
			
						content += "<td width='1em'><input type = 'radio' name = 'radio'" + 
											" value ="  + obj[prop] +"</td>";			
					}
					content += "<td>" + obj[prop] + "</td>";
				}
				content += "</tr>";
			}
			
			content += "<button onclick=ajaxButtonTag(UpdateMember.jsp,resp);getQueryDataLimit(LimitSelect,resultIndex,M_ID); id='buttonupdate';>"
				+"<img src='../image/update.png'><br>修改</button>";
			content += "<button onclick=ajaxButtonTag(DeleteMember.jsp,resp);getQueryDataLimit(LimitSelect,resultIndex,M_ID); id='buttondelete';>"
				+"<img src='../image/delete.png'><br>刪除</button>";
			
			content += "</table>";
			content += "</form>";
			
			errorID.innerHTML ="";
			successID.innerHTML = content;
			
			//alert("selet success");
		}
	}
}


//function setQueryString() {
//	queryString = "";
//	var frm = document.forms[0];
//	var numberElements = frm.elements.length;
//	for (var i = 0; i < numberElements; i++) {
//		if (i < numberElements - 1) {
//			//            	alert(frm.elements[i].name);
//			//            	alert(frm.elements[i].value);
//			queryString += frm.elements[i].name + "="
//					+ encodeURIComponent(frm.elements[i].value) + "&";
//		} else {
//			queryString += frm.elements[i].name + "="
//					+ encodeURIComponent(frm.elements[i].value);
//		}
//
//	}
//	return queryString;
//}

