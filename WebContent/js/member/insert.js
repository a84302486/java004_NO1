
function setInsertData(input, servelet, middiv) {

	var username = document.getElementById(input).value;
	var resultID = document.getElementById(middiv);
	//var botID = document.getElementById(botdiv);

	var xhr = new XMLHttpRequest();
	xhr.open("POST", servelet, true);// send要傳參數一定要用POST
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

	var queryString = setQueryString('formInsert');
	//alert(queryString);
	xhr.send(queryString);

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {

			var validation_messages = JSON.parse(xhr.responseText);// 由servelet傳過來JSON格式的資料
			//alert(xhr.responseText);
			if (validation_messages == 'Success') {
				//新增成功
				
				var content = "<font color='blue'>";
				content += username + "新增成功";
				content += "</Font>";
				resultID.innerHTML = content;

				// 清空輸入值
				var frm = document.forms[0];
				var numberElements = frm.elements.length;
				for (var i = 0; i < numberElements; i++) {

					frm.elements[i].value = "";

				}
				
				//getQueryDataLimit(serveletQuery,botdiv);
				//查詢最新更新資料

			} else {
				//新曾失敗
				
				var content = "";

				content += "<table>";
				content += "<tr>";
				content += "<font color='red'>";
				
				// 每一筆資料
				for ( var key in validation_messages) {
					// skip loop if the property is from prototype
					
					if (!validation_messages.hasOwnProperty(key))
						continue;

					var obj = validation_messages[key];
				
					for ( var prop in obj) {
						// skip loop if the property is from prototype
						if (!obj.hasOwnProperty(prop))
							continue;
						if(prop =="DML_Result"){
							alert(obj[prop]);
								//顯示錯誤原因
							break;
						}
						content += "<td width='15.625em'>" + obj[prop]
								+ "</td>";

					}

					content += "</font>";
					content += "</tr>";
					content += "</table>";

					resultID.innerHTML = content;

				}

			}
		}
	}
}


// -------------------------------------------------------






//-------------------------------------------------------

