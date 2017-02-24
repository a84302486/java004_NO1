


//取得 checkbox 欄位的選取值
$('input:checkbox:checked').val();


//------------------------------------------------------
$(function(){
	// 預設顯示第一個 Tab
	var _showTab = 0;
	$('.abgne_tab').each(function(){
		// 目前的頁籤區塊
		var $tab = $(this);
 
		var $defaultLi = $('ul.tabs li', $tab).eq(_showTab).addClass('active');
		$($defaultLi.find('a').attr('href')).siblings().hide();
 
		// 當 li 頁籤被點擊時...
		// 若要改成滑鼠移到 li 頁籤就切換時, 把 click 改成 mouseover
		$('ul.tabs li', $tab).click(function() {
			// 找出 li 中的超連結 href(#id)
			var $this = $(this),_clickTab = $this.find('a').attr('href');
			// 把目前點擊到的 li 頁籤加上 .active, 並把兄弟元素中有 .active 的都移除 class
			$this.addClass('active').siblings('.active').removeClass('active');
			// 淡入相對應的內容並隱藏兄弟元素
			$(_clickTab).stop(false, true).fadeIn().siblings().hide();
 
			return false;
		}).find('a').focus(function(){
			this.blur();
		});
	});
});

//刪除Tab並跳回第一頁------------------------------------------------------
$(function(){
	//點擊X觸發事件
	$('ul.tabs li a i').click(function(){
		//找出對應的div#id並刪除
		var _getHerf = $(this).parent().attr('href');
		//找出被點擊X所對應的li並刪除
		$(this).parent().parent().remove();
		$(_getHerf).remove();
		//此語法會找出第一個a連結內的herf
		var _getfFstHerf = $('a').attr('href'); 
		//顯示找到的herf(此連結是連到div#id),顯示此id對應的div並隱藏其他div
		$(_getfFstHerf).stop(false, true).fadeIn().siblings().hide();
		//將預設顯示的li設為index=0(第一個li)顯示
		$('.abgne_tab').each(function(){
		var $tab = $(this),$defaultLi = $('ul.tabs li', $tab).eq(0).addClass('active');
		$($defaultLi.find('a').attr('href')).siblings().hide();
		});
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
				showResult.innerHTML = xhr.responseText ;
			}
		}
		xhr.open("POST", action, true);
		xhr.send();
	} else {
		showResult.innerHTML = "<h1>您的瀏覽器不支援Ajax</h1>";
	}
}

//Select讀取透過Servelet取出的Json資料,替換Section內容------------------------------
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

//Delete判斷是否刪除該筆資料,並由Servelet回傳是否成功的json字串,再顯示至畫面----------------
function getDeleteMessage(servelet) {	
	var productId = document.getElementById("productId").value;
	if((confirm("確定要刪除資料"+ productId +"嗎")))
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


//Insert判斷是否刪除該筆資料,並由Servelet回傳是否成功的json字串,再顯示至畫面----------------
function getInsertMessage(servelet) {	
		var xhr = new XMLHttpRequest();
		xhr.open("POST", servelet, true);
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhr.send(setQueryString());

		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var data = JSON.parse(xhr.responseText);
				var result = document.getElementById("insertResult");
				result.innerHTML = data;
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
//------------------------------------------------------