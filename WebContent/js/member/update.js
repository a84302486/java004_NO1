function setUpdateData(servelet, ID, div, serveletLimit, botdiv) {

	var obj=document.getElementsByName("member");
		//<input type = 'radio' name = 'member' value ='帳號'>
	var selected;
	  for (var i=0; i<obj.length; i++) {
	    if (obj[i].checked) {
	    	//如果被選取了
	    	
	    	 selected = obj[i].value;
	    	 break;//只能單選
	      }
	    }
	
	if (selected == null) {
		//找不到選取的帳號 沒有回應
		return;
	} else {
		
	
			var idValue = selected;
			var divId = document.getElementById(div);// result

			var xhr = new XMLHttpRequest();
			xhr.open("POST", servelet, true);// send要傳參數一定要用POST
			xhr.setRequestHeader("Content-type",
					"application/x-www-form-urlencoded");

			var queryString = "Username="+selected;
			xhr.send(queryString);

			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {

					var validation_messages = JSON.parse(xhr.responseText);// 由servelet傳過來JSON格式的資料

					

			}

		}

	
}}
